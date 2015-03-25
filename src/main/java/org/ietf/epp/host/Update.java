//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.host;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for updateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{urn:ietf:params:xml:ns:eppcom-1.0}labelType"/>
 *         &lt;element name="add" type="{urn:ietf:params:xml:ns:host-1.0}addRemType" minOccurs="0"/>
 *         &lt;element name="rem" type="{urn:ietf:params:xml:ns:host-1.0}addRemType" minOccurs="0"/>
 *         &lt;element name="chg" type="{urn:ietf:params:xml:ns:host-1.0}chgType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateType", propOrder = {
    "name",
    "add",
    "rem",
    "chg"
})
@XmlRootElement(name = "update")
public class Update {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String name;
    protected AddRemType add;
    protected AddRemType rem;
    protected ChgType chg;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the add property.
     * 
     * @return
     *     possible object is
     *     {@link AddRemType }
     *     
     */
    public AddRemType getAdd() {
        return add;
    }

    /**
     * Sets the value of the add property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddRemType }
     *     
     */
    public void setAdd(AddRemType value) {
        this.add = value;
    }

    /**
     * Gets the value of the rem property.
     * 
     * @return
     *     possible object is
     *     {@link AddRemType }
     *     
     */
    public AddRemType getRem() {
        return rem;
    }

    /**
     * Sets the value of the rem property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddRemType }
     *     
     */
    public void setRem(AddRemType value) {
        this.rem = value;
    }

    /**
     * Gets the value of the chg property.
     * 
     * @return
     *     possible object is
     *     {@link ChgType }
     *     
     */
    public ChgType getChg() {
        return chg;
    }

    /**
     * Sets the value of the chg property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChgType }
     *     
     */
    public void setChg(ChgType value) {
        this.chg = value;
    }

}
