/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.epp.hr;

import hr.dns.epp.contact.ContactDataCreate;
import hr.dns.epp.contact.ContactType;
import hr.dns.epp.contact.Create;

import com.nmote.epp.contact.CreateContactCommand;

public class HrCreateContactCommand extends CreateContactCommand<HrCreateContactCommand> {

	public HrCreateContactCommand in(String in) {
		addExtension();
		contact.setIn(in);
		return getThis();
	}

	public HrCreateContactCommand type(ContactType type) {
		addExtension();
		contact.setType(type);
		return getThis();
	}

	public HrCreateContactCommand org() {
		return type(ContactType.ORG);
	}

	public HrCreateContactCommand person() {
		return type(ContactType.PERSON);
	}

	private void addExtension() {
		if (contact == null) {
			contact = new ContactDataCreate();
			Create create = new Create();
			create.setContact(contact);
			extension(create);
		}
	}

	private ContactDataCreate contact;
}
