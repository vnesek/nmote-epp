//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.26 at 10:13:52 AM CET 
//


package org.ietf.epp.eppcom;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trStatusType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="trStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="clientApproved"/&gt;
 *     &lt;enumeration value="clientCancelled"/&gt;
 *     &lt;enumeration value="clientRejected"/&gt;
 *     &lt;enumeration value="pending"/&gt;
 *     &lt;enumeration value="serverApproved"/&gt;
 *     &lt;enumeration value="serverCancelled"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "trStatusType", namespace = "urn:ietf:params:xml:ns:eppcom-1.0")
@XmlEnum
public enum TrStatusType {

    @XmlEnumValue("clientApproved")
    CLIENT_APPROVED("clientApproved"),
    @XmlEnumValue("clientCancelled")
    CLIENT_CANCELLED("clientCancelled"),
    @XmlEnumValue("clientRejected")
    CLIENT_REJECTED("clientRejected"),
    @XmlEnumValue("pending")
    PENDING("pending"),
    @XmlEnumValue("serverApproved")
    SERVER_APPROVED("serverApproved"),
    @XmlEnumValue("serverCancelled")
    SERVER_CANCELLED("serverCancelled");

    TrStatusType(String v) {
        value = v;
    }

    public static TrStatusType fromValue(String v) {
        for (TrStatusType c : TrStatusType.values()) {
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
