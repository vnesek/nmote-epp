/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.epp.domain;

import org.ietf.epp.domain.AuthInfoType;
import org.ietf.epp.domain.ContactAttrType;
import org.ietf.epp.domain.ContactType;
import org.ietf.epp.domain.CreData;
import org.ietf.epp.domain.Create;
import org.ietf.epp.domain.HostAttrType;
import org.ietf.epp.domain.NsType;
import org.ietf.epp.domain.PUnitType;
import org.ietf.epp.domain.PeriodType;
import org.ietf.epp.eppcom.PwAuthInfoType;
import org.ietf.epp.host.AddrType;
import org.ietf.epp.host.IpType;

import com.nmote.epp.command.CreateCommand;

public class CreateDomainCommand<T extends CreateDomainCommand<T>> extends CreateCommand<Create, CreData, T> {

	public CreateDomainCommand() {
		command(create);
	}

	public T name(String name) {
		create.setName(name);
		return getThis();
	}

	public T period(int period) {
		PeriodType pt = new PeriodType();
		pt.setUnit(PUnitType.Y);
		pt.setValue(period);
		create.setPeriod(pt);
		return getThis();
	}

	public T ns(String name, String... address) {
		NsType ns = create.getNs();
		if (ns == null) {
			ns = new NsType();
			create.setNs(ns);
		}

		HostAttrType ha = new HostAttrType();
		ha.setHostName(name);
		for (String ip : address) {
			AddrType a = new AddrType();
			// TODO auto detect IP address type
			a.setIp(IpType.V_4);
			a.setValue(ip);
			ha.getHostAddrs().add(a);
		}
		ns.getHostAttrs().add(ha);
		return getThis();
	}

	public T registrant(String id) {
		create.setRegistrant(id);
		return getThis();
	}

	public T admin(String id) {
		if (id != null) {
			org.ietf.epp.domain.ContactType ct = new org.ietf.epp.domain.ContactType();
			ct.setType(ContactAttrType.ADMIN);
			ct.setValue(id);
			create.getContacts().add(ct);
		}
		return getThis();
	}

	public T tech(String id) {
		if (id != null) {
			org.ietf.epp.domain.ContactType ct = new org.ietf.epp.domain.ContactType();
			ct.setType(ContactAttrType.TECH);
			ct.setValue(id);
			create.getContacts().add(ct);
		}
		return getThis();
	}

	public T billing(String id) {
		if (id != null) {
			ContactType ct = new ContactType();
			ct.setType(ContactAttrType.BILLING);
			ct.setValue(id);
			create.getContacts().add(ct);
		}
		return getThis();
	}

	public T auth(String authInfo) {
		return auth(authInfo, null);
	}

	public T auth(String authInfo, String roid) {
		AuthInfoType auth = new AuthInfoType();
		{
			PwAuthInfoType pw = new PwAuthInfoType();
			pw.setRoid(roid);
			pw.setValue(authInfo);
			auth.setPw(pw);
		}
		create.setAuthInfo(auth);
		return getThis();
	}

	private final Create create = new Create();
}
