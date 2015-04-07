package com.nmote.epp;

import hr.dns.epp.contact.Info;

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
import org.ietf.epp.epp.GreetingType;

import com.nmote.epp.hr.HrEppCommand;

import static com.nmote.epp.EppCommand.*;
import static com.nmote.epp.contact.PostalInfoBuilder.name;
import static com.nmote.epp.hr.HrEppCommand.infoRegistrar;

public class SampleEPPClient {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		EppEndpoint epp = EppEndpoint.create("epp://localhost:700") //
				.contactService() // Enable EPP contact service
				.domainService() // Enable EPP domain service
				.service("hr.dns.epp.contact") // Enable custom extension/service
				.socketFactory(createSocketFactory());

		epp.execute(login("Regica2-EPP", "hC8oQV951"));

		if (false) {
			GreetingType greeting = epp.hello();
			System.out.println(greeting.getSvID());
		}

		if (false) {
			EppResponse<Void> info = epp.execute(infoRegistrar());
			System.out.println(info.getExtension(Info.class).getRegistrar().getName());
		}

		if (false) {
			EppResponse<ChkData> response = epp.execute(checkDomain("domena1.hr", "domena2.hr"));
			for (CheckType cd : response.getSingleResponse().getCds()) {
				System.out.println(cd.getName().getValue() + " " + cd.getName().isAvail());
			}
		}

		if (false) {
			EppResponse<InfData> response = epp.execute(infoDomain("test-regica-8307.com.hr"));
			System.out.println(response.getSingleResponse().getRegistrant());
		}

		if (false) {
			EppResponse<org.ietf.epp.contact.CreData> response = epp.execute(HrEppCommand.createContact().id(RandomStringUtils.randomNumeric(6)).auth("ignored")
					.email("pero@foo.bar")
					.postalInfo(name("Pero Perić").city("Zagreb").pc("10000").street("Bez broja").cc("HR")) //
					.voice("+385.123456789").fax("+385.123456789").in("1234567809992").person());
			System.out.println(response.getSingleResponse().getId());
		}

		if (false) {
			EppResponse<org.ietf.epp.domain.CreData> response = epp.execute(createDomain("test-" + RandomStringUtils.randomNumeric(5) + "-regica.com.hr").auth("ignored")
					.registrant("43732").admin("43732").billing("43732").period(1));
			// test-76045-regica.com.hr 2016-04-06T22:00:00Z
			System.out.println(response.getSingleResponse().getExDate());
		}

		if (false) {
			EppResponse<org.ietf.epp.domain.RenData> response = epp.execute(renewDomain("test-22831-regica.com.hr").period(1).currentExpire("2016-04-07T22:00:00Z"));
			System.out.println(response.getSingleResponse().getExDate());
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
