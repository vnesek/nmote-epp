/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.epp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.ietf.epp.epp.CommandType;
import org.ietf.epp.epp.ExtAnyType;
import org.ietf.epp.epp.ReadWriteType;

import com.nmote.epp.command.LoginCommand;
import com.nmote.epp.command.LogoutCommand;
import com.nmote.epp.command.PollCommand;
import com.nmote.epp.contact.CreateContactCommand;
import com.nmote.epp.contact.DeleteContactCommand;
import com.nmote.epp.contact.InfoContactCommand;
import com.nmote.epp.contact.UpdateContactCommand;
import com.nmote.epp.domain.CheckDomainCommand;
import com.nmote.epp.domain.CreateDomainCommand;
import com.nmote.epp.domain.DeleteDomainCommand;
import com.nmote.epp.domain.InfoDomainCommand;
import com.nmote.epp.domain.RenewDomainCommand;
import com.nmote.epp.domain.TransferDomainCommand;
import com.nmote.epp.domain.UpdateDomainCommand;

/**
 * Base class for all EPP commands. Subtypes define exact command and response
 * types that are serialized/deserialized with JAXB. Contains static factory
 * methods for common EPP commands.
 *
 * @author vnesek
 *
 * @param <C>
 *            JAXB bound EPP command type
 * @param <R>
 *            JAXB build ERR response type
 * @param <T>
 *            Self-type reference
 */
public abstract class EppCommand<C, R, T extends EppCommand<C, R, T>> {

	/**
	 * Factory method for a check domain command.
	 *
	 * @return check domain command
	 */
	public static CheckDomainCommand checkDomain() {
		return new CheckDomainCommand();
	}

	/**
	 * Factory method for a check domain command.
	 *
	 * @param domains
	 *            list of domain to check
	 * @return
	 */
	public static CheckDomainCommand checkDomain(String... domains) {
		return new CheckDomainCommand().name(domains);
	}

	/**
	 * Factory method for a create contact command.
	 *
	 * @return create contact command
	 */
	public static CreateContactCommand<?> createContact() {
		return new CreateContactCommand<>();
	}

	/**
	 * Factory method for a create domain command.
	 *
	 * @return create domain command
	 */
	public static CreateDomainCommand<?> createDomain() {
		return new CreateDomainCommand<>();
	}

	/**
	 * Factory method for a create domain command.
	 *
	 * @param name
	 *            domain name
	 *
	 * @return create domain command
	 */
	public static CreateDomainCommand<?> createDomain(String name) {
		return createDomain().name(name);
	}

	/**
	 * Factory method for a delete contact command.
	 *
	 * @param id
	 *            contact id
	 *
	 * @return delete contact command
	 */
	public static DeleteContactCommand deleteContact(String id) {
		return new DeleteContactCommand().id(id);
	}

	/**
	 * Factory method for a delete domain command.
	 *
	 * @param name
	 *            domain name
	 *
	 * @return delete domain command
	 */
	public static DeleteDomainCommand deleteDomain(String name) {
		return new DeleteDomainCommand().name(name);
	}

	/**
	 * Factory method for an info contact command.
	 *
	 * @param id
	 *            contact id
	 *
	 * @return info contact command
	 */
	public static InfoContactCommand infoContact(String id) {
		return new InfoContactCommand().id(id);
	}

	/**
	 * Factory method for an info domain command.
	 *
	 * @param name
	 *            domain name
	 *
	 * @return info domain command
	 */
	public static InfoDomainCommand infoDomain(String name) {
		return new InfoDomainCommand().name(name);
	}

	/**
	 * Factory method for a login command.
	 *
	 * @param clientID
	 *            EPP client id
	 * @param password
	 *            EPP client password
	 *
	 * @return login command
	 */
	public static LoginCommand login(String clientID, String password) {
		return new LoginCommand().clientID(clientID).password(password);
	}

	/**
	 * Factory method for logount command.
	 *
	 * @return logout command
	 */
	public static LogoutCommand logout() {
		return new LogoutCommand();
	}

	/**
	 * Factory method for a poll command.
	 *
	 * @return poll command
	 */
	public static PollCommand poll() {
		return new PollCommand();
	}

	/**
	 * Factory method for a renew domain command.
	 *
	 * @param name
	 *            domain name
	 *
	 * @return renew domain command
	 */
	public static RenewDomainCommand renewDomain(String name) {
		return new RenewDomainCommand().name(name);
	}

	/**
	 * Factory method for a transfer domain command.
	 *
	 * @param name
	 *            domain name
	 *
	 * @return transfer domain command
	 */
	public static TransferDomainCommand transferDomain(String name) {
		return new TransferDomainCommand().name(name);
	}

	/**
	 * Factory method for an update contact command.
	 *
	 * @param id
	 *            contact id
	 *
	 * @return update contact command
	 */
	public static UpdateContactCommand<?> updateContact(String id) {
		return new UpdateContactCommand<>().id(id);
	}

	/**
	 * Factory method for an update domain command.
	 *
	 * @param name
	 *            domain name
	 *
	 * @return update domain command
	 */
	public static UpdateDomainCommand updateDomain(String name) {
		return new UpdateDomainCommand().name(name);
	}

	/**
	 * Add command to a list of commands issued in this request.
	 *
	 * @param command
	 *            command to add to command list
	 * @return this object
	 */
	public T command(C command) {
		this.commands.add(command);
		return getThis();
	}

	/**
	 * Add extenstion to a list of extenstions issued in this request.
	 *
	 * @param extension
	 *            extension to add to extensions list
	 * @return this object
	 */
	public T extension(Object extension) {
		if (this.extensions == null) {
			this.extensions = new ArrayList<>();
		}
		this.extensions.add(extension);
		return getThis();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * This object cast to correct type. Used for method chaining.
	 *
	 * @return this object
	 */
	@SuppressWarnings("unchecked")
	protected T getThis() {
		return (T) this;
	}

	/**
	 * Instantiates and configures new {@link CommandType} for this command.
	 *
	 * @param endpoint
	 *            endpoint used
	 * @return CommandType instance
	 */
	protected CommandType newCommandType(EppEndpoint endpoint) {
		CommandType cmd = new CommandType();
		cmd.setExtension(newExtAnyType(endpoint));
		return cmd;
	}

	/**
	 * Instantiates and configures new {@link ExtAnyType} for this command.
	 *
	 * @param endpoint
	 *            endpoint used
	 * @return ExtAnytype instance
	 */
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

	/**
	 * Instantiates and configures new {@link ReadWriteType} for this command.
	 *
	 * @param endpoint
	 *            endpoint used
	 * @return ReadWriteType instance
	 */
	protected ReadWriteType newReadWriteType(EppEndpoint endpoint) {
		ReadWriteType rw = new ReadWriteType();
		rw.getAnies().addAll(commands);
		return rw;
	}

	private List<Object> commands = new ArrayList<>();
	private List<Object> extensions;
}
