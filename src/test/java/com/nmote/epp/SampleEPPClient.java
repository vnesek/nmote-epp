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
import org.ietf.epp.domain.ContactAttrType;
import org.ietf.epp.domain.HostAttrType;
import org.ietf.epp.domain.NsType;
import org.ietf.epp.domain.PUnitType;
import org.ietf.epp.domain.PeriodType;
import org.ietf.epp.epp.ResponseType;
import org.ietf.epp.eppcom.PwAuthInfoType;
import org.ietf.epp.host.IpType;

public class SampleEPPClient {

	public static void main(String[] args) throws Exception {
		EppEndpoint epp = EppEndpoint.create("epp://localhost:700") //
				.contactService() // Enable EPP contact service
				.domainService() // Enable EPP domain service
				.service("hr.dns.epp.contact") // Enable custom extension
				.socketFactory(createSocketFactory()) //
				.clientID("Regica2-EPP") // Set username
				.password("hC8oQV951"); // Set password

		//epp.hello();
		// ResponseType response = createContact(epp);
		// String contactId = ((org.ietf.epp.contact.CreData)
		// response.getResData().getAnies().get(0)).getId();
		// System.err.println(contactId);
		// checkDomain(epp);
		infoDomain(epp);
		//createDomain(epp);

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
				setName("test-regica-" + RandomStringUtils.randomNumeric(4) + ".com.hr");
				{
					PeriodType pt = new PeriodType();
					pt.setUnit(PUnitType.Y);
					pt.setValue(1);
					setPeriod(pt);
				}
				{
					NsType ns = new NsType();
					for (int i = 1; i < 3; ++i) {
						HostAttrType ha = new HostAttrType();
						ha.setHostName("ns" + i + "." + getName());
						{
							org.ietf.epp.host.AddrType a = new org.ietf.epp.host.AddrType();
							a.setIp(IpType.V_4);
							a.setValue("1.2.3." + i);
							ha.getHostAddrs().add(a);
						}
						ns.getHostAttrs().add(ha);
					}
					setNs(ns);
					setRegistrant("43703");
					{
						org.ietf.epp.domain.ContactType ct = new org.ietf.epp.domain.ContactType();
						ct.setType(ContactAttrType.ADMIN);
						ct.setValue("43703");
						getContacts().add(ct);
					}
					{
						org.ietf.epp.domain.ContactType ct = new org.ietf.epp.domain.ContactType();
						ct.setType(ContactAttrType.TECH);
						ct.setValue("43703");
						getContacts().add(ct);
					}
					{
						org.ietf.epp.domain.AuthInfoType auth = new org.ietf.epp.domain.AuthInfoType();
						{
							PwAuthInfoType pw = new PwAuthInfoType();
							pw.setValue("ignored");
							auth.setPw(pw);
						}
						setAuthInfo(auth);
					}
				}
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
				infoName.setValue("test-regica-8307.com.hr");
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
