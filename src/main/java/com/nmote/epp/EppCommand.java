package com.nmote.epp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

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

	public List<Object> getCommands(EppEndpoint endpoint) {
		return commands;
	}

	public List<Object> getExtensions(EppEndpoint endpoint) {
		return extensions;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	protected abstract T getThis();

	private List<Object> commands = new ArrayList<>();
	private List<Object> extensions;
}
