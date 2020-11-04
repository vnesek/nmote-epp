/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.epp.command;

import org.ietf.epp.epp.CommandType;

import com.nmote.epp.EppCommand;
import com.nmote.epp.EppEndpoint;

/**
 * EppCommand subclass for all EPP check operations
 *
 * @author vnesek
 *
 * @param <C>
 *            JAXB bound EPP command type
 * @param <R>
 *            JAXB boild ERR response type
 * @param <T>
 *            Self-type reference
 */
public abstract class CheckCommand<C, R, T extends CheckCommand<C, R, T>> extends EppCommand<C, R, T> {

	/**
	 * @see com.nmote.epp.EppCommand#newCommandType(com.nmote.epp.EppEndpoint)
	 */
	@Override
	protected CommandType newCommandType(EppEndpoint endpoint) {
		CommandType cmd = super.newCommandType(endpoint);
		cmd.setCheck(newReadWriteType(endpoint));
		return cmd;
	}
}
