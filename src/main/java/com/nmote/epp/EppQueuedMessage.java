package com.nmote.epp;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.ietf.epp.epp.MsgQType;

public class EppQueuedMessage {

	public EppQueuedMessage(MsgQType msg) {
		this.id = msg.getId();
		XMLGregorianCalendar date = msg.getQDate();
		if (date != null) {
			this.date = date.toGregorianCalendar().getTime();
		}
		this.count = msg.getCount() != null ? msg.getCount().intValue() : 0;
		if (msg.getMsg() != null) {
			this.content = msg.getMsg().getContent();
		}
	}

	public List<Object> getContent() {
		if (content == null) {
			content = Collections.emptyList();
		}
		return content;
	}

	public int getCount() {
		return count;
	}

	public Date getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	private List<Object> content;
	private int count;
	private Date date;
	private String id;
}
