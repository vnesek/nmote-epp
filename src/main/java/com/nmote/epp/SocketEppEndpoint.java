package com.nmote.epp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.xml.bind.JAXBException;

import org.ietf.epp.epp.Epp;

public class SocketEppEndpoint extends EppEndpoint {

	public SocketEppEndpoint() {
	}

	@Override
	public synchronized void close() throws IOException {
		log.debug("Closing connection to {}", getURI());
		super.close();
		try {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
			if (socket != null) {
				socket.close();
			}
		} finally {
			socket = null;
			input = null;
			output = null;
			outBuffer = null;
		}
	}

	public boolean isConnected() {
		return socket != null && socket.isConnected();
	}

	@Override
	public void logout() throws EppException, IOException, JAXBException {
		super.logout();
		close();
	}

	@Override
	public Epp send(Epp request) throws IOException, JAXBException, EppException {
		autoConnect();

		try {
			// Write request
			synchronized (output) {
				if (outBuffer == null) {
					outBuffer = new ByteArrayOutputStream(4096);
				}
				outBuffer.reset();
				writeEpp(request, outBuffer);
				output.writeInt(outBuffer.size() + 4);
				outBuffer.writeTo(output);

				if (log.isTraceEnabled()) {
					log.trace("Sent {}", outBuffer.toString("UTF-8"));
				}
				output.flush();
			}

			// Read response
			synchronized (input) {
				final int length = input.readInt() - 4;
				if (length <= 0 || length > getMaxResponseSize()) {
					throw new IOException("invalid EPP response size: " + length);
				}
				InputStream rin;
				if (log.isTraceEnabled()) {
					if (inBuffer == null || inBuffer.length < length) {
						inBuffer = new byte[length + 4000];
					}
					input.readFully(inBuffer, 0, length);
					log.trace("Received {}", new String(inBuffer, 0, length, "UTF-8"));
					rin = new ByteArrayInputStream(inBuffer, 0, length);
				} else {
					rin = new LengthLimitedInputStream(input, length);
				}
				Epp response = (Epp) readEpp(rin);
				if (response.getResponse() != null && response.getResponse().getResults() != null) {
					EppException.throwOnError(response.getResponse().getResults());
				}
				return response;
			}
		} catch (IOException ioe) {
			log.error("IO error, closing socket", ioe);
			close();
			throw ioe;
		}
	}

	@Override
	public synchronized EppResponse<Void> login(LoginCommand command) throws EppException, IOException, JAXBException {
		lastLoginCommand = null;

		// Check if login was successful, close on error
		try {
			EppResponse<Void> response = super.login(command);

			// We'll remember successful login command to use it for autoConnect
			lastLoginCommand = command;

			return response;
		} catch (EppException e) {
			close();
			throw e;
		}
	}

	private LoginCommand lastLoginCommand;

	protected synchronized void autoConnect() throws IOException, JAXBException, EppException {
		if (!isConnected()) {
			// Open socket to EPP server
			log.debug("Connecting to {}", getURI());
			socket = createSocket();
			input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

			if (lastLoginCommand != null) {
				login(lastLoginCommand);
			}
		}
	}

	/**
	 * Creates a socket through {@link SocketFactory}. Override to set
	 * additional socket options.
	 *
	 * @return new socket instance.
	 * @throws IOException
	 */
	protected Socket createSocket() throws IOException {
		socket = getSocketFactory().createSocket(getHost(), getPort());
		return socket;
	}

	protected String getHost() {
		String host = getURI().getHost();
		return host;
	}

	protected int getPort() {
		int port = getURI().getPort();
		if (port == -1) {
			port = 700;
		}
		return port;
	}

	private byte[] inBuffer;
	private DataInputStream input;
	private ByteArrayOutputStream outBuffer;
	private DataOutputStream output;
	private Socket socket;
}
