package com.nmote.epp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.ietf.epp.epp.CommandType;
import org.ietf.epp.epp.Epp;

public class SocketEppEndpoint extends AbstractEppEndpoint implements Closeable {

	public SocketEppEndpoint() {
	}

	@Override
	public synchronized void close() throws IOException {
		marshaller = null;
		unmarshaller = null;
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

	public String getHostPort() {
		return hostPort;
	}

	@Override
	public Epp send(Epp request) throws IOException, JAXBException, EppException {
		autoConnect();

		assignClientTransactionID(request);

		// Write request
		synchronized (out) {
			marshaller.marshal(request, buffer);
			out.writeInt(buffer.size() + 4);
			buffer.writeTo(out);
			buffer.reset();
			out.flush();
		}

		if (log.isDebugEnabled()) {
			log.debug("Sent {}", ToStringBuilder.reflectionToString(request, eppStringStyle));
		}

		// Read response
		Object response;
		synchronized (in) {
			int length = in.readInt() - 4;
			LengthLimitedInputStream lin = new LengthLimitedInputStream(in, length);
			response = unmarshaller.unmarshal(lin);
		}

		if (log.isDebugEnabled()) {
			log.debug("Received {}", ToStringBuilder.reflectionToString(response, eppStringStyle));
		}

		return (Epp) response;
	}

	public SocketEppEndpoint hostPort(String hostPort) {
		this.hostPort = hostPort;
		return this;
	}

	protected String getHost() {
		int colon = hostPort.indexOf(':');
		String host;
		if (colon == -1) {
			host = hostPort;
		} else {
			host = hostPort.substring(0, colon);
		}
		return host;
	}

	protected int getPort() {
		int colon = hostPort.indexOf(':');
		int port;
		if (colon == -1) {
			port = 700;
		} else {
			port = Integer.parseInt(hostPort.substring(colon + 1));
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
	private String hostPort;
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
}
