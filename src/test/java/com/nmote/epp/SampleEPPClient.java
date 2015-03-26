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

import org.ietf.epp.domain.Check;
import org.ietf.epp.domain.Info;
import org.ietf.epp.domain.InfoNameType;
import org.ietf.epp.epp.CommandType;
import org.ietf.epp.epp.Epp;
import org.ietf.epp.epp.ReadWriteType;

public class SampleEPPClient {

	public static void main(String[] args) throws Exception {
		EppEndpoint see = EppEndpoint.create("epp://localhost:700") //
				.service("hr.dns.epp.contact") //
				.socketFactory(createSocketFactory()) //
				.clientID("Regica2-EPP") //
				.password("hC8oQV951");

		hello(see);
		//checkDomain(see);
		logout(see);
		// infoDomain(see);

		see.close();
	}

	protected static void checkDomain(EppEndpoint see) throws Exception {
		Epp request = new Epp();
		CommandType cmd = new CommandType();
		{
			ReadWriteType rw = new ReadWriteType();
			{
				Check check = new Check();
				check.getNames().add("domena1.hr");
				check.getNames().add("domena2.hr");
				rw.getAnies().add(check);
			}
			cmd.setCheck(rw);
		}
		request.setCommand(cmd);
		see.send(request);
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

	protected static void hello(EppEndpoint see) throws Exception {
		Epp request = new Epp();
		request.setHello("");
		see.send(request);
	}

	protected static void logout(EppEndpoint see) throws Exception {
		Epp request = new Epp();
		CommandType command = new CommandType();
		command.setLogout("");
		request.setCommand(command);
		see.send(request);
	}

	protected static void infoDomain(EppEndpoint see) throws Exception {
		Epp request = new Epp();
		CommandType cmd = new CommandType();
		{
			ReadWriteType rw = new ReadWriteType();
			{
				Info info = new Info();
				{
					InfoNameType infoName = new InfoNameType();
					infoName.setValue("dns.hr");
					info.setName(infoName);
				}
				rw.getAnies().add(info);
			}
			cmd.setInfo(rw);
		}
		request.setCommand(cmd);
		see.send(request);
	}
}
