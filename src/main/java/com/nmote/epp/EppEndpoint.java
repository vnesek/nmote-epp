package com.nmote.epp;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.ietf.epp.epp.Epp;

@FunctionalInterface
public interface EppEndpoint {

	Epp send(Epp request) throws EppException, IOException, JAXBException;
}
