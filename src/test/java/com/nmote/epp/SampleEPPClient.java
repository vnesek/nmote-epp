package com.nmote.epp;

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

import org.ietf.epp.domain.Check;
import org.ietf.epp.domain.Info;
import org.ietf.epp.domain.InfoNameType;

public class SampleEPPClient {

	public static void main(String[] args) throws Exception {
		EppEndpoint see = EppEndpoint.create("epp://localhost:700") //
				.contactService() //
				.domainService() //
				.service("hr.dns.epp.contact") //
				.socketFactory(createSocketFactory()) //
				.clientID("Regica2-EPP") //
				.password("hC8oQV951");

		see.hello();
		// check(see);
		// info(see);
		see.logout();
	}

	protected static void check(EppEndpoint see) throws EppException, IOException, JAXBException {
		see.check(new Check() {
			{
				getNames().add("domena1.hr");
				getNames().add("domena2.hr");
			}
		});
	}

	protected static void info(EppEndpoint see) throws EppException, IOException, JAXBException {
		see.info(new Info() {
			{
				InfoNameType infoName = new InfoNameType();
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
