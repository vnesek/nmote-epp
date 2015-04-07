package com.nmote.epp.contact;

import org.ietf.epp.contact.AddrType;
import org.ietf.epp.contact.PostalInfoEnumType;
import org.ietf.epp.contact.PostalInfoType;

public class PostalInfoBuilder {

	public static PostalInfoBuilder name(String name) {
		PostalInfoBuilder result = new PostalInfoBuilder();
		result.postalInfoType.setName(name);
		return result;
	}

	public static PostalInfoBuilder org(String org) {
		PostalInfoBuilder result = new PostalInfoBuilder();
		result.postalInfoType.setOrg(org);
		return result;
	}

	protected PostalInfoBuilder() {
		this(new PostalInfoType());
	}

	protected PostalInfoBuilder(PostalInfoType postalInfoType) {
		this.postalInfoType = postalInfoType;
		this.postalInfoType.setType(PostalInfoEnumType.INT);
	}

	public PostalInfoBuilder cc(String cc) {
		addr().setCc(cc);
		return this;
	}

	public PostalInfoBuilder city(String city) {
		addr().setCity(city);
		return this;
	}

	public PostalInfoType getPostalInfoType() {
		return postalInfoType;
	}

	public PostalInfoBuilder pc(String pc) {
		addr().setPc(pc);
		return this;
	}

	public PostalInfoBuilder sp(String sp) {
		addr().setSp(sp);
		return this;
	}

	public PostalInfoBuilder street(String street) {
		addr().getStreets().add(street);
		return this;
	}

	public PostalInfoBuilder type(PostalInfoEnumType type) {
		postalInfoType.setType(type);
		return this;
	}

	private AddrType addr() {
		AddrType addr = postalInfoType.getAddr();
		if (addr == null) {
			addr = new AddrType();
			postalInfoType.setAddr(addr);
		}
		return addr;
	}

	protected final PostalInfoType postalInfoType;
}
