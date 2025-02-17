/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.epp;

import org.ietf.epp.epp.Epp;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ServerEppEndpoint extends EppEndpoint {

    public ServerEppEndpoint() {
    }

    @Override
    public Epp send(Epp request) throws EppException, IOException, JAXBException {
        return null;
    }


    public boolean isConnected() {
        return true;
    }

}
