package com.nmote.epp;

import hr.dns.epp.contact.Info;
import hr.dns.epp.contact.MessageData;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

import javax.net.SocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.ietf.epp.domain.CheckType;
import org.ietf.epp.domain.ChkData;
import org.ietf.epp.domain.InfData;
import org.ietf.epp.domain.StatusValueType;
import org.ietf.epp.epp.GreetingType;

import com.nmote.epp.hr.HrEppCommand;

import static com.nmote.epp.EppCommand.*;
import static com.nmote.epp.contact.PostalInfoBuilder.*;
import static com.nmote.epp.hr.HrEppCommand.infoRegistrar;

public class SampleEPPClient {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		EppEndpoint epp = EppEndpoint.create("epp://localhost:700") //
				//.enable("keepCurrentExpireTimezone")
				.contactService() // Enable EPP contact service
				.domainService() // Enable EPP domain service
				.service("hr.dns.epp.contact") // Enable custom
												// extension/service
				.socketFactory(createSocketFactory());

		epp.execute(login("Regica2-EPP", "hC8oQV951"));

		// Hello -> Greeting
		if (false) {
			GreetingType greeting = epp.hello();
			System.out.println(greeting.getSvID());
		}

		// Info registrar (.hr extension)
		if (true) {
			EppResponse<Void> response = epp.execute(infoRegistrar());
			Info info = response.getExtension(Info.class);
			System.out.println(info.getRegistrar().getName());
		}

		// Check domain
		if (false) {
			EppResponse<ChkData> response = epp.execute(checkDomain("domena1.hr", "domena2.hr"));
			for (CheckType cd : response.getSingleResponse().getCds()) {
				System.out.println(cd.getName().getValue() + " " + cd.getName().isAvail());
			}
		}

		// Info domain
		if (false) {
			EppResponse<InfData> response = epp.execute(infoDomain("test-regica-8307.com.hr"));
			System.out.println(response.getSingleResponse().getRegistrant());
		}

		// Create contact
		if (false) {
			EppResponse<org.ietf.epp.contact.CreData> response = epp.execute(HrEppCommand.createContact()
					.id(RandomStringUtils.randomNumeric(6)).auth("ignored").email("pero@foo.bar")
					.postalInfo(name("Pero Perić").city("Zagreb").pc("10000").street("Bez broja").cc("HR")) //
					.voice("+385.123456789").fax("+385.123456789").in("35488677401").person());
			System.out.println(response.getSingleResponse().getId());
		}

		// Update contact
		if (false) {
			epp.execute(HrEppCommand
					.updateContact("44527")
					.email("pero" + RandomStringUtils.randomNumeric(3) + "@foo.bar")
					.postalInfo(
							name("Pero Perić").city("Zagreb").pc("10000")
									.street("Bez broja " + RandomStringUtils.randomNumeric(2)).cc("HR")));
			epp.execute(infoContact(("44527")));
		}

		// Create domain
		if (false) {
			String name = "test-" + RandomStringUtils.randomNumeric(5) + "-regica.com.hr";
			EppResponse<org.ietf.epp.domain.CreData> response = epp.execute(createDomain(
					name).auth("ignored")
					.registrant("44527").admin("44527").billing("44527").period(1));
			// test-76045-regica.com.hr 2016-04-06T22:00:00Z
			System.err.println(response.getSingleResponse().getExDate());

			EppResponse<InfData> response2 = epp.execute(infoDomain(name));
			System.err.println(response2.getSingleResponse().getRoid());
		}

		// Delete contact
		if (false) {
			// Create dummy contact
			EppResponse<org.ietf.epp.contact.CreData> response = epp.execute(HrEppCommand.createContact()
					.id(RandomStringUtils.randomNumeric(6)).auth("ignored").email("pero@foo.bar")
					.postalInfo(name("Pero Perić").city("Zagreb").pc("10000").street("Bez broja").cc("GB")) //
					.voice("+385.123456789").fax("+385.123456789").in("GB 568 6304 14000").person());
			String contactId = response.getSingleResponse().getId();

			// Now, delete it
			EppResponse<Void> response2 = epp.execute(deleteContact(contactId));
			System.out.println(response2);
		}

		// Renew domain
		if (false) {
			EppResponse<org.ietf.epp.domain.RenData> response = epp.execute(renewDomain("test-84836-regica.com.hr")
					.period(1).currentExpire("2017-05-17T22:00:00Z"));
			System.out.println(response.getSingleResponse().getExDate());
		}

		// Info contact
		if (false) {
			EppResponse<org.ietf.epp.contact.InfData> response = epp.execute(infoContact("43732"));
			System.out.println(response.getSingleResponse().getVoice().getValue());
			hr.dns.epp.contact.Info info = response.getExtension(hr.dns.epp.contact.Info.class);
			System.out.println(info.getContact().getIn());
		}

		// Update domain
		if (false) {
			epp.execute(updateDomain("test-22831-regica.com.hr").registrant("43732").addNs("ns1.foo.hr")
					.addStatus(StatusValueType.CLIENT_TRANSFER_PROHIBITED));
			EppResponse<org.ietf.epp.domain.InfData> response = epp.execute(infoDomain("test-22831-regica.com.hr"));
		}

		// Poll 1
		if (false) {
			EppResponse<Object> response = epp.execute(poll());
			System.out.println(response);

			EppQueuedMessage msg = response.getQueuedMessage();
			if (msg != null) {
				MessageData data = response.getResponse(MessageData.class);
				System.out.println(data.getType());

				// Acknowledge
				epp.execute(poll().acknowledge(msg));
			}
		}

		// Poll 2
		if (false) {
			EppEndpoint epp2 = EppEndpoint.create("epp://localhost:700").contactService().domainService()
					.service("hr.dns.epp.contact").socketFactory(createSocketFactory());
			epp2.execute(login("Regica1-EPP", "8E5Q8519F"));

			EppResponse<Object> response = epp2.execute(poll());
			System.err.println(response);

			epp2.execute(logout());
		}

		// Transfer domain
		if (false) {
			EppEndpoint epp2 = EppEndpoint.create("epp://localhost:700").contactService().domainService()
					.service("hr.dns.epp.contact").socketFactory(createSocketFactory());
			epp2.execute(login("Regica1-EPP", "8E5Q8519F"));

			// Create dummy contact
			EppResponse<org.ietf.epp.contact.CreData> response1 = epp2.execute(HrEppCommand.createContact()
					.id(RandomStringUtils.randomNumeric(6)).auth("ignored").email("vnesek@nmote.com")
					.postalInfo(name("Vjeko Nesek").city("Zagreb").pc("10000").street("Bez broja").cc("HR")) //
					.voice("+385.123456789").fax("+385.123456789").in("1234567809992").person());
			String contactId = response1.getSingleResponse().getId();
			System.err.println("Contact " + contactId);

			// Create dummy domain
			String name = "test-" + RandomStringUtils.randomNumeric(5) + "-dummy.com.hr";
			EppResponse<org.ietf.epp.domain.CreData> response2 = epp2.execute(createDomain(name).auth("ignored")
					.registrant(contactId).admin(contactId).billing(contactId).period(1));
			System.err.println("Domain " + name);
			System.err.println("Expires " + response2.getSingleResponse().getExDate());

			// Transfer
			EppResponse<org.ietf.epp.domain.TrnData> response3 = epp.execute(transferDomain(name).request());
			System.err.println("Transfer " + response3);

			epp2.execute(logout());
		}

		// Transfer query
		if (false) {
			String name = "test-64271-dummy.com.hr";
			EppResponse<org.ietf.epp.domain.TrnData> response3 = epp.execute(transferDomain(name).query());
			System.err.println("Transfer " + response3);
		}

		epp.execute(logout());
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
