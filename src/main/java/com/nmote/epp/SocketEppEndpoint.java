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

import org.ietf.epp.epp.CommandType;
import org.ietf.epp.epp.Epp;

public class SocketEppEndpoint extends AbstractEppEndpoint {

	public SocketEppEndpoint() {
	}

	@Override
	public synchronized void close() throws IOException {
		super.close();
		try {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			if (socket != null) {
				socket.close();
			}
		} finally {
			socket = null;
			in = null;
			out = null;
		}
	}

	@Override
	public Epp send(Epp request) throws IOException, JAXBException, EppException {
		autoConnect();

		assignClientTransactionID(request);

		try {
			// Write request
			synchronized (out) {
				marshaller.marshal(request, buffer);
				out.writeInt(buffer.size() + 4);
				buffer.writeTo(out);

				if (log.isTraceEnabled()) {
					log.trace("Sent {}", buffer.toString("UTF-8"));
				}

				buffer.reset();
				out.flush();
			}

			// Read response
			Object response;
			synchronized (in) {
				int length = in.readInt() - 4;
				if (length <= 0 || length > getMaxResponse()) {
					throw new IOException("invalid EPP response size: " + length);
				}
				InputStream responseIn;
				if (log.isTraceEnabled()) {
					byte[] responseBuffer = new byte[length];
					in.readFully(responseBuffer);
					log.trace("Received {}", new String(responseBuffer, "UTF-8"));
					responseIn = new ByteArrayInputStream(responseBuffer);
				} else {
					responseIn = new LengthLimitedInputStream(in, length);
				}
				response = unmarshaller.unmarshal(responseIn);
			}

			return (Epp) response;
		} catch (IOException ioe) {
			log.error("IO error, closing socket", ioe);
			close();
			throw ioe;
		}
	}

	protected String getHost() {
		String host = uri.getHost();
		return host;
	}

	protected int getPort() {
		int port = uri.getPort();
		if (port == -1) {
			port = 700;
		}
		return port;
	}

	protected synchronized void autoConnect() throws IOException, JAXBException, EppException {
		if (!isConnected()) {
			setupJaxb();
			setupSocketFactory();

			// Open socket to EPP server
			socket = createSocket();
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

			// Send login command
			Epp request = new Epp();
			CommandType cmd = new CommandType();
			cmd.setLogin(login.get());
			request.setCommand(cmd);
			Epp response = send(request);

			// Check if login was successful, close on error
			try {
				EppException.throwOnError(response);
			} catch (EppException e) {
				close();
				throw e;
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
		socket = socketFactory.createSocket(getHost(), getPort());
		return socket;
	}

	public boolean isConnected() {
		return socket != null && socket.isConnected();
	}

	private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
}
