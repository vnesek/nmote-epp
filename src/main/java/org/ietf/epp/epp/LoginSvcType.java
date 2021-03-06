//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.26 at 10:13:52 AM CET 
//


package org.ietf.epp.epp;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for loginSvcType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="loginSvcType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="objURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded"/&gt;
 *         &lt;element name="svcExtension" type="{urn:ietf:params:xml:ns:epp-1.0}extURIType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loginSvcType", namespace = "urn:ietf:params:xml:ns:epp-1.0", propOrder = {
        "objURIs",
        "svcExtension"
})
public class LoginSvcType {

    /**
     * Gets the value of the objURIs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objURIs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjURIs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getObjURIs() {
        if (objURIs == null) {
            objURIs = new ArrayList<String>();
        }
        return this.objURIs;
    }

    /**
     * Gets the value of the svcExtension property.
     *
     * @return possible object is
     * {@link ExtURIType }
     */
    public ExtURIType getSvcExtension() {
        return svcExtension;
    }

    /**
     * Sets the value of the svcExtension property.
     *
     * @param value allowed object is
     *              {@link ExtURIType }
     */
    public void setSvcExtension(ExtURIType value) {
        this.svcExtension = value;
    }

    @XmlElement(name = "objURI", namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> objURIs;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ExtURIType svcExtension;

}
