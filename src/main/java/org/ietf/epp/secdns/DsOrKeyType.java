//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.secdns;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dsOrKeyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dsOrKeyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maxSigLife" type="{urn:ietf:params:xml:ns:secDNS-1.1}maxSigLifeType" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="dsData" type="{urn:ietf:params:xml:ns:secDNS-1.1}dsDataType" maxOccurs="unbounded"/>
 *           &lt;element name="keyData" type="{urn:ietf:params:xml:ns:secDNS-1.1}keyDataType" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dsOrKeyType", propOrder = {
    "maxSigLife",
    "keyDatas",
    "dsDatas"
})
public class DsOrKeyType {

    protected Integer maxSigLife;
    @XmlElement(name = "keyData")
    protected List<KeyDataType> keyDatas;
    @XmlElement(name = "dsData")
    protected List<DsDataType> dsDatas;

    /**
     * Gets the value of the maxSigLife property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxSigLife() {
        return maxSigLife;
    }

    /**
     * Sets the value of the maxSigLife property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxSigLife(Integer value) {
        this.maxSigLife = value;
    }

    /**
     * Gets the value of the keyDatas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyDatas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyDatas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyDataType }
     * 
     * 
     */
    public List<KeyDataType> getKeyDatas() {
        if (keyDatas == null) {
            keyDatas = new ArrayList<KeyDataType>();
        }
        return this.keyDatas;
    }

    /**
     * Gets the value of the dsDatas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dsDatas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDsDatas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DsDataType }
     * 
     * 
     */
    public List<DsDataType> getDsDatas() {
        if (dsDatas == null) {
            dsDatas = new ArrayList<DsDataType>();
        }
        return this.dsDatas;
    }

}
