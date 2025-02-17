/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.epp.contact;

import java.util.Iterator;

import org.ietf.epp.contact.AddRemType;
import org.ietf.epp.contact.AuthInfoType;
import org.ietf.epp.contact.ChgPostalInfoType;
import org.ietf.epp.contact.ChgType;
import org.ietf.epp.contact.E164Type;
import org.ietf.epp.contact.PostalInfoType;
import org.ietf.epp.contact.StatusType;
import org.ietf.epp.contact.StatusValueType;
import org.ietf.epp.contact.Update;
import org.ietf.epp.eppcom.PwAuthInfoType;

import com.nmote.epp.command.UpdateCommand;

public class UpdateContactCommand<T extends UpdateContactCommand<T>> extends UpdateCommand<Update, Void, T> {

	public UpdateContactCommand() {
		command(update);
	}

	public T addStatus(StatusValueType status) {
		return changeStatus(add(), status);
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
		chg().setAuthInfo(auth);
		return getThis();
	}

	public T email(String email) {
		chg().setEmail(email);
		return getThis();
	}

	public T fax(String value) {
		return fax(value, null);
	}

	public T fax(String value, String x) {
		E164Type number = new E164Type();
		number.setValue(value);
		number.setX(x);
		chg().setFax(number);
		return getThis();
	}

	public T id(String id) {
		update.setId(id);
		return getThis();
	}

	public T postalInfo(PostalInfoBuilder builder) {
		return postalInfo(builder.getPostalInfoType());
	}

	public T postalInfo(PostalInfoType info) {
		// Copy (idiotic...)
		ChgPostalInfoType changeInfo = new ChgPostalInfoType();
		changeInfo.setAddr(info.getAddr());
		changeInfo.setName(info.getName());
		changeInfo.setOrg(info.getOrg());
		changeInfo.setType(info.getType());

		chg().getPostalInfos().add(changeInfo);
		return getThis();
	}

	public T removeStatus(StatusValueType status) {
		return changeStatus(rem(), status);
	}

	public T voice(String value) {
		return voice(value, null);
	}

	public T voice(String value, String x) {
		E164Type number = new E164Type();
		number.setValue(value);
		number.setX(x);
		chg().setVoice(number);
		return getThis();
	}

	private AddRemType add() {
		AddRemType ar = update.getAdd();
		if (ar == null) {
			ar = new AddRemType();
			update.setAdd(ar);
		}
		return ar;
	}

	private T changeStatus(AddRemType ar, StatusValueType status) {
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

	private final Update update = new Update();
}
