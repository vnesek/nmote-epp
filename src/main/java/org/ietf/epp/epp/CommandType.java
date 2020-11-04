//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.26 at 10:13:52 AM CET 
//


package org.ietf.epp.epp;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for commandType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="commandType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="check" type="{urn:ietf:params:xml:ns:epp-1.0}readWriteType"/&gt;
 *           &lt;element name="create" type="{urn:ietf:params:xml:ns:epp-1.0}readWriteType"/&gt;
 *           &lt;element name="delete" type="{urn:ietf:params:xml:ns:epp-1.0}readWriteType"/&gt;
 *           &lt;element name="info" type="{urn:ietf:params:xml:ns:epp-1.0}readWriteType"/&gt;
 *           &lt;element name="login" type="{urn:ietf:params:xml:ns:epp-1.0}loginType"/&gt;
 *           &lt;element name="logout" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="poll" type="{urn:ietf:params:xml:ns:epp-1.0}pollType"/&gt;
 *           &lt;element name="renew" type="{urn:ietf:params:xml:ns:epp-1.0}readWriteType"/&gt;
 *           &lt;element name="transfer" type="{urn:ietf:params:xml:ns:epp-1.0}transferType"/&gt;
 *           &lt;element name="update" type="{urn:ietf:params:xml:ns:epp-1.0}readWriteType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="extension" type="{urn:ietf:params:xml:ns:epp-1.0}extAnyType" minOccurs="0"/&gt;
 *         &lt;element name="clTRID" type="{urn:ietf:params:xml:ns:epp-1.0}trIDStringType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commandType", namespace = "urn:ietf:params:xml:ns:epp-1.0", propOrder = {
        "update",
        "transfer",
        "renew",
        "poll",
        "logout",
        "login",
        "info",
        "delete",
        "create",
        "check",
        "extension",
        "clTRID"
})
public class CommandType {

    /**
     * Gets the value of the update property.
     *
     * @return possible object is
     * {@link ReadWriteType }
     */
    public ReadWriteType getUpdate() {
        return update;
    }

    /**
     * Sets the value of the update property.
     *
     * @param value allowed object is
     *              {@link ReadWriteType }
     */
    public void setUpdate(ReadWriteType value) {
        this.update = value;
    }

    /**
     * Gets the value of the transfer property.
     *
     * @return possible object is
     * {@link TransferType }
     */
    public TransferType getTransfer() {
        return transfer;
    }

    /**
     * Sets the value of the transfer property.
     *
     * @param value allowed object is
     *              {@link TransferType }
     */
    public void setTransfer(TransferType value) {
        this.transfer = value;
    }

    /**
     * Gets the value of the renew property.
     *
     * @return possible object is
     * {@link ReadWriteType }
     */
    public ReadWriteType getRenew() {
        return renew;
    }

    /**
     * Sets the value of the renew property.
     *
     * @param value allowed object is
     *              {@link ReadWriteType }
     */
    public void setRenew(ReadWriteType value) {
        this.renew = value;
    }

    /**
     * Gets the value of the poll property.
     *
     * @return possible object is
     * {@link PollType }
     */
    public PollType getPoll() {
        return poll;
    }

    /**
     * Sets the value of the poll property.
     *
     * @param value allowed object is
     *              {@link PollType }
     */
    public void setPoll(PollType value) {
        this.poll = value;
    }

    /**
     * Gets the value of the logout property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLogout() {
        return logout;
    }

    /**
     * Sets the value of the logout property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLogout(String value) {
        this.logout = value;
    }

    /**
     * Gets the value of the login property.
     *
     * @return possible object is
     * {@link LoginType }
     */
    public LoginType getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     *
     * @param value allowed object is
     *              {@link LoginType }
     */
    public void setLogin(LoginType value) {
        this.login = value;
    }

    /**
     * Gets the value of the info property.
     *
     * @return possible object is
     * {@link ReadWriteType }
     */
    public ReadWriteType getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     *
     * @param value allowed object is
     *              {@link ReadWriteType }
     */
    public void setInfo(ReadWriteType value) {
        this.info = value;
    }

    /**
     * Gets the value of the delete property.
     *
     * @return possible object is
     * {@link ReadWriteType }
     */
    public ReadWriteType getDelete() {
        return delete;
    }

    /**
     * Sets the value of the delete property.
     *
     * @param value allowed object is
     *              {@link ReadWriteType }
     */
    public void setDelete(ReadWriteType value) {
        this.delete = value;
    }

    /**
     * Gets the value of the create property.
     *
     * @return possible object is
     * {@link ReadWriteType }
     */
    public ReadWriteType getCreate() {
        return create;
    }

    /**
     * Sets the value of the create property.
     *
     * @param value allowed object is
     *              {@link ReadWriteType }
     */
    public void setCreate(ReadWriteType value) {
        this.create = value;
    }

    /**
     * Gets the value of the check property.
     *
     * @return possible object is
     * {@link ReadWriteType }
     */
    public ReadWriteType getCheck() {
        return check;
    }

    /**
     * Sets the value of the check property.
     *
     * @param value allowed object is
     *              {@link ReadWriteType }
     */
    public void setCheck(ReadWriteType value) {
        this.check = value;
    }

    /**
     * Gets the value of the extension property.
     *
     * @return possible object is
     * {@link ExtAnyType }
     */
    public ExtAnyType getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     *
     * @param value allowed object is
     *              {@link ExtAnyType }
     */
    public void setExtension(ExtAnyType value) {
        this.extension = value;
    }

    /**
     * Gets the value of the clTRID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getClTRID() {
        return clTRID;
    }

    /**
     * Sets the value of the clTRID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setClTRID(String value) {
        this.clTRID = value;
    }

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ReadWriteType update;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected TransferType transfer;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ReadWriteType renew;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected PollType poll;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected String logout;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected LoginType login;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ReadWriteType info;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ReadWriteType delete;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ReadWriteType create;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ReadWriteType check;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ExtAnyType extension;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String clTRID;

}
