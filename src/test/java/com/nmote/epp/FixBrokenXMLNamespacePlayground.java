package com.nmote.epp;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.ietf.epp.domain.Check;
import org.ietf.epp.epp.CommandType;
import org.ietf.epp.epp.Epp;
import org.ietf.epp.epp.ReadWriteType;

public class FixBrokenXMLNamespacePlayground {

	public static void main(String[] args) throws Exception {
		final Epp request = new Epp();
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

		(new EppEndpoint() {
			{

				XMLOutputFactory xof = XMLOutputFactory.newFactory();
				XMLStreamWriter xsw = xof.createXMLStreamWriter(System.out);
				xsw = new EppXMLStreamWriter(xsw);

				getMarshaller().marshal(request, xsw);
			}

			@Override
			public Epp send(Epp request) throws EppException, IOException, JAXBException {
				throw new UnsupportedOperationException();
			}
		}).close();

	}

}
