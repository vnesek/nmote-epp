package com.nmote.epp;

import java.util.Collections;
import java.util.List;

import org.ietf.epp.epp.CredsOptionsType;
import org.ietf.epp.epp.ExtURIType;
import org.ietf.epp.epp.LoginSvcType;
import org.ietf.epp.epp.LoginType;

public class LoginCommand extends EppCommand<LoginType, Void, LoginCommand> {

	@Override
	protected LoginCommand getThis() {
		return this;
	}

	@Override
	public List<Object> getCommands(EppEndpoint endpoint) {
		LoginType login = new LoginType();
		login.setClID(clientID);
		login.setPw(password);
		{
			CredsOptionsType credOpts = new CredsOptionsType();
			credOpts.setLang("en");
			credOpts.setVersion("1.0");
			login.setOptions(credOpts);
		}
		{
			LoginSvcType svcs = new LoginSvcType();
			ExtURIType ext = new ExtURIType();
			for (EppService service : endpoint.getServices()) {
				if (service.getPackageName().startsWith("org.ietf.epp")) {
					// Standard service
					svcs.getObjURIs().add(service.getNamespaceURI());
				} else {
					// Extension service
					ext.getExtURIs().add(service.getNamespaceURI());
				}
			}
			if (!ext.getExtURIs().isEmpty()) {
				svcs.setSvcExtension(ext);
			}
			login.setSvcs(svcs);
		}
		return Collections.singletonList(login);
	}

	public LoginCommand clientID(String clientID) {
		this.clientID = clientID;
		return getThis();
	}

	public LoginCommand password(String password) {
		this.password = password;
		return getThis();
	}

	private String clientID;
	private String password;
}
