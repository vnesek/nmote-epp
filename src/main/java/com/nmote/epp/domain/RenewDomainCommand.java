package com.nmote.epp.domain;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.ietf.epp.domain.PUnitType;
import org.ietf.epp.domain.PeriodType;
import org.ietf.epp.domain.RenData;
import org.ietf.epp.domain.Renew;
import org.ietf.epp.epp.ReadWriteType;

import com.nmote.epp.EppEndpoint;
import com.nmote.epp.command.RenewCommand;

public class RenewDomainCommand extends RenewCommand<Renew, RenData, RenewDomainCommand> {

	public RenewDomainCommand() {
		command(renew);
	}

	public RenewDomainCommand name(String name) {
		renew.setName(name);
		return getThis();
	}

	@Override
	protected ReadWriteType newReadWriteType(EppEndpoint endpoint) {
		// Fix timezones
		if (!endpoint.isEnabled("keepCurrentExpireTimezone")) {
			XMLGregorianCalendar xgc = renew.getCurExpDate();
			if (xgc != null) {
				xgc.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
			}
		}
		return super.newReadWriteType(endpoint);
	}

	public RenewDomainCommand currentExpire(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		try {
			XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			renew.setCurExpDate(xgc);
			return getThis();
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	public RenewDomainCommand currentExpire(String date) {
		try {
			XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
			renew.setCurExpDate(xgc);
			return getThis();
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	public RenewDomainCommand period(int period) {
		PeriodType pt = new PeriodType();
		pt.setUnit(PUnitType.Y);
		pt.setValue(1);
		renew.setPeriod(pt);
		return getThis();
	}

	private final Renew renew = new Renew();

}
