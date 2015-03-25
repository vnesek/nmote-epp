//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.contact;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for infDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="infDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{urn:ietf:params:xml:ns:eppcom-1.0}clIDType"/>
 *         &lt;element name="roid" type="{urn:ietf:params:xml:ns:eppcom-1.0}roidType"/>
 *         &lt;element name="status" type="{urn:ietf:params:xml:ns:contact-1.0}statusType" maxOccurs="7"/>
 *         &lt;element name="postalInfo" type="{urn:ietf:params:xml:ns:contact-1.0}postalInfoType" maxOccurs="2"/>
 *         &lt;element name="voice" type="{urn:ietf:params:xml:ns:contact-1.0}e164Type" minOccurs="0"/>
 *         &lt;element name="fax" type="{urn:ietf:params:xml:ns:contact-1.0}e164Type" minOccurs="0"/>
 *         &lt;element name="email" type="{urn:ietf:params:xml:ns:eppcom-1.0}minTokenType"/>
 *         &lt;element name="clID" type="{urn:ietf:params:xml:ns:eppcom-1.0}clIDType"/>
 *         &lt;element name="crID" type="{urn:ietf:params:xml:ns:eppcom-1.0}clIDType"/>
 *         &lt;element name="crDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="upID" type="{urn:ietf:params:xml:ns:eppcom-1.0}clIDType" minOccurs="0"/>
 *         &lt;element name="upDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="trDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="authInfo" type="{urn:ietf:params:xml:ns:contact-1.0}authInfoType" minOccurs="0"/>
 *         &lt;element name="disclose" type="{urn:ietf:params:xml:ns:contact-1.0}discloseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infDataType", propOrder = {
    "id",
    "roid",
    "statuses",
    "postalInfos",
    "voice",
    "fax",
    "email",
    "clID",
    "crID",
    "crDate",
    "upID",
    "upDate",
    "trDate",
    "authInfo",
    "disclose"
})
@XmlRootElement(name = "infData")
public class InfData {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String id;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String roid;
    @XmlElement(name = "status", required = true)
    protected List<StatusType> statuses;
    @XmlElement(name = "postalInfo", required = true)
    protected List<PostalInfoType> postalInfos;
    protected E164Type voice;
    protected E164Type fax;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String email;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String clID;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String crID;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar crDate;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String upID;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar upDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar trDate;
    protected AuthInfoType authInfo;
    protected DiscloseType disclose;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the roid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoid() {
        return roid;
    }

    /**
     * Sets the value of the roid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoid(String value) {
        this.roid = value;
    }

    /**
     * Gets the value of the statuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusType }
     * 
     * 
     */
    public List<StatusType> getStatuses() {
        if (statuses == null) {
            statuses = new ArrayList<StatusType>();
        }
        return this.statuses;
    }

    /**
     * Gets the value of the postalInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postalInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostalInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostalInfoType }
     * 
     * 
     */
    public List<PostalInfoType> getPostalInfos() {
        if (postalInfos == null) {
            postalInfos = new ArrayList<PostalInfoType>();
        }
        return this.postalInfos;
    }

    /**
     * Gets the value of the voice property.
     * 
     * @return
     *     possible object is
     *     {@link E164Type }
     *     
     */
    public E164Type getVoice() {
        return voice;
    }

    /**
     * Sets the value of the voice property.
     * 
     * @param value
     *     allowed object is
     *     {@link E164Type }
     *     
     */
    public void setVoice(E164Type value) {
        this.voice = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link E164Type }
     *     
     */
    public E164Type getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link E164Type }
     *     
     */
    public void setFax(E164Type value) {
        this.fax = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

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
     * Gets the value of the crID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrID() {
        return crID;
    }

    /**
     * Sets the value of the crID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrID(String value) {
        this.crID = value;
    }

    /**
     * Gets the value of the crDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCrDate() {
        return crDate;
    }

    /**
     * Sets the value of the crDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCrDate(XMLGregorianCalendar value) {
        this.crDate = value;
    }

    /**
     * Gets the value of the upID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpID() {
        return upID;
    }

    /**
     * Sets the value of the upID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpID(String value) {
        this.upID = value;
    }

    /**
     * Gets the value of the upDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpDate() {
        return upDate;
    }

    /**
     * Sets the value of the upDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpDate(XMLGregorianCalendar value) {
        this.upDate = value;
    }

    /**
     * Gets the value of the trDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTrDate() {
        return trDate;
    }

    /**
     * Sets the value of the trDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTrDate(XMLGregorianCalendar value) {
        this.trDate = value;
    }

    /**
     * Gets the value of the authInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AuthInfoType }
     *     
     */
    public AuthInfoType getAuthInfo() {
        return authInfo;
    }

    /**
     * Sets the value of the authInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthInfoType }
     *     
     */
    public void setAuthInfo(AuthInfoType value) {
        this.authInfo = value;
    }

    /**
     * Gets the value of the disclose property.
     * 
     * @return
     *     possible object is
     *     {@link DiscloseType }
     *     
     */
    public DiscloseType getDisclose() {
        return disclose;
    }

    /**
     * Sets the value of the disclose property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscloseType }
     *     
     */
    public void setDisclose(DiscloseType value) {
        this.disclose = value;
    }

}
