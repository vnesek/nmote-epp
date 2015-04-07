package com.nmote.epp.domain;

import org.ietf.epp.domain.TrnData;
import org.ietf.epp.domain.AuthInfoType;
import org.ietf.epp.domain.PUnitType;
import org.ietf.epp.domain.PeriodType;
import org.ietf.epp.domain.Transfer;
import org.ietf.epp.eppcom.PwAuthInfoType;

import com.nmote.epp.command.TransferCommand;

public class TransferDomainCommand extends TransferCommand<Transfer, TrnData, TransferDomainCommand> {

	public TransferDomainCommand auth(String authInfo) {
		return auth(authInfo, null);
	}

	public TransferDomainCommand auth(String authInfo, String roid) {
		AuthInfoType auth = new AuthInfoType();
		{
			PwAuthInfoType pw = new PwAuthInfoType();
			pw.setRoid(roid);
			pw.setValue(authInfo);
			auth.setPw(pw);
		}
		transfer.setAuthInfo(auth);
		return getThis();
	}

	public TransferDomainCommand name(String name) {
		transfer.setName(name);
		return getThis();
	}

	public TransferDomainCommand period(int period) {
		PeriodType pt = new PeriodType();
		pt.setUnit(PUnitType.Y);
		pt.setValue(1);
		transfer.setPeriod(pt);
		return getThis();
	}

	@Override
	protected Object newTransferObject() {
		return transfer;
	}

	private final Transfer transfer = new Transfer();

}
