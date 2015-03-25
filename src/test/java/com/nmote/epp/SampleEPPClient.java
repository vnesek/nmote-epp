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

import org.ietf.epp.epp.Epp;

public class SampleEPPClient {

	public static void main(String[] args) throws Exception {
		SocketEppEndpoint see = new SocketEppEndpoint();
		see.socketFactory(createSocketFactory());
		// see.hostPort("registrar-test2.carnet.hr:700");
		see.hostPort("localhost:700");
		see.clientID("Regica2-EPP");
		see.password("hC8oQV951");

		Epp request = new Epp();
		request.setHello("");
		see.send(request);
		see.close();

		// byte[] hello =
		// "<?xml version='1.0' encoding='utf-8'?> <epp xmlns='urn:ietf:params:xml:ns:epp-1.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'><hello /></epp>".getBytes("utf-8");
	}

	protected static SocketFactory createSocketFactory() throws GeneralSecurityException, IOException {
		KeyStore ks = KeyStore.getInstance("JKS");
		try (InputStream in = new FileInputStream("jssecacerts")) {
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
