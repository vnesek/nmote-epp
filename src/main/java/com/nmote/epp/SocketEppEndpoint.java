/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.epp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;

import javax.net.SocketFactory;
import javax.xml.bind.JAXBException;

import org.ietf.epp.epp.Epp;
import org.ietf.epp.epp.ResultType;

import com.nmote.epp.command.LoginCommand;

public class SocketEppEndpoint extends EppEndpoint {

	public SocketEppEndpoint() {
	}

	@Override
	public synchronized void close() throws IOException {
		log.debug("Closing connection to {}", getURI());
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
			closeInternal();
		}
	}

	@Override
	public <R> EppResponse<R> execute(EppCommand<?, R, ?> command) throws EppException, IOException, JAXBException {
		try {
			return super.execute(command);
		} finally {
			if (command instanceof LoginCommand) {
				// We'll remember (successful?) login command to use it for
				// next autoConnect
				lastLoginCommand = command;
			}
		}
	}

	public boolean isConnected() {
		return socket != null && socket.isConnected();
	}

	@Override
	public synchronized Epp send(Epp request) throws IOException, JAXBException, EppException {
		autoConnect();

		try {
			// Write request
			sendEpp(request);

			return receiveEpp();
		} catch (EOFException eof) {
			log.error("EOF socket closed unexpectedly");
			closeInternal();
			throw eof;
		} catch (IOException ioe) {
			log.error("IO error, closing socket", ioe);
			close();
			throw ioe;
		}
	}

	protected synchronized void autoConnect() throws IOException, JAXBException, EppException {
		if (!connecting) {
			connecting = true;

			try {
				if (isConnected() && isEnabled("keepAlive")) {
					long sinceLastActivity = System.currentTimeMillis() - lastActivity;
					if (sinceLastActivity / 1000 >= keepAliveInterval) {
						try {
							Epp request = new Epp();
							request.setHello("");
							sendEpp(request);
							receiveEpp();
						} catch (IOException ignored) {
							closeInternal();
							log.debug("Hello failed, reconnecting... " + ignored);
						}
					}
				}

				if (!isConnected()) {
					// Open socket to EPP server
					log.debug("Connecting to {}", getURI());
					socket = createSocket();
					input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
					output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

					// Read greeting
					receiveEpp();

					if (lastLoginCommand != null) {
						execute(lastLoginCommand);
					}
				}
			} finally {
				connecting = false;
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
		socket.setSoTimeout(180 * 1000);
		socket.setKeepAlive(true);
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

	private void closeInternal() throws IOException {
		input = null;
		output = null;
		socket = null;
		outBuffer = null;
		super.close();
	}

	private Epp receiveEpp() throws IOException, JAXBException, EppException {
		// Read response (or greeting)
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
			lastActivity = System.currentTimeMillis();
			Epp response = (Epp) readEpp(rin);
			if (response.getResponse() != null) {
				List<ResultType> results = response.getResponse().getResults();
				if (results != null) {
					// Check if we should close connection
					for (ResultType result : results) {
						// Results [2500,+] make server close a connection, so
						// we close a client socket as well
						if (result.getCode() >= 2500 && result.getCode() < 2600) {
							close();
							break;
						}
					}
					EppException.throwOnError(response.getResponse().getResults());
				}
			}
			return response;
		}
	}

	private void sendEpp(Epp request) throws IOException, JAXBException, EppException {
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
	}

	private int keepAliveInterval = 30;
	private long lastActivity;
	private boolean connecting;
	private byte[] inBuffer;
	private DataInputStream input;
	private EppCommand<?, ?, ?> lastLoginCommand;
	private ByteArrayOutputStream outBuffer;
	private DataOutputStream output;
	private Socket socket;
}
