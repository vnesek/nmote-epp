package com.nmote.epp.command;

import org.ietf.epp.epp.CommandType;

import com.nmote.epp.EppCommand;
import com.nmote.epp.EppEndpoint;

public class LogoutCommand extends EppCommand<Void, Void, LogoutCommand> {

	@Override
	protected CommandType newCommandType(EppEndpoint endpoint) {
		CommandType cmd = super.newCommandType(endpoint);
		cmd.setLogout("");
		return cmd;
	}
}
