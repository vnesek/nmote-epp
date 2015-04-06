package com.nmote.epp;

import org.ietf.epp.epp.CommandType;

public abstract class EppCheckCommand<C, R, T extends EppCheckCommand<C, R, T>> extends EppCommand<C, R, T> {

	@Override
	protected CommandType newCommandType(EppEndpoint endpoint) {
		CommandType cmd = super.newCommandType(endpoint);
		cmd.setCheck(newReadWriteType(endpoint));
		return cmd;
	}
}
