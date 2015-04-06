package com.nmote.epp;

import org.ietf.epp.epp.CommandType;

public class LogoutCommand extends EppCommand<Void, Void, LogoutCommand> {

	@Override
	protected LogoutCommand getThis() {
		return this;
	}

	@Override
	protected CommandType newCommandType(EppEndpoint endpoint) {
		CommandType cmd = super.newCommandType(endpoint);
		cmd.setLogout("");
		return cmd;
	}
}
