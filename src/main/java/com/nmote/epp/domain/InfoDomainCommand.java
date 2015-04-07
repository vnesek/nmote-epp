package com.nmote.epp.domain;

import org.ietf.epp.domain.InfData;
import org.ietf.epp.domain.Info;

import com.nmote.epp.command.InfoCommand;

public class InfoDomainCommand extends InfoCommand<Info, InfData, InfoDomainCommand> {

	public InfoDomainCommand() {
		command(info);
	}

	public InfoDomainCommand name(String name) {
		org.ietf.epp.domain.InfoNameType infoName = new org.ietf.epp.domain.InfoNameType();
		infoName.setValue(name);
		info.setName(infoName);
		return getThis();
	}

	private final Info info = new Info();
}
