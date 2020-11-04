//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.contact;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for discloseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="discloseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{urn:ietf:params:xml:ns:contact-1.0}intLocType" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element name="org" type="{urn:ietf:params:xml:ns:contact-1.0}intLocType" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element name="addr" type="{urn:ietf:params:xml:ns:contact-1.0}intLocType" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element name="voice" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="flag" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discloseType", propOrder = {
        "names",
        "orgs",
        "addrs",
        "voice",
        "fax",
        "email"
})
public class DiscloseType {

    /**
     * Gets the value of the names property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the names property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNames().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntLocType }
     */
    public List<IntLocType> getNames() {
        if (names == null) {
            names = new ArrayList<IntLocType>();
        }
        return this.names;
    }

    /**
     * Gets the value of the orgs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrgs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntLocType }
     */
    public List<IntLocType> getOrgs() {
        if (orgs == null) {
            orgs = new ArrayList<IntLocType>();
        }
        return this.orgs;
    }

    /**
     * Gets the value of the addrs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addrs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddrs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntLocType }
     */
    public List<IntLocType> getAddrs() {
        if (addrs == null) {
            addrs = new ArrayList<IntLocType>();
        }
        return this.addrs;
    }

    /**
     * Gets the value of the voice property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getVoice() {
        return voice;
    }

    /**
     * Sets the value of the voice property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setVoice(Object value) {
        this.voice = value;
    }

    /**
     * Gets the value of the fax property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setFax(Object value) {
        this.fax = value;
    }

    /**
     * Gets the value of the email property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setEmail(Object value) {
        this.email = value;
    }

    /**
     * Gets the value of the flag property.
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     */
    public void setFlag(boolean value) {
        this.flag = value;
    }

    @XmlElement(name = "name")
    protected List<IntLocType> names;

    @XmlElement(name = "org")
    protected List<IntLocType> orgs;

    @XmlElement(name = "addr")
    protected List<IntLocType> addrs;

    protected Object voice;

    protected Object fax;

    protected Object email;

    @XmlAttribute(name = "flag", required = true)
    protected boolean flag;

}
