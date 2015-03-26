package com.nmote.epp;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.ietf.epp.epp.Epp;
import org.ietf.epp.epp.MsgType;
import org.ietf.epp.epp.ResultType;

public class EppException extends Exception {

	private static final long serialVersionUID = 1L;

	public static void throwOnError(Epp response) throws EppException {
		if (response.getResponse() != null && response.getResponse().getResults() != null) {
			List<ResultType> results = response.getResponse().getResults();
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
					throw new EppException(m, response);
				}
			}
		}
	}

	public EppException(Map<Integer, String> results, Epp response) {
		this.results = results;
		this.response = response;
	}

	@Override
	public String getMessage() {
		return results.toString();
	}

	public Map<Integer, String> getResults() {
		return results;
	}

	public Epp getResponse() {
		return response;
	}

	private final Map<Integer, String> results;
	private final Epp response;
}
