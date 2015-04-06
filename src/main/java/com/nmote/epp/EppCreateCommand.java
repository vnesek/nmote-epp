package com.nmote.epp;

import org.ietf.epp.epp.CommandType;

public abstract class EppCreateCommand<C, R, T extends EppCreateCommand<C, R, T>> extends EppCommand<C, R, T> {

	@Override
	protected CommandType newCommandType(EppEndpoint endpoint) {
		CommandType cmd = super.newCommandType(endpoint);
		cmd.setCreate(newReadWriteType(endpoint));
		return cmd;
	}

}
