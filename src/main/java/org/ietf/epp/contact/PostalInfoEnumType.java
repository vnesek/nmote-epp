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
 * <p>Java class for postalInfoEnumType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="postalInfoEnumType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="loc"/&gt;
 *     &lt;enumeration value="int"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "postalInfoEnumType")
@XmlEnum
public enum PostalInfoEnumType {

    @XmlEnumValue("loc")
    LOC("loc"),
    @XmlEnumValue("int")
    INT("int");

    PostalInfoEnumType(String v) {
        value = v;
    }

    public static PostalInfoEnumType fromValue(String v) {
        for (PostalInfoEnumType c : PostalInfoEnumType.values()) {
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
