package com.nmote.epp.contact;

import org.ietf.epp.contact.AuthInfoType;
import org.ietf.epp.contact.CreData;
import org.ietf.epp.contact.Create;
import org.ietf.epp.contact.E164Type;
import org.ietf.epp.contact.PostalInfoType;
import org.ietf.epp.eppcom.PwAuthInfoType;

import com.nmote.epp.command.CreateCommand;

public class CreateContactCommand<T extends CreateContactCommand<T>> extends CreateCommand<Create, CreData, T> {

	public CreateContactCommand() {
		command(create);
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

	public T email(String email) {
		create.setEmail(email);
		return getThis();
	}

	public T fax(String value) {
		return voice(value, null);
	}

	public T fax(String value, String x) {
		E164Type number = new E164Type();
		number.setValue(value);
		number.setX(x);
		create.setFax(number);
		return getThis();
	}

	public T id(String id) {
		create.setId(id);
		return getThis();
	}

	public T postalInfo(PostalInfoBuilder builder) {
		return postalInfo(builder.getPostalInfoType());
	}

	public T postalInfo(PostalInfoType info) {
		create.getPostalInfos().add(info);
		return getThis();
	}

	public T voice(String value) {
		return voice(value, null);
	}

	public T voice(String value, String x) {
		E164Type number = new E164Type();
		number.setValue(value);
		number.setX(x);
		create.setVoice(number);
		return getThis();
	}

	private final Create create = new Create();
}
