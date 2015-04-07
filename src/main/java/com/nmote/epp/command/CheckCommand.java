package com.nmote.epp.command;

import org.ietf.epp.epp.CommandType;

import com.nmote.epp.EppCommand;
import com.nmote.epp.EppEndpoint;

public abstract class CheckCommand<C, R, T extends CheckCommand<C, R, T>> extends EppCommand<C, R, T> {

	@Override
	protected CommandType newCommandType(EppEndpoint endpoint) {
		CommandType cmd = super.newCommandType(endpoint);
		cmd.setCheck(newReadWriteType(endpoint));
		return cmd;
	}
}