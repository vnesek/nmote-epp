package com.nmote.epp.contact;

import javax.xml.bind.JAXBElement;

import org.ietf.epp.contact.AuthIDType;
import org.ietf.epp.contact.InfData;
import org.ietf.epp.contact.ObjectFactory;

import com.nmote.epp.command.InfoCommand;

public class InfoContactCommand extends InfoCommand<JAXBElement<AuthIDType>, InfData, InfoContactCommand> {

	public InfoContactCommand() {
		command(new ObjectFactory().createInfo(info));
	}

	public InfoContactCommand id(String id) {
		info.setId(id);
		return getThis();
	}

	private final AuthIDType info = new AuthIDType();
}
