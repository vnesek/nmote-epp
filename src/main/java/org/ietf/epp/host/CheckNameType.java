//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.host;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for checkNameType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="checkNameType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;urn:ietf:params:xml:ns:eppcom-1.0&gt;labelType"&gt;
 *       &lt;attribute name="avail" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkNameType", propOrder = {
        "value"
})
public class CheckNameType {

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the avail property.
     */
    public boolean isAvail() {
        return avail;
    }

    /**
     * Sets the value of the avail property.
     */
    public void setAvail(boolean value) {
        this.avail = value;
    }

    @XmlValue
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String value;

    @XmlAttribute(name = "avail", required = true)
    protected boolean avail;

}
