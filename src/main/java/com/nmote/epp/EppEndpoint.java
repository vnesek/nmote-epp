package com.nmote.epp;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.net.SocketFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.ietf.epp.epp.CommandType;
import org.ietf.epp.epp.Epp;
import org.ietf.epp.epp.ExtAnyType;
import org.ietf.epp.epp.LoginType;
import org.ietf.epp.epp.ReadWriteType;
import org.ietf.epp.epp.ResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class EppEndpoint implements Closeable {

	@SuppressWarnings("resource")
	public static EppEndpoint create(String uri) throws URISyntaxException {
		if (!uri.startsWith("epp://")) {
			throw new IllegalArgumentException("Unsupported protocol " + uri);
		}
		return new SocketEppEndpoint().uri(uri);
	}

	private ExtAnyType newExtAnyType(EppCommand<?, ?, ?> command) {
		ExtAnyType result;
		List<Object> exts = command.getExtensions(this);
		if (exts != null && exts.size() > 0) {
			result = new ExtAnyType();
			result.getAnies().addAll(exts);
		} else {
			result = null;
		}
		return result;
	}

	private static ExtAnyType newExtAnyType(Object... exts) {
		ExtAnyType result;
		if (exts.length > 0) {
			result = new ExtAnyType();
			for (Object ext : exts) {
				result.getAnies().add(ext);
			}
		} else {
			result = null;
		}
		return result;
	}

	private ReadWriteType newReadWriteType(EppCommand<?, ?, ?> command) {
		ReadWriteType rw = new ReadWriteType();
		rw.getAnies().addAll(command.getCommands(this));
		return rw;
	}

	private static ReadWriteType newReadWriteType(Object command) {
		ReadWriteType rw = new ReadWriteType();
		rw.getAnies().add(command);
		return rw;
	}

	protected EppEndpoint() {
		jaxbContext("org.ietf.epp.epp:org.ietf.epp.eppcom:org.ietf.epp.secdns");
	}

	public <R> EppResponse<R> check(EppCheckCommand<?, R, ?> command) throws EppException, IOException, JAXBException {
		CommandType cmd = new CommandType();
		cmd.setCheck(newReadWriteType(command));
		return sendInternal(command, cmd);
	}

	public <R> EppResponse<R> info(EppInfoCommand<?, R, ?> command) throws EppException, IOException, JAXBException {
		CommandType cmd = new CommandType();
		cmd.setInfo(newReadWriteType(command));
		return sendInternal(command, cmd);
	}

	public ResponseType check(Object command, Object... exts) throws EppException, IOException, JAXBException {
		Epp request = new Epp();
		CommandType cmd = new CommandType();
		cmd.setCheck(newReadWriteType(command));
		cmd.setExtension(newExtAnyType(exts));
		request.setCommand(cmd);
		return send(request).getResponse();
	}

	/**
	 * Sets a function reference, called when endpoint needs to assign client
	 * transaction id. If not set, random UUID is generated.
	 *
	 * @param clientTransactionID
	 *            supplier of client transaction ids
	 * @return this
	 */
	public EppEndpoint clientTransactionID(Supplier<String> clientTransactionID) {
		this.clientTransactionID = clientTransactionID;
		return this;
	}

	@Override
	public void close() throws IOException {
		marshaller = null;
		unmarshaller = null;
	}

	public EppEndpoint contactService() {
		return service("org.ietf.epp.contact");
	}

	public ResponseType create(Object command, Object... exts) throws EppException, IOException, JAXBException {
		Epp request = new Epp();
		CommandType cmd = new CommandType();
		cmd.setCreate(newReadWriteType(command));
		cmd.setExtension(newExtAnyType(exts));
		request.setCommand(cmd);
		return send(request).getResponse();
	}

	public ResponseType delete(Object command, Object... exts) throws EppException, IOException, JAXBException {
		Epp request = new Epp();
		CommandType cmd = new CommandType();
		cmd.setDelete(newReadWriteType(command));
		cmd.setExtension(newExtAnyType(exts));
		request.setCommand(cmd);
		return send(request).getResponse();
	}

	public EppEndpoint domainService() {
		return service("org.ietf.epp.domain");
	}

	public EppEndpoint fixBrokenNamespaceScoping(boolean fixBrokenNamespaceScoping) {
		this.fixBrokenNamespaceScoping = fixBrokenNamespaceScoping;
		return this;
	}

	public JAXBContext getJAXBContext() throws JAXBException {
		if (jaxbContext == null) {
			// Build a class path
			String classPath = jaxbClassPath + ':' + //
					getServices().stream().map(EppService::getPackageName).sorted().collect(Collectors.joining(":"));
			log.debug("Using JAXB class path {}", classPath);
			jaxbContext = JAXBContext.newInstance(classPath);
		}

		return jaxbContext;
	}

	public Marshaller getMarshaller() throws JAXBException {
		if (marshaller == null) {
			marshaller = getJAXBContext().createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		}
		return marshaller;
	}

	public int getMaxResponseSize() {
		return maxResponseSize;
	}

	public Set<EppService> getServices() {
		return services;
	}

	public SocketFactory getSocketFactory() {
		if (socketFactory == null) {
			socketFactory = SocketFactory.getDefault();
		}
		return socketFactory;
	}

	public Unmarshaller getUnmarshaller() throws JAXBException {
		if (unmarshaller == null) {
			unmarshaller = jaxbContext.createUnmarshaller();
		}
		return unmarshaller;
	}

	public URI getURI() {
		return uri;
	}

	public void hello() throws EppException, IOException, JAXBException {
		Epp request = new Epp();
		request.setHello("");
		send(request);
	}

	public EppEndpoint hostService() {
		return service("org.ietf.epp.host");
	}

	public ResponseType info(Object command, Object... exts) throws EppException, IOException, JAXBException {
		Epp request = new Epp();
		CommandType cmd = new CommandType();
		cmd.setInfo(newReadWriteType(command));
		cmd.setExtension(newExtAnyType(exts));
		request.setCommand(cmd);
		return send(request).getResponse();
	}

	public EppEndpoint jaxbContext(JAXBContext jaxbContext) {
		this.jaxbContext = jaxbContext;
		return this;
	}

	public EppEndpoint jaxbContext(String classPath) {
		if (classPath == null) {
			throw new NullPointerException("jaxbClassPath is null");
		}
		this.jaxbClassPath = classPath;
		return this;
	}

	public EppResponse<Void> login(LoginCommand command) throws EppException, IOException, JAXBException {
		Epp request = new Epp();
		CommandType cmd = new CommandType();
		cmd.setLogin((LoginType) command.getCommands(this).get(0));
		request.setCommand(cmd);
		Epp response = send(request);
		return new EppResponse<Void>(response.getResponse());
	}

	public void logout() throws EppException, IOException, JAXBException {
		Epp request = new Epp();
		CommandType command = new CommandType();
		command.setLogout("");
		request.setCommand(command);
		send(request);
	}

	public void maxResponseSize(int size) {
		if (size < 4096) {
			throw new IllegalArgumentException("maxResponseSize < 4096: " + size);
		}
		this.maxResponseSize = size;
	}

	public Epp readEpp(InputStream in) throws IOException, JAXBException {
		return (Epp) getUnmarshaller().unmarshal(in);
	}

	public ResponseType renew(Object command, Object... exts) throws EppException, IOException, JAXBException {
		Epp request = new Epp();
		CommandType cmd = new CommandType();
		cmd.setRenew(newReadWriteType(command));
		cmd.setExtension(newExtAnyType(exts));
		request.setCommand(cmd);
		return send(request).getResponse();
	}

	public abstract Epp send(Epp request) throws EppException, IOException, JAXBException;

	public EppEndpoint sendInstead(byte[] request) {
		sendInstead.set(request);
		return this;
	}

	public EppEndpoint service(String packageName) {
		services.add(new EppService(packageName));
		return this;
	}

	public EppEndpoint service(String packageName, String namespaceURI) {
		services.add(new EppService(packageName, namespaceURI));
		return this;
	}

	public EppEndpoint socketFactory(SocketFactory socketFactory) {
		this.socketFactory = socketFactory;
		return this;
	}

	public ResponseType update(Object command, Object... exts) throws EppException, IOException, JAXBException {
		Epp request = new Epp();
		CommandType cmd = new CommandType();
		cmd.setUpdate(newReadWriteType(command));
		cmd.setExtension(newExtAnyType(exts));
		request.setCommand(cmd);
		return send(request).getResponse();
	}

	public EppEndpoint uri(String uri) throws URISyntaxException {
		this.uri = new URI(uri);
		return this;
	}

	public EppEndpoint uri(URI uri) {
		this.uri = uri;
		return this;
	}

	public void writeEpp(Epp request, OutputStream out) throws IOException, JAXBException {
		// If client called send instead to work around EPP marshaling issues
		byte[] sendInstead = getSendInstead();
		if (sendInstead != null) {
			out.write(sendInstead);
			return;
		}

		assignClientTransactionID(request);

		if (fixBrokenNamespaceScoping) {
			try {
				// Fix for broken handling of namespaces on .hr EPP registry
				XMLStreamWriter writer = new EppXMLStreamWriter(xmlOutputFactory.createXMLStreamWriter(out));
				getMarshaller().marshal(request, writer);
				writer.close();
			} catch (XMLStreamException xse) {
				log.error("Marshaling problem", xse);
				throw new IOException("XML marshaling failed", xse);
			}
		} else {
			// Optimal method, doesn't work because of broken servers
			getMarshaller().marshal(request, out);
		}
	}

	protected String newClientTransactionID() {
		return clientTransactionID.get();
	}

	private void assignClientTransactionID(Epp request) {
		if (clientTransactionID != null && //
				request.getCommand() != null && //
				request.getCommand().getClTRID() == null) {
			request.getCommand().setClTRID(clientTransactionID.get());
		}
	}

	private byte[] getSendInstead() {
		byte[] result = sendInstead.get();
		sendInstead.remove();
		return result;
	}

	private <R> EppResponse<R> sendInternal(EppCommand<?, R, ?> command, CommandType cmd) throws EppException,
			IOException, JAXBException {
		Epp request = new Epp();
		cmd.setExtension(newExtAnyType(command));
		request.setCommand(cmd);
		ResponseType response = send(request).getResponse();
		return new EppResponse<R>(response);
	}

	protected final Logger log = LoggerFactory.getLogger(getClass());

	private Supplier<String> clientTransactionID = () -> UUID.randomUUID().toString();
	private boolean fixBrokenNamespaceScoping;
	private String jaxbClassPath;
	private JAXBContext jaxbContext;
	private Marshaller marshaller;
	private int maxResponseSize = 64 * 1024;
	private ThreadLocal<byte[]> sendInstead = new ThreadLocal<>();
	private Set<EppService> services = new HashSet<>();
	private SocketFactory socketFactory;
	private Unmarshaller unmarshaller;
	private URI uri;
	private XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
}
