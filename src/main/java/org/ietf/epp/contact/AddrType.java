//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.contact;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for addrType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="addrType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="street" type="{urn:ietf:params:xml:ns:contact-1.0}optPostalLineType" maxOccurs="3" minOccurs="0"/&gt;
 *         &lt;element name="city" type="{urn:ietf:params:xml:ns:contact-1.0}postalLineType"/&gt;
 *         &lt;element name="sp" type="{urn:ietf:params:xml:ns:contact-1.0}optPostalLineType" minOccurs="0"/&gt;
 *         &lt;element name="pc" type="{urn:ietf:params:xml:ns:contact-1.0}pcType" minOccurs="0"/&gt;
 *         &lt;element name="cc" type="{urn:ietf:params:xml:ns:contact-1.0}ccType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addrType", propOrder = {
        "streets",
        "city",
        "sp",
        "pc",
        "cc"
})
public class AddrType {

    /**
     * Gets the value of the streets property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the streets property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStreets().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getStreets() {
        if (streets == null) {
            streets = new ArrayList<String>();
        }
        return this.streets;
    }

    /**
     * Gets the value of the city property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the sp property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSp() {
        return sp;
    }

    /**
     * Sets the value of the sp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSp(String value) {
        this.sp = value;
    }

    /**
     * Gets the value of the pc property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPc() {
        return pc;
    }

    /**
     * Sets the value of the pc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPc(String value) {
        this.pc = value;
    }

    /**
     * Gets the value of the cc property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCc() {
        return cc;
    }

    /**
     * Sets the value of the cc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCc(String value) {
        this.cc = value;
    }

    @XmlElement(name = "street")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected List<String> streets;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String city;

    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String sp;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String pc;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String cc;

}
