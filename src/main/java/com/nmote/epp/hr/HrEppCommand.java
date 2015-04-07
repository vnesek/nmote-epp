package com.nmote.epp.hr;

import hr.dns.epp.contact.ObjectFactory;

import javax.xml.bind.JAXBElement;

import com.nmote.epp.command.InfoCommand;

public class HrEppCommand {

	private static class HrRegistrar extends InfoCommand<JAXBElement<Object>, Void, HrRegistrar> {

		public HrRegistrar() {
			command(new ObjectFactory().createRegistrar(""));
		}
	}

	public static HrCreateContactCommand createContact() {
		return new HrCreateContactCommand();
	}

	public static InfoCommand<?, Void, ?> infoRegistrar() {
		return new HrRegistrar();
	}

	public static HrUpdateContactCommand updateContact() {
		return new HrUpdateContactCommand();
	}

	public static HrUpdateContactCommand updateContact(String id) {
		return updateContact().id(id);
	}

}
