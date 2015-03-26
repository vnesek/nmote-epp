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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="msg" type="{urn:ietf:params:xml:ns:epp-1.0}msgType"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="value" type="{urn:ietf:params:xml:ns:epp-1.0}errValueType"/>
 *           &lt;element name="extValue" type="{urn:ietf:params:xml:ns:epp-1.0}extErrValueType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="code" use="required" type="{urn:ietf:params:xml:ns:epp-1.0}resultCodeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultType", namespace = "urn:ietf:params:xml:ns:epp-1.0", propOrder = {
    "msg",
    "valuesAndExtValues"
})
public class ResultType {

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    protected MsgType msg;
    @XmlElements({
        @XmlElement(name = "value", namespace = "urn:ietf:params:xml:ns:epp-1.0", type = ErrValueType.class),
        @XmlElement(name = "extValue", namespace = "urn:ietf:params:xml:ns:epp-1.0", type = ExtErrValueType.class)
    })
    protected List<Object> valuesAndExtValues;
    @XmlAttribute(name = "code", required = true)
    protected int code;

    /**
     * Gets the value of the msg property.
     * 
     * @return
     *     possible object is
     *     {@link MsgType }
     *     
     */
    public MsgType getMsg() {
        return msg;
    }

    /**
     * Sets the value of the msg property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgType }
     *     
     */
    public void setMsg(MsgType value) {
        this.msg = value;
    }

    /**
     * Gets the value of the valuesAndExtValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valuesAndExtValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValuesAndExtValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrValueType }
     * {@link ExtErrValueType }
     * 
     * 
     */
    public List<Object> getValuesAndExtValues() {
        if (valuesAndExtValues == null) {
            valuesAndExtValues = new ArrayList<Object>();
        }
        return this.valuesAndExtValues;
    }

    /**
     * Gets the value of the code property.
     * 
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     */
    public void setCode(int value) {
        this.code = value;
    }

}
