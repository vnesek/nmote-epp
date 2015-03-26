//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.26 at 10:13:52 AM CET 
//


package org.ietf.epp.epp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for loginType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loginType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clID" type="{urn:ietf:params:xml:ns:eppcom-1.0}clIDType"/>
 *         &lt;element name="pw" type="{urn:ietf:params:xml:ns:epp-1.0}pwType"/>
 *         &lt;element name="newPW" type="{urn:ietf:params:xml:ns:epp-1.0}pwType" minOccurs="0"/>
 *         &lt;element name="options" type="{urn:ietf:params:xml:ns:epp-1.0}credsOptionsType"/>
 *         &lt;element name="svcs" type="{urn:ietf:params:xml:ns:epp-1.0}loginSvcType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loginType", namespace = "urn:ietf:params:xml:ns:epp-1.0", propOrder = {
    "clID",
    "pw",
    "newPW",
    "options",
    "svcs"
})
public class LoginType {

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String clID;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String pw;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String newPW;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    protected CredsOptionsType options;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    protected LoginSvcType svcs;

    /**
     * Gets the value of the clID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClID() {
        return clID;
    }

    /**
     * Sets the value of the clID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClID(String value) {
        this.clID = value;
    }

    /**
     * Gets the value of the pw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPw() {
        return pw;
    }

    /**
     * Sets the value of the pw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPw(String value) {
        this.pw = value;
    }

    /**
     * Gets the value of the newPW property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPW() {
        return newPW;
    }

    /**
     * Sets the value of the newPW property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPW(String value) {
        this.newPW = value;
    }

    /**
     * Gets the value of the options property.
     * 
     * @return
     *     possible object is
     *     {@link CredsOptionsType }
     *     
     */
    public CredsOptionsType getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     * 
     * @param value
     *     allowed object is
     *     {@link CredsOptionsType }
     *     
     */
    public void setOptions(CredsOptionsType value) {
        this.options = value;
    }

    /**
     * Gets the value of the svcs property.
     * 
     * @return
     *     possible object is
     *     {@link LoginSvcType }
     *     
     */
    public LoginSvcType getSvcs() {
        return svcs;
    }

    /**
     * Sets the value of the svcs property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoginSvcType }
     *     
     */
    public void setSvcs(LoginSvcType value) {
        this.svcs = value;
    }

}
