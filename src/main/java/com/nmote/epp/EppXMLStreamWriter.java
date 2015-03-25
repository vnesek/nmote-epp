package com.nmote.epp;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

class EppXMLStreamWriter implements XMLStreamWriter {

	private static final String EPP_NS = "urn:ietf:params:xml:ns:epp-1.0";

	public EppXMLStreamWriter(XMLStreamWriter delegate) throws XMLStreamException {
		this.delegate = delegate;
	}

	@Override
	public void close() throws XMLStreamException {
		delegate.close();
	}

	@Override
	public void flush() throws XMLStreamException {
		delegate.flush();
	}

	@Override
	public NamespaceContext getNamespaceContext() {
		return delegate.getNamespaceContext();
	}

	@Override
	public String getPrefix(String a) throws XMLStreamException {
		return delegate.getPrefix(a);
	}

	@Override
	public Object getProperty(String a) throws IllegalArgumentException {
		return delegate.getProperty(a);
	}

	@Override
	public void setDefaultNamespace(String a) throws XMLStreamException {
		delegate.setDefaultNamespace(a);
	}

	@Override
	public void setNamespaceContext(NamespaceContext a) throws XMLStreamException {
	}

	@Override
	public void setPrefix(String a, String b) throws XMLStreamException {
		delegate.setPrefix(a, b);
	}

	@Override
	public void writeAttribute(String a, String b) throws XMLStreamException {
		delegate.writeAttribute(a, b);
	}

	@Override
	public void writeAttribute(String a, String b, String c) throws XMLStreamException {
		delegate.writeAttribute(a, b, c);
	}

	@Override
	public void writeAttribute(String a, String b, String c, String d) throws XMLStreamException {
		delegate.writeAttribute(a, b, c, d);
	}

	@Override
	public void writeCData(String a) throws XMLStreamException {
		delegate.writeCData(a);
	}

	@Override
	public void writeCharacters(char[] a, int b, int c) throws XMLStreamException {
		delegate.writeCharacters(a, b, c);
	}

	@Override
	public void writeCharacters(String a) throws XMLStreamException {
		delegate.writeCharacters(a);
	}

	@Override
	public void writeComment(String a) throws XMLStreamException {
		delegate.writeComment(a);
	}

	@Override
	public void writeDefaultNamespace(String a) throws XMLStreamException {
		delegate.writeDefaultNamespace(a);
	}

	@Override
	public void writeDTD(String a) throws XMLStreamException {
		delegate.writeDTD(a);
	}

	@Override
	public void writeEmptyElement(String a) throws XMLStreamException {
		delegate.writeEmptyElement(a);
	}

	@Override
	public void writeEmptyElement(String a, String b) throws XMLStreamException {
		delegate.writeEmptyElement(a, b);
	}

	@Override
	public void writeEmptyElement(String a, String b, String c) throws XMLStreamException {
		delegate.writeEmptyElement(a, b, c);
	}

	@Override
	public void writeEndDocument() throws XMLStreamException {
		delegate.writeEndDocument();
	}

	@Override
	public void writeEndElement() throws XMLStreamException {
		delegate.writeEndElement();
	}

	@Override
	public void writeEntityRef(String a) throws XMLStreamException {
		delegate.writeEntityRef(a);
	}

	@Override
	public void writeNamespace(String a, String b) throws XMLStreamException {
	}

	@Override
	public void writeProcessingInstruction(String a) throws XMLStreamException {
		delegate.writeProcessingInstruction(a);
	}

	@Override
	public void writeProcessingInstruction(String a, String b) throws XMLStreamException {
		delegate.writeProcessingInstruction(a, b);
	}

	@Override
	public void writeStartDocument() throws XMLStreamException {
		delegate.writeStartDocument();
	}

	@Override
	public void writeStartDocument(String a) throws XMLStreamException {
		delegate.writeStartDocument(a);
	}

	@Override
	public void writeStartDocument(String a, String b) throws XMLStreamException {
		delegate.writeStartDocument(a, b);
	}

	@Override
	public void writeStartElement(String a) throws XMLStreamException {
		delegate.writeStartElement(a);
	}

	@Override
	public void writeStartElement(String a, String b) throws XMLStreamException {
		delegate.writeStartElement(a, b);
	}

	@Override
	public void writeStartElement(String prefix, String localName, String ns) throws XMLStreamException {
		if (EPP_NS.equals(ns)) {
			delegate.writeStartElement("", localName, ns);
			if ("epp".equals(localName)) {
				delegate.writeDefaultNamespace(ns);
			}
		} else {
			delegate.writeStartElement(prefix, localName, ns);
			delegate.writeNamespace(prefix, ns);
		}
	}

	private final XMLStreamWriter delegate;
}