//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.17 at 05:43:45 PM CET 
//


package org.ietf.epp.secdns;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for keyDataType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="keyDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="flags" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="protocol" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="alg" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="pubKey" type="{urn:ietf:params:xml:ns:secDNS-1.1}keyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "keyDataType", propOrder = {
        "flags",
        "protocol",
        "alg",
        "pubKey"
})
public class KeyDataType {

    /**
     * Gets the value of the flags property.
     */
    public int getFlags() {
        return flags;
    }

    /**
     * Sets the value of the flags property.
     */
    public void setFlags(int value) {
        this.flags = value;
    }

    /**
     * Gets the value of the protocol property.
     */
    public short getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     */
    public void setProtocol(short value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the alg property.
     */
    public short getAlg() {
        return alg;
    }

    /**
     * Sets the value of the alg property.
     */
    public void setAlg(short value) {
        this.alg = value;
    }

    /**
     * Gets the value of the pubKey property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getPubKey() {
        return pubKey;
    }

    /**
     * Sets the value of the pubKey property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setPubKey(byte[] value) {
        this.pubKey = value;
    }

    @XmlSchemaType(name = "unsignedShort")
    protected int flags;

    @XmlSchemaType(name = "unsignedByte")
    protected short protocol;

    @XmlSchemaType(name = "unsignedByte")
    protected short alg;

    @XmlElement(required = true)
    protected byte[] pubKey;

}
