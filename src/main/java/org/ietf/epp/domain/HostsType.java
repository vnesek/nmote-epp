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
 * <p>Java class for hostsType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="hostsType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="all"/&gt;
 *     &lt;enumeration value="del"/&gt;
 *     &lt;enumeration value="none"/&gt;
 *     &lt;enumeration value="sub"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "hostsType")
@XmlEnum
public enum HostsType {

    @XmlEnumValue("all")
    ALL("all"),
    @XmlEnumValue("del")
    DEL("del"),
    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("sub")
    SUB("sub");

    HostsType(String v) {
        value = v;
    }

    public static HostsType fromValue(String v) {
        for (HostsType c : HostsType.values()) {
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
