package com.nmote.epp.hr;

import hr.dns.epp.contact.ObjectFactory;

import javax.xml.bind.JAXBElement;

import com.nmote.epp.EppInfoCommand;

public class HrEppCommands {

	private static class HrRegistrar extends EppInfoCommand<JAXBElement<Object>, Void, HrRegistrar> {

		public HrRegistrar() {
			command(new ObjectFactory().createRegistrar(""));
		}

		@Override
		protected HrRegistrar getThis() {
			return this;
		}
	}

	public static EppInfoCommand<?, Void, ?> infoRegistrar() {
		return new HrRegistrar();
	}
}
