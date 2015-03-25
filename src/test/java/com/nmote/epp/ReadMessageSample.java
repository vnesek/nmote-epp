package com.nmote.epp;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ReadMessageSample {


	public static void main(String[] args) throws Exception {
		String classPath = "org.ietf.epp.epp:org.ietf.epp.contact:org.ietf.epp.domain:org.ietf.epp.eppcom:org.ietf.epp.host:org.ietf.epp.secdns:hr.dns.epp.contact";
		JAXBContext jc = JAXBContext.newInstance(classPath);
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		String src = "/hr/dns/epp/info-contact-response-1.xml";
		InputStream in = ReadMessageSample.class.getResourceAsStream(src);
		Object result = unmarshaller.unmarshal(in);
		System.out.println(ToStringBuilder.reflectionToString(result, new RecursiveToStringStyle()));
	}
}
