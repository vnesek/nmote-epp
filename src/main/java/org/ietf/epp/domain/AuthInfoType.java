//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.ietf.epp.eppcom.ExtAuthInfoType;
import org.ietf.epp.eppcom.PwAuthInfoType;


/**
 * <p>Java class for authInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="authInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="pw" type="{urn:ietf:params:xml:ns:eppcom-1.0}pwAuthInfoType"/>
 *         &lt;element name="ext" type="{urn:ietf:params:xml:ns:eppcom-1.0}extAuthInfoType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authInfoType", propOrder = {
    "ext",
    "pw"
})
public class AuthInfoType {

    protected ExtAuthInfoType ext;
    protected PwAuthInfoType pw;

    /**
     * Gets the value of the ext property.
     * 
     * @return
     *     possible object is
     *     {@link ExtAuthInfoType }
     *     
     */
    public ExtAuthInfoType getExt() {
        return ext;
    }

    /**
     * Sets the value of the ext property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtAuthInfoType }
     *     
     */
    public void setExt(ExtAuthInfoType value) {
        this.ext = value;
    }

    /**
     * Gets the value of the pw property.
     * 
     * @return
     *     possible object is
     *     {@link PwAuthInfoType }
     *     
     */
    public PwAuthInfoType getPw() {
        return pw;
    }

    /**
     * Sets the value of the pw property.
     * 
     * @param value
     *     allowed object is
     *     {@link PwAuthInfoType }
     *     
     */
    public void setPw(PwAuthInfoType value) {
        this.pw = value;
    }

}
