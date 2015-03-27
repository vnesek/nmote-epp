package com.nmote.epp;

import hr.dns.epp.contact.ContactType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

import javax.net.SocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.RandomStringUtils;
import org.ietf.epp.epp.ResponseType;
import org.ietf.epp.eppcom.PwAuthInfoType;

public class SampleEPPClient {

	public static void main(String[] args) throws Exception {
		EppEndpoint epp = EppEndpoint.create("epp://localhost:700") //
				//.fixBrokenNamespaceScoping(true)
				.contactService() // Enable EPP contact service
				.domainService() // Enable EPP domain service
				.service("hr.dns.epp.contact") // Enable custom extension
				.socketFactory(createSocketFactory()) //
				.clientID("Regica2-EPP") // Set username
				.password("hC8oQV951"); // Set password

		epp.hello();
		createContact(epp);
		//String checkDomainXml;
		//checkDomainXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <epp xmlns=\"urn:ietf:params:xml:ns:epp-1.0\" xmlns:domain=\"urn:ietf:params:xml:ns:domain-1.0\"> <command> <check> <domain:check> <domain:name>domena1.hr</domain:name> <domain:name>domena2.hr</domain:name> </domain:check> </check> <clTRID>05106558-94309643</clTRID> </command> </epp> ";
		//checkDomainXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <epp xmlns:domain=\"urn:ietf:params:xml:ns:domain-1.0\" xmlns=\"urn:ietf:params:xml:ns:epp-1.0\" xmlns:host=\"urn:ietf:params:xml:ns:host-1.0\"> <command><check><domain:check><domain:name>domena1.hr</domain:name><domain:name>domena2.hr</domain:name></domain:check></check><clTRID>9c8e3d84-360f-4edc-9bff-472bd007e2e4</clTRID></command></epp>";
		//checkDomain(epp.sendInstead(checkDomainXml.getBytes("UTF-8")));
		checkDomain(epp);
		//infoDomain(epp);

		epp.logout();
	}

	protected static ResponseType checkDomain(EppEndpoint epp) throws EppException, IOException, JAXBException {
		return epp.check(new org.ietf.epp.domain.Check() {
			{
				getNames().add("domena1.hr");
				getNames().add("domena2.hr");
			}
		});
	}

	protected static ResponseType createDomain(EppEndpoint epp) throws EppException, IOException, JAXBException {
		return epp.create(new org.ietf.epp.domain.Create() {
			{
				setName("test-regica-" + RandomStringUtils.randomNumeric(4) + ".hr");
				// setPeriod(value);
				// getNames().add("domena2.hr");
			}
		});
	}

	protected static ResponseType createContact(EppEndpoint epp) throws EppException, IOException, JAXBException {
		return epp.create(new org.ietf.epp.contact.Create() {
			{
				setId(RandomStringUtils.randomNumeric(6));
				setEmail(getId() + "@idijot.hr");
				{
					org.ietf.epp.contact.PostalInfoType pi = new org.ietf.epp.contact.PostalInfoType();
					pi.setType(org.ietf.epp.contact.PostalInfoEnumType.INT);
					pi.setName("Pero Perić");
					{
						org.ietf.epp.contact.AddrType addr = new org.ietf.epp.contact.AddrType();
						addr.setCity("Zagreb");
						addr.setPc("10000");
						addr.getStreets().add("Nemam pojma");
						addr.setCc("HR");
						pi.setAddr(addr);
					}
					getPostalInfos().add(pi);
				}
				{
					org.ietf.epp.contact.E164Type number = new org.ietf.epp.contact.E164Type();
					number.setValue("+385.123456789");
					setVoice(number);
				}
				{
					org.ietf.epp.contact.AuthInfoType auth = new org.ietf.epp.contact.AuthInfoType();
					{
						PwAuthInfoType pw = new PwAuthInfoType();
						pw.setValue("ignored");
						auth.setPw(pw);
					}
					setAuthInfo(auth);
				}
			}
		}, new hr.dns.epp.contact.Create() {
			{
				hr.dns.epp.contact.ContactDataCreate cdc = new hr.dns.epp.contact.ContactDataCreate();
				cdc.setType(ContactType.PERSON);
				cdc.setIn("1234567809992");
				setContact(cdc);
			}
		});
	}

	protected static ResponseType infoDomain(EppEndpoint epp) throws EppException, IOException, JAXBException {
		return epp.info(new org.ietf.epp.domain.Info() {
			{
				org.ietf.epp.domain.InfoNameType infoName = new org.ietf.epp.domain.InfoNameType();
				infoName.setValue("dns.hr");
				setName(infoName);
			}
		});
	}

	protected static SocketFactory createSocketFactory() throws GeneralSecurityException, IOException {
		KeyStore ks = KeyStore.getInstance("JKS");
		try (InputStream in = new FileInputStream("data/jssecacerts")) {
			ks.load(in, "changeit".toCharArray());
		}
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		tmf.init(ks);
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		kmf.init(ks, "changeit".toCharArray());
		SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

		SocketFactory socketFactory = ctx.getSocketFactory();
		return socketFactory;
	}
}
