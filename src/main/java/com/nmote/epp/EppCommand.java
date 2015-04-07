package com.nmote.epp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.ietf.epp.epp.CommandType;
import org.ietf.epp.epp.ExtAnyType;
import org.ietf.epp.epp.ReadWriteType;

import com.nmote.epp.command.LoginCommand;
import com.nmote.epp.command.LogoutCommand;
import com.nmote.epp.contact.CreateContactCommand;
import com.nmote.epp.contact.InfoContactCommand;
import com.nmote.epp.contact.UpdateContactCommand;
import com.nmote.epp.domain.CheckDomainCommand;
import com.nmote.epp.domain.CreateDomainCommand;
import com.nmote.epp.domain.InfoDomainCommand;
import com.nmote.epp.domain.RenewDomainCommand;
import com.nmote.epp.domain.TransferDomainCommand;
import com.nmote.epp.domain.UpdateDomainCommand;

public abstract class EppCommand<C, R, T extends EppCommand<C, R, T>> {

	public static CheckDomainCommand checkDomain() {
		return new CheckDomainCommand();
	}

	public static CheckDomainCommand checkDomain(String... domains) {
		return new CheckDomainCommand().name(domains);
	}

	public static CreateContactCommand<?> createContact() {
		return new CreateContactCommand<>();
	}

	public static CreateDomainCommand<?> createDomain() {
		return new CreateDomainCommand<>();
	}

	public static CreateDomainCommand<?> createDomain(String name) {
		return createDomain().name(name);
	}

	public static InfoContactCommand infoContact() {
		return new InfoContactCommand();
	}

	public static InfoContactCommand infoContact(String id) {
		return infoContact().id(id);
	}

	public static InfoDomainCommand infoDomain() {
		return new InfoDomainCommand();
	}

	public static InfoDomainCommand infoDomain(String name) {
		return infoDomain().name(name);
	}

	public static LoginCommand login() {
		return new LoginCommand();
	}

	public static LoginCommand login(String clientID, String password) {
		return login().clientID(clientID).password(password);
	}

	public static LogoutCommand logout() {
		return new LogoutCommand();
	}

	public static RenewDomainCommand renewDomain() {
		return new RenewDomainCommand();
	}

	public static RenewDomainCommand renewDomain(String name) {
		return renewDomain().name(name);
	}

	public static TransferDomainCommand transferDomain() {
		return new TransferDomainCommand();
	}

	public static TransferDomainCommand transferDomain(String name) {
		return transferDomain().name(name);
	}

	public static UpdateContactCommand<?> updateContact() {
		return new UpdateContactCommand<>();
	}

	public static UpdateContactCommand<?> updateContact(String id) {
		return updateContact().id(id);
	}

	public static UpdateDomainCommand updateDomain() {
		return new UpdateDomainCommand();
	}

	public static UpdateDomainCommand updateDomain(String name) {
		return updateDomain().name(name);
	}

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

	@SuppressWarnings("unchecked")
	protected T getThis() {
		return (T) this;
	}

	protected CommandType newCommandType(EppEndpoint endpoint) {
		CommandType cmd = new CommandType();
		cmd.setExtension(newExtAnyType(endpoint));
		return cmd;
	}

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

	private List<Object> commands = new ArrayList<>();
	private List<Object> extensions;
}
