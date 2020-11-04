//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.domain;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for infoNameType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="infoNameType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;urn:ietf:params:xml:ns:eppcom-1.0&gt;labelType"&gt;
 *       &lt;attribute name="hosts" type="{urn:ietf:params:xml:ns:domain-1.0}hostsType" default="all" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoNameType", propOrder = {
        "value"
})
public class InfoNameType {

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
     * Gets the value of the hosts property.
     *
     * @return possible object is
     * {@link HostsType }
     */
    public HostsType getHosts() {
        if (hosts == null) {
            return HostsType.ALL;
        } else {
            return hosts;
        }
    }

    /**
     * Sets the value of the hosts property.
     *
     * @param value allowed object is
     *              {@link HostsType }
     */
    public void setHosts(HostsType value) {
        this.hosts = value;
    }

    @XmlValue
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String value;

    @XmlAttribute(name = "hosts")
    protected HostsType hosts;

}
