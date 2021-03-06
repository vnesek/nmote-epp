/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.epp.domain;

import org.ietf.epp.domain.Delete;

import com.nmote.epp.command.DeleteCommand;

public class DeleteDomainCommand extends DeleteCommand<Delete, Void, DeleteDomainCommand> {

	public DeleteDomainCommand() {
		command(delete);
	}

	public DeleteDomainCommand name(String name) {
		delete.setName(name);
		return getThis();
	}

	private final Delete delete = new Delete();
}
