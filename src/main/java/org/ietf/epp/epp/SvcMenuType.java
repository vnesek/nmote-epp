//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.26 at 10:13:52 AM CET 
//


package org.ietf.epp.epp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for svcMenuType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="svcMenuType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{urn:ietf:params:xml:ns:epp-1.0}versionType" maxOccurs="unbounded"/>
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}language" maxOccurs="unbounded"/>
 *         &lt;element name="objURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded"/>
 *         &lt;element name="svcExtension" type="{urn:ietf:params:xml:ns:epp-1.0}extURIType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "svcMenuType", namespace = "urn:ietf:params:xml:ns:epp-1.0", propOrder = {
    "versions",
    "langs",
    "objURIs",
    "svcExtension"
})
public class SvcMenuType {

    @XmlElement(name = "version", namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> versions;
    @XmlElement(name = "lang", namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected List<String> langs;
    @XmlElement(name = "objURI", namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> objURIs;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ExtURIType svcExtension;

    /**
     * Gets the value of the versions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the versions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVersions() {
        if (versions == null) {
            versions = new ArrayList<String>();
        }
        return this.versions;
    }

    /**
     * Gets the value of the langs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the langs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLangs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLangs() {
        if (langs == null) {
            langs = new ArrayList<String>();
        }
        return this.langs;
    }

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
     * 
     * 
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
     * @return
     *     possible object is
     *     {@link ExtURIType }
     *     
     */
    public ExtURIType getSvcExtension() {
        return svcExtension;
    }

    /**
     * Sets the value of the svcExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtURIType }
     *     
     */
    public void setSvcExtension(ExtURIType value) {
        this.svcExtension = value;
    }

}
