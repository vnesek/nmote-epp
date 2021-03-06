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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for nsType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="nsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="hostObj" type="{urn:ietf:params:xml:ns:eppcom-1.0}labelType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="hostAttr" type="{urn:ietf:params:xml:ns:domain-1.0}hostAttrType" maxOccurs="unbounded"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nsType", propOrder = {
        "hostAttrs",
        "hostObjs"
})
public class NsType {

    /**
     * Gets the value of the hostAttrs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostAttrs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostAttrs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostAttrType }
     */
    public List<HostAttrType> getHostAttrs() {
        if (hostAttrs == null) {
            hostAttrs = new ArrayList<HostAttrType>();
        }
        return this.hostAttrs;
    }

    /**
     * Gets the value of the hostObjs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostObjs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostObjs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getHostObjs() {
        if (hostObjs == null) {
            hostObjs = new ArrayList<String>();
        }
        return this.hostObjs;
    }

    @XmlElement(name = "hostAttr")
    protected List<HostAttrType> hostAttrs;

    @XmlElement(name = "hostObj")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> hostObjs;

}
