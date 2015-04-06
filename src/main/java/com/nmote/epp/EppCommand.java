package com.nmote.epp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.ietf.epp.epp.CommandType;
import org.ietf.epp.epp.ExtAnyType;
import org.ietf.epp.epp.ReadWriteType;

public abstract class EppCommand<C, R, T extends EppCommand<C, R, T>> {

	public T command(C command) {
		this.commands.add(command);
		return getThis();
	}

	public T extension(Object extension) {
		if (this.extensions == null) {
			this.extensions = new ArrayList<>();
		}
		this.extensions.add(extension);
		return getThis();
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	protected abstract T getThis();

	private List<Object> commands = new ArrayList<>();
	private List<Object> extensions;

	protected ExtAnyType newExtAnyType(EppEndpoint endpoint) {
		ExtAnyType result;
		if (extensions != null && extensions.size() > 0) {
			result = new ExtAnyType();
			result.getAnies().addAll(extensions);
		} else {
			result = null;
		}
		return result;
	}

	protected ReadWriteType newReadWriteType(EppEndpoint endpoint) {
		ReadWriteType rw = new ReadWriteType();
		rw.getAnies().addAll(commands);
		return rw;
	}

	protected CommandType newCommandType(EppEndpoint endpoint) {
		CommandType cmd = new CommandType();
		cmd.setExtension(newExtAnyType(endpoint));
		return cmd;
	}
}
