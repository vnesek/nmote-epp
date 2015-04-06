package com.nmote.epp.hr;

import hr.dns.epp.contact.ContactDataCreate;
import hr.dns.epp.contact.ContactType;
import hr.dns.epp.contact.Create;

import com.nmote.epp.CreateContactCommand;

public class HrCreateContactCommand extends CreateContactCommand<HrCreateContactCommand> {

	public HrCreateContactCommand() {
		Create create = new Create();
		create.setContact(contact);
		extension(create);
	}

	public HrCreateContactCommand in(String in) {
		contact.setIn(in);
		return getThis();
	}

	public HrCreateContactCommand type(ContactType type) {
		contact.setType(type);
		return getThis();
	}

	public HrCreateContactCommand org() {
		return type(ContactType.ORG);
	}

	public HrCreateContactCommand person() {
		return type(ContactType.PERSON);
	}

	private ContactDataCreate contact = new ContactDataCreate();
}
