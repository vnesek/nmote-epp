//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusValueType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="statusValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="clientDeleteProhibited"/&gt;
 *     &lt;enumeration value="clientHold"/&gt;
 *     &lt;enumeration value="clientRenewProhibited"/&gt;
 *     &lt;enumeration value="clientTransferProhibited"/&gt;
 *     &lt;enumeration value="clientUpdateProhibited"/&gt;
 *     &lt;enumeration value="inactive"/&gt;
 *     &lt;enumeration value="ok"/&gt;
 *     &lt;enumeration value="pendingCreate"/&gt;
 *     &lt;enumeration value="pendingDelete"/&gt;
 *     &lt;enumeration value="pendingRenew"/&gt;
 *     &lt;enumeration value="pendingTransfer"/&gt;
 *     &lt;enumeration value="pendingUpdate"/&gt;
 *     &lt;enumeration value="serverDeleteProhibited"/&gt;
 *     &lt;enumeration value="serverHold"/&gt;
 *     &lt;enumeration value="serverRenewProhibited"/&gt;
 *     &lt;enumeration value="serverTransferProhibited"/&gt;
 *     &lt;enumeration value="serverUpdateProhibited"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "statusValueType")
@XmlEnum
public enum StatusValueType {

    @XmlEnumValue("clientDeleteProhibited")
    CLIENT_DELETE_PROHIBITED("clientDeleteProhibited"),
    @XmlEnumValue("clientHold")
    CLIENT_HOLD("clientHold"),
    @XmlEnumValue("clientRenewProhibited")
    CLIENT_RENEW_PROHIBITED("clientRenewProhibited"),
    @XmlEnumValue("clientTransferProhibited")
    CLIENT_TRANSFER_PROHIBITED("clientTransferProhibited"),
    @XmlEnumValue("clientUpdateProhibited")
    CLIENT_UPDATE_PROHIBITED("clientUpdateProhibited"),
    @XmlEnumValue("inactive")
    INACTIVE("inactive"),
    @XmlEnumValue("ok")
    OK("ok"),
    @XmlEnumValue("pendingCreate")
    PENDING_CREATE("pendingCreate"),
    @XmlEnumValue("pendingDelete")
    PENDING_DELETE("pendingDelete"),
    @XmlEnumValue("pendingRenew")
    PENDING_RENEW("pendingRenew"),
    @XmlEnumValue("pendingTransfer")
    PENDING_TRANSFER("pendingTransfer"),
    @XmlEnumValue("pendingUpdate")
    PENDING_UPDATE("pendingUpdate"),
    @XmlEnumValue("serverDeleteProhibited")
    SERVER_DELETE_PROHIBITED("serverDeleteProhibited"),
    @XmlEnumValue("serverHold")
    SERVER_HOLD("serverHold"),
    @XmlEnumValue("serverRenewProhibited")
    SERVER_RENEW_PROHIBITED("serverRenewProhibited"),
    @XmlEnumValue("serverTransferProhibited")
    SERVER_TRANSFER_PROHIBITED("serverTransferProhibited"),
    @XmlEnumValue("serverUpdateProhibited")
    SERVER_UPDATE_PROHIBITED("serverUpdateProhibited");

    StatusValueType(String v) {
        value = v;
    }

    public static StatusValueType fromValue(String v) {
        for (StatusValueType c : StatusValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public String value() {
        return value;
    }

    private final String value;

}
