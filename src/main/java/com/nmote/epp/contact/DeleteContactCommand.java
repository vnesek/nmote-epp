package com.nmote.epp.contact;

import org.ietf.epp.contact.Delete;

import com.nmote.epp.command.DeleteCommand;

public class DeleteContactCommand extends DeleteCommand<Delete, Void, DeleteContactCommand> {

	public DeleteContactCommand() {
		command(delete);
	}

	public DeleteContactCommand id(String id) {
		delete.setId(id);
		return getThis();
	}

	private final Delete delete = new Delete();
}
