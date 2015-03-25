//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.contact;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusValueType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="statusValueType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="clientDeleteProhibited"/>
 *     &lt;enumeration value="clientTransferProhibited"/>
 *     &lt;enumeration value="clientUpdateProhibited"/>
 *     &lt;enumeration value="linked"/>
 *     &lt;enumeration value="ok"/>
 *     &lt;enumeration value="pendingCreate"/>
 *     &lt;enumeration value="pendingDelete"/>
 *     &lt;enumeration value="pendingTransfer"/>
 *     &lt;enumeration value="pendingUpdate"/>
 *     &lt;enumeration value="serverDeleteProhibited"/>
 *     &lt;enumeration value="serverTransferProhibited"/>
 *     &lt;enumeration value="serverUpdateProhibited"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "statusValueType")
@XmlEnum
public enum StatusValueType {

    @XmlEnumValue("clientDeleteProhibited")
    CLIENT_DELETE_PROHIBITED("clientDeleteProhibited"),
    @XmlEnumValue("clientTransferProhibited")
    CLIENT_TRANSFER_PROHIBITED("clientTransferProhibited"),
    @XmlEnumValue("clientUpdateProhibited")
    CLIENT_UPDATE_PROHIBITED("clientUpdateProhibited"),
    @XmlEnumValue("linked")
    LINKED("linked"),
    @XmlEnumValue("ok")
    OK("ok"),
    @XmlEnumValue("pendingCreate")
    PENDING_CREATE("pendingCreate"),
    @XmlEnumValue("pendingDelete")
    PENDING_DELETE("pendingDelete"),
    @XmlEnumValue("pendingTransfer")
    PENDING_TRANSFER("pendingTransfer"),
    @XmlEnumValue("pendingUpdate")
    PENDING_UPDATE("pendingUpdate"),
    @XmlEnumValue("serverDeleteProhibited")
    SERVER_DELETE_PROHIBITED("serverDeleteProhibited"),
    @XmlEnumValue("serverTransferProhibited")
    SERVER_TRANSFER_PROHIBITED("serverTransferProhibited"),
    @XmlEnumValue("serverUpdateProhibited")
    SERVER_UPDATE_PROHIBITED("serverUpdateProhibited");
    private final String value;

    StatusValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusValueType fromValue(String v) {
        for (StatusValueType c: StatusValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
