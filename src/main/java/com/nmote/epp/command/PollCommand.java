/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.epp.command;

import org.ietf.epp.epp.CommandType;
import org.ietf.epp.epp.PollOpType;
import org.ietf.epp.epp.PollType;

import com.nmote.epp.EppCommand;
import com.nmote.epp.EppEndpoint;
import com.nmote.epp.EppQueuedMessage;

public class PollCommand extends EppCommand<Void, Object, PollCommand> {

	@Override
	protected CommandType newCommandType(EppEndpoint endpoint) {
		if (poll.getOp() == null) {
			poll.setOp(PollOpType.REQ);
		}
		CommandType cmd = super.newCommandType(endpoint);
		cmd.setPoll(poll);
		return cmd;
	}

	private PollCommand pollOp(PollOpType pollOp) {
		poll.setOp(pollOp);
		return getThis();
	}

	public PollCommand acknowledge(String msgId) {
		poll.setMsgID(msgId);
		return pollOp(PollOpType.ACK);
	}

	public PollCommand acknowledge(EppQueuedMessage msg) {
		return acknowledge(msg.getId());
	}

	public PollCommand request() {
		return pollOp(PollOpType.REQ);
	}

	private final PollType poll = new PollType();
}
