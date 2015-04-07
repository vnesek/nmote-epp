package com.nmote.epp.hr;

import hr.dns.epp.contact.ContactData;
import hr.dns.epp.contact.ContactType;
import hr.dns.epp.contact.Update;

import com.nmote.epp.contact.UpdateContactCommand;

public class HrUpdateContactCommand extends UpdateContactCommand<HrUpdateContactCommand> {

	public HrUpdateContactCommand in(String in) {
		addExtension();
		contact.setIn(in);
		return getThis();
	}

	public HrUpdateContactCommand type(ContactType type) {
		addExtension();
		contact.setType(type);
		return getThis();
	}

	public HrUpdateContactCommand org() {
		return type(ContactType.ORG);
	}

	public HrUpdateContactCommand person() {
		return type(ContactType.PERSON);
	}

	private void addExtension() {
		if (contact == null) {
			contact = new ContactData();
			Update update = new Update();
			update.setContact(contact);
			extension(update);
		}
	}

	private ContactData contact;
}
