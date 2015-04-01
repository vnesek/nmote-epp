package com.nmote.epp;

import org.ietf.epp.domain.Check;
import org.ietf.epp.domain.ChkData;

public class CheckDomainCommand extends EppCheckCommand<Check, ChkData, CheckDomainCommand> {

	public CheckDomainCommand() {
		command(check);
	}

	public CheckDomainCommand domain(String ... domains) {
		for (String domain : domains) {
			check.getNames().add(domain);
		}
		return this;
	}

	@Override
	protected CheckDomainCommand getThis() {
		return this;
	}

	private final Check check = new Check();
}
