package com.nmote.epp;

import org.ietf.epp.epp.CommandType;

public abstract class EppInfoCommand<C, R, T extends EppInfoCommand<C, R, T>> extends EppCommand<C, R, T> {

	@Override
	protected CommandType newCommandType(EppEndpoint endpoint) {
		CommandType cmd = super.newCommandType(endpoint);
		cmd.setInfo(newReadWriteType(endpoint));
		return cmd;
	}
}
