package com.nmote.epp.domain;

import java.util.Iterator;

import org.ietf.epp.domain.StatusValueType;
import org.ietf.epp.domain.AddRemType;
import org.ietf.epp.domain.AuthInfoChgType;
import org.ietf.epp.domain.ChgType;
import org.ietf.epp.domain.ContactAttrType;
import org.ietf.epp.domain.HostAttrType;
import org.ietf.epp.domain.NsType;
import org.ietf.epp.domain.StatusType;
import org.ietf.epp.domain.Update;
import org.ietf.epp.eppcom.PwAuthInfoType;
import org.ietf.epp.host.AddrType;
import org.ietf.epp.host.IpType;

import com.nmote.epp.command.UpdateCommand;

public class UpdateDomainCommand extends UpdateCommand<Update, Void, UpdateDomainCommand> {

	public UpdateDomainCommand() {
		command(update);
	}

	public UpdateDomainCommand addAdmin(String id) {
		return changeContact(add(), ContactAttrType.ADMIN, id);
	}

	public UpdateDomainCommand addBilling(String id) {
		return changeContact(add(), ContactAttrType.BILLING, id);
	}

	public UpdateDomainCommand addNs(String name, String... address) {
		return changeNs(add(), name, address);
	}

	public UpdateDomainCommand addStatus(StatusValueType status) {
		return changeStatus(add(), status);
	}

	public UpdateDomainCommand addTech(String id) {
		return changeContact(add(), ContactAttrType.TECH, id);
	}

	public UpdateDomainCommand auth(String authInfo) {
		return auth(authInfo, null);
	}

	public UpdateDomainCommand auth(String authInfo, String roid) {
		AuthInfoChgType auth = new AuthInfoChgType();
		if (authInfo != null) {
			PwAuthInfoType pw = new PwAuthInfoType();
			pw.setRoid(roid);
			pw.setValue(authInfo);
			auth.setPw(pw);
		} else {
			auth.setNull("");
		}
		chg().setAuthInfo(auth);
		return getThis();
	}

	public UpdateDomainCommand name(String name) {
		update.setName(name);
		return getThis();
	}

	public UpdateDomainCommand registrant(String id) {
		chg().setRegistrant(id);
		return getThis();
	}

	public UpdateDomainCommand removeAdmin(String id) {
		return changeContact(rem(), ContactAttrType.ADMIN, id);
	}

	public UpdateDomainCommand removeBilling(String id) {
		return changeContact(rem(), ContactAttrType.BILLING, id);
	}

	public UpdateDomainCommand removeNs(String name, String... address) {
		return changeNs(rem(), name, address);
	}

	public UpdateDomainCommand removeStatus(StatusValueType status) {
		return changeStatus(rem(), status);
	}

	public UpdateDomainCommand removeTech(String id) {
		return changeContact(rem(), ContactAttrType.TECH, id);
	}

	private AddRemType add() {
		AddRemType ar = update.getAdd();
		if (ar == null) {
			ar = new AddRemType();
			update.setAdd(ar);
		}
		return ar;
	}

	private UpdateDomainCommand changeContact(AddRemType ar, ContactAttrType type, String id) {
		org.ietf.epp.domain.ContactType ct = new org.ietf.epp.domain.ContactType();
		ct.setType(type);
		ct.setValue(id);
		ar.getContacts().add(ct);
		return getThis();
	}

	private UpdateDomainCommand changeNs(AddRemType ar, String name, String... address) {
		NsType ns = ar.getNs();
		if (ns == null) {
			ns = new NsType();
			ar.setNs(ns);
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

	private UpdateDomainCommand changeStatus(AddRemType ar, StatusValueType status) {
		// Remove existing status if any
		for (Iterator<StatusType> i = ar.getStatuses().iterator(); i.hasNext();) {
			if (i.next().getS() == status) {
				i.remove();
			}
		}
		StatusType st = new StatusType();
		st.setLang("en");
		st.setS(status);
		ar.getStatuses().add(st);
		return getThis();
	}

	private ChgType chg() {
		ChgType chg = update.getChg();
		if (chg == null) {
			chg = new ChgType();
			update.setChg(chg);
		}
		return chg;
	}

	private AddRemType rem() {
		AddRemType ar = update.getRem();
		if (ar == null) {
			ar = new AddRemType();
			update.setRem(ar);
		}
		return ar;
	}

	private Update update = new Update();
}
