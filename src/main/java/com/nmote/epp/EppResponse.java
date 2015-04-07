package com.nmote.epp;

import java.util.ArrayList;
import java.util.List;

import org.ietf.epp.epp.ExtAnyType;
import org.ietf.epp.epp.ResponseType;
import org.ietf.epp.epp.ResultType;

public class EppResponse<R> {

	@SuppressWarnings("unchecked")
	private static <E> E getFirstOfType(List<Object> objects, Class<E> type) {
		if (objects != null) {
			for (Object e : objects) {
				if (type.isInstance(e)) {
					return (E) e;
				}
			}
		}
		return null;
	}

	public EppResponse(ResponseType response) {
		this.results = response.getResults();
		ExtAnyType resData = response.getResData();
		if (resData != null) {
			responses = resData.getAnies();
		}
		ExtAnyType extension = response.getExtension();
		if (extension != null) {
			extensions = extension.getAnies();
		}

	}

	public <E> E getExtension(Class<E> extensionType) {
		return getFirstOfType(getExtensions(), extensionType);
	}

	public List<Object> getExtensions() {
		if (extensions == null) {
			extensions = new ArrayList<>();
		}
		return extensions;
	}

	public <E> E getResponse(Class<E> responseType) {
		return getFirstOfType(getResponses(), responseType);
	}

	public List<Object> getResponses() {
		if (responses == null) {
			responses = new ArrayList<>();
		}
		return responses;
	}

	public List<ResultType> getResults() {
		if (results == null) {
			results = new ArrayList<ResultType>();
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	public R getSingleResponse() {
		return (R) responses.get(0);
	}

	public <E> boolean hasExtension(Class<E> extensionType) {
		return getExtension(extensionType) != null;
	}

	private List<Object> extensions;
	private List<Object> responses;
	private List<ResultType> results;
}
