package com.nmote.epp;

import java.io.Closeable;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.ietf.epp.epp.Epp;

public interface EppEndpoint extends Closeable {

	Epp send(Epp request) throws EppException, IOException, JAXBException;

}
