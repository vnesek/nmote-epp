package com.nmote.epp;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.ietf.epp.epp.MsgType;
import org.ietf.epp.epp.ResultType;

public class EppException extends Exception {

	private static final long serialVersionUID = 1L;

	public static void throwOnError(List<ResultType> results) throws EppException {
		if (!results.isEmpty()) {
			Map<Integer, String> m = new LinkedHashMap<>();
			for (ResultType result : results) {
				int code = result.getCode();
				// Success codes are [1000, 2000)
				if (code < 1000 || code >= 2000) {
					MsgType msg = result.getMsg();
					m.put(result.getCode(), msg != null ? msg.getValue() : "");
				}
			}
			if (!m.isEmpty()) {
				throw new EppException(m);
			}
		}
	}

	public EppException(Map<Integer, String> results) {
		if (results == null) {
			results = Collections.emptyMap();
		}
		this.results = results;
	}

	public EppException(String message) {
		super(message);
		this.results = Collections.emptyMap();
	}

	@Override
	public String getMessage() {
		return results.toString();
	}

	public Map<Integer, String> getResults() {
		return results;
	}

	public boolean hasErrorCode(int code) {
		return results.containsKey(code);
	}

	private final Map<Integer, String> results;
}
