package com.nmote.epp;

import javax.xml.bind.annotation.XmlSchema;

public class EppService {

	public EppService(String packageName) {
		this.packageName = packageName;

		Package p = Package.getPackage(packageName);
		if (p == null) {
			try {
				p = Class.forName(packageName + ".ObjectFactory").getPackage();
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException("package " + packageName + " not found");
			}
		}
		XmlSchema s = p.getAnnotation(XmlSchema.class);
		if (s == null) {
			throw new NullPointerException("missing @javax.xml.bind.annotation.XmlSchema on package " + packageName);
		}
		namespaceURI = s.namespace();
		if (namespaceURI.length() == 0) {
			throw new IllegalArgumentException(
					"namespaceURI not defined using @javax.xml.bind.annotation.XmlSchema on package " + packageName);
		}
	}

	public EppService(String packageName, String namespaceUri) {
		this.packageName = packageName;
		this.namespaceURI = namespaceUri;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof EppService)) {
			return false;
		}
		return ((EppService) obj).namespaceURI.equals(namespaceURI);
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public String getPackageName() {
		return packageName;
	}

	@Override
	public int hashCode() {
		return namespaceURI.hashCode();
	}

	@Override
	public String toString() {
		return getNamespaceURI();
	}

	private final String namespaceURI;
	private final String packageName;
}
