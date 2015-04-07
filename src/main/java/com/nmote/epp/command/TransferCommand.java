package com.nmote.epp.command;

import org.ietf.epp.epp.CommandType;
import org.ietf.epp.epp.TransferOpType;
import org.ietf.epp.epp.TransferType;

import com.nmote.epp.EppCommand;
import com.nmote.epp.EppEndpoint;

public abstract class TransferCommand<C, R, T extends TransferCommand<C, R, T>> extends EppCommand<C, R, T> {

	public T approve() {
		return op(TransferOpType.APPROVE);
	}

	public T cancel() {
		return op(TransferOpType.CANCEL);
	}

	public T op(TransferOpType op) {
		transferType.setOp(op);
		return getThis();
	}

	public T query() {
		return op(TransferOpType.QUERY);
	}

	public T reject() {
		return op(TransferOpType.REJECT);
	}

	public T request() {
		return op(TransferOpType.REQUEST);
	}

	@Override
	protected CommandType newCommandType(EppEndpoint endpoint) {
		transferType.setAny(newTransferObject());
		CommandType cmd = super.newCommandType(endpoint);
		cmd.setTransfer(transferType);
		return cmd;
	}

	protected abstract Object newTransferObject();

	private final TransferType transferType = new TransferType();
}
