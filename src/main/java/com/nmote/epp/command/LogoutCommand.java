/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

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
