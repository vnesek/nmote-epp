package com.nmote.epp;

import org.ietf.epp.domain.InfData;
import org.ietf.epp.domain.Info;

public class InfoDomainCommand extends EppInfoCommand<Info, InfData, InfoDomainCommand> {

	public InfoDomainCommand() {
		command(info);
	}

	public InfoDomainCommand name(String name) {
		org.ietf.epp.domain.InfoNameType infoName = new org.ietf.epp.domain.InfoNameType();
		infoName.setValue("test-regica-8307.com.hr");
		info.setName(infoName);
		return this;
	}

	@Override
	protected InfoDomainCommand getThis() {
		return this;
	}

	private final Info info = new Info();

}
