package com.nmote.epp;

import java.util.UUID;
import java.util.function.Supplier;

import javax.net.SocketFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.ietf.epp.epp.CredsOptionsType;
import org.ietf.epp.epp.Epp;
import org.ietf.epp.epp.ExtURIType;
import org.ietf.epp.epp.LoginSvcType;
import org.ietf.epp.epp.LoginType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractEppEndpoint implements EppEndpoint {

	/**
	 * {@link ToStringStyle} used to log EPP messages.
	 */
	public static ToStringStyle eppStringStyle = new RecursiveToStringStyle() {
		private static final long serialVersionUID = 1L;

		{
			setUseShortClassName(true);
			setUseIdentityHashCode(false);
		}
	};

	private static String newClientTransactionID() {
		return UUID.randomUUID().toString();
	}

	public AbstractEppEndpoint() {
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
			String classPath = "org.ietf.epp.epp:org.ietf.epp.contact:org.ietf.epp.domain:org.ietf.epp.eppcom:org.ietf.epp.host:org.ietf.epp.secdns:hr.dns.epp.contact";
			jaxbContext = JAXBContext.newInstance(classPath);
		}

		marshaller = jaxbContext.createMarshaller();
		unmarshaller = jaxbContext.createUnmarshaller();
	}

	/**
	 * Prepare socket factory.
	 */
	protected void setupSocketFactory() {
		if (socketFactory == null) {
			socketFactory = SocketFactory.getDefault();
		}
	}

	protected Supplier<String> clientTransactionID = AbstractEppEndpoint::newClientTransactionID;
	protected JAXBContext jaxbContext;
	protected Logger log = LoggerFactory.getLogger(getClass());
	protected Supplier<LoginType> login = this::newLogin;
	protected Marshaller marshaller;
	protected SocketFactory socketFactory;
	protected Unmarshaller unmarshaller;
	private String clientID;
	private String password;

}
