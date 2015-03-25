package com.nmote.epp;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.net.SocketFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.ietf.epp.epp.CredsOptionsType;
import org.ietf.epp.epp.Epp;
import org.ietf.epp.epp.ExtURIType;
import org.ietf.epp.epp.LoginSvcType;
import org.ietf.epp.epp.LoginType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractEppEndpoint implements EppEndpoint {

	private static String newClientTransactionID() {
		return UUID.randomUUID().toString();
	}

	@SuppressWarnings("resource")
	public static AbstractEppEndpoint create(String uri) throws URISyntaxException {
		return new SocketEppEndpoint().uri(uri);
	}


	protected AbstractEppEndpoint() {
		service("org.ietf.epp.epp");
		service("org.ietf.epp.contact");
		service("org.ietf.epp.domain");
		service("org.ietf.epp.eppcom");
		service("org.ietf.epp.host");
		service("org.ietf.epp.secdns");
	}

	public AbstractEppEndpoint clientID(String clientID) {
		this.clientID = clientID;
		return this;
	}

	/**
	 * Sets a function reference, called when endpoint needs to assign client
	 * transaction id. If not set, random UUID is generated.
	 *
	 * @param clientTransactionID
	 *            supplier of client transaction ids
	 * @return this
	 */
	public AbstractEppEndpoint clientTransactionID(Supplier<String> clientTransactionID) {
		this.clientTransactionID = clientTransactionID;
		return this;
	}

	public String getClientID() {
		return clientID;
	}

	public JAXBContext getJAXBContext() {
		return jaxbContext;
	}

	public int getMaxResponse() {
		return maxResponse;
	}

	public String getPassword() {
		return password;
	}

	public SocketFactory getSocketFactory() {
		return socketFactory;
	}

	public AbstractEppEndpoint jaxbContext(JAXBContext jaxbContext) {
		this.jaxbContext = jaxbContext;
		return this;
	}

	/**
	 * Sets a function reference, called when endpoint needs to perform a login.
	 * If not set, newLogin() is called to prepare a login command.
	 *
	 * @param login
	 *            supplier of EPP Login commands
	 * @return this
	 */
	public AbstractEppEndpoint login(Supplier<LoginType> login) {
		this.login = login;
		return this;
	}

	public void maxResponse(int maxResponse) {
		if (maxResponse < 4096) {
			throw new IllegalArgumentException("maxResponse < 4096: " + maxResponse);
		}
		this.maxResponse = maxResponse;
	}

	public LoginType newLogin() {
		LoginType login = new LoginType();
		login.setClID(getClientID());
		login.setPw(getPassword());
		{
			CredsOptionsType credOpts = new CredsOptionsType();
			credOpts.setLang("en");
			credOpts.setVersion("1.0");
			login.setOptions(credOpts);
		}
		{
			LoginSvcType svcs = new LoginSvcType();
			svcs.getObjURIs().add("urn:ietf:params:xml:ns:domain-1.0");
			svcs.getObjURIs().add("urn:ietf:params:xml:ns:contact-1.0");
			{
				ExtURIType ext = new ExtURIType();
				ext.getExtURIs().add("http://www.dns.hr/epp/hr-1.0");
				svcs.setSvcExtension(ext);
			}
			login.setSvcs(svcs);
		}
		return login;
	}

	public AbstractEppEndpoint password(String password) {
		this.password = password;
		return this;
	}

	public AbstractEppEndpoint socketFactory(SocketFactory socketFactory) {
		this.socketFactory = socketFactory;
		return this;
	}

	protected void assignClientTransactionID(Epp request) {
		if (clientTransactionID != null && //
				request.getCommand() != null && //
				request.getCommand().getClTRID() == null) {
			request.getCommand().setClTRID(clientTransactionID.get());
		}
	}

	/**
	 * SetupJAXBContext and (un)marshallers.
	 *
	 * @throws JAXBException
	 */
	protected void setupJaxb() throws JAXBException {
		if (jaxbContext == null) {
			// Build a class path
			String classPath = getServices().stream().map(EppService::getPackageName).sorted().collect(Collectors.joining(":"));
			jaxbContext = JAXBContext.newInstance(classPath);
		}

		marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		unmarshaller = jaxbContext.createUnmarshaller();
	}

	@Override
	public void close() throws IOException {
		marshaller = null;
		unmarshaller = null;
	}

	/**
	 * Prepare socket factory.
	 */
	protected void setupSocketFactory() {
		if (socketFactory == null) {
			socketFactory = SocketFactory.getDefault();
		}
	}

	public AbstractEppEndpoint service(String packageName) {
		services.add(new EppService(packageName));
		return this;
	}

	public AbstractEppEndpoint service(String packageName, String namespaceURI) {
		services.add(new EppService(packageName, namespaceURI));
		return this;
	}

	public URI getURI() {
		return uri;
	}

	public AbstractEppEndpoint uri(String uri) throws URISyntaxException {
		this.uri = new URI(uri);
		return this;
	}

	public AbstractEppEndpoint uri(URI uri) {
		this.uri = uri;
		return this;
	}

	public Set<EppService> getServices() {
		return services;
	}

	protected URI uri;
	private Set<EppService> services = new HashSet<>();
	protected Supplier<String> clientTransactionID = AbstractEppEndpoint::newClientTransactionID;
	protected JAXBContext jaxbContext;
	protected Logger log = LoggerFactory.getLogger(getClass());
	protected Supplier<LoginType> login = this::newLogin;
	protected Marshaller marshaller;
	protected SocketFactory socketFactory;
	protected Unmarshaller unmarshaller;
	private String clientID;
	private int maxResponse = 64 * 1024;
	private String password;
}
