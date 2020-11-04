/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.epp.domain;

import org.ietf.epp.domain.Check;
import org.ietf.epp.domain.ChkData;

import com.nmote.epp.command.CheckCommand;

public class CheckDomainCommand extends CheckCommand<Check, ChkData, CheckDomainCommand> {

	public CheckDomainCommand() {
		command(check);
	}

	public CheckDomainCommand name(String ... domains) {
		for (String domain : domains) {
			check.getNames().add(domain);
		}
		return getThis();
	}

	private final Check check = new Check();
}
