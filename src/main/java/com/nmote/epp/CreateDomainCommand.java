package com.nmote.epp;

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

public class CreateDomainCommand extends EppCreateCommand<Create, CreData, CreateDomainCommand> {

	public CreateDomainCommand() {
		command(create);
	}

	public CreateDomainCommand name(String name) {
		create.setName(name);
		return this;
	}

	public CreateDomainCommand period(int period) {
		PeriodType pt = new PeriodType();
		pt.setUnit(PUnitType.Y);
		pt.setValue(1);
		create.setPeriod(pt);
		return this;
	}

	public CreateDomainCommand ns(String name, String... address) {
		NsType ns = create.getNs();
		if (ns == null) {
			ns = new NsType();
			create.setNs(ns);
		}

		HostAttrType ha = new HostAttrType();
		ha.setHostName(name);
		for (String ip : address){
			AddrType a = new AddrType();
			// TODO auto detect IP address type
			a.setIp(IpType.V_4);
			a.setValue(ip);
			ha.getHostAddrs().add(a);
		}
		ns.getHostAttrs().add(ha);
		return this;
	}

	@Override
	protected CreateDomainCommand getThis() {
		return this;
	}

	public CreateDomainCommand registrant(String id) {
		create.setRegistrant(id);
		return this;
	}

	public CreateDomainCommand admin(String id) {
		org.ietf.epp.domain.ContactType ct = new org.ietf.epp.domain.ContactType();
		ct.setType(ContactAttrType.ADMIN);
		ct.setValue(id);
		create.getContacts().add(ct);
		return this;
	}

	public CreateDomainCommand tech(String id) {
		org.ietf.epp.domain.ContactType ct = new org.ietf.epp.domain.ContactType();
		ct.setType(ContactAttrType.TECH);
		ct.setValue(id);
		create.getContacts().add(ct);
		return this;
	}

	public CreateDomainCommand billing(String id) {
		ContactType ct = new ContactType();
		ct.setType(ContactAttrType.BILLING);
		ct.setValue(id);
		create.getContacts().add(ct);
		return this;
	}

	public CreateDomainCommand auth(String authInfo) {
		return auth(authInfo, null);
	}

	public CreateDomainCommand auth(String authInfo, String roid) {
		AuthInfoType auth = new AuthInfoType();
		{
			PwAuthInfoType pw = new PwAuthInfoType();
			pw.setRoid(roid);
			pw.setValue(authInfo);
			auth.setPw(pw);
		}
		create.setAuthInfo(auth);
		return this;
	}

	private final Create create = new Create();
}
