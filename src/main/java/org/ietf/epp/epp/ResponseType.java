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
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for responseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="responseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="result" type="{urn:ietf:params:xml:ns:epp-1.0}resultType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="msgQ" type="{urn:ietf:params:xml:ns:epp-1.0}msgQType" minOccurs="0"/&gt;
 *         &lt;element name="resData" type="{urn:ietf:params:xml:ns:epp-1.0}extAnyType" minOccurs="0"/&gt;
 *         &lt;element name="extension" type="{urn:ietf:params:xml:ns:epp-1.0}extAnyType" minOccurs="0"/&gt;
 *         &lt;element name="trID" type="{urn:ietf:params:xml:ns:epp-1.0}trIDType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseType", namespace = "urn:ietf:params:xml:ns:epp-1.0", propOrder = {
        "results",
        "msgQ",
        "resData",
        "extension",
        "trID"
})
public class ResponseType {

    /**
     * Gets the value of the results property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the results property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResults().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResultType }
     */
    public List<ResultType> getResults() {
        if (results == null) {
            results = new ArrayList<ResultType>();
        }
        return this.results;
    }

    /**
     * Gets the value of the msgQ property.
     *
     * @return possible object is
     * {@link MsgQType }
     */
    public MsgQType getMsgQ() {
        return msgQ;
    }

    /**
     * Sets the value of the msgQ property.
     *
     * @param value allowed object is
     *              {@link MsgQType }
     */
    public void setMsgQ(MsgQType value) {
        this.msgQ = value;
    }

    /**
     * Gets the value of the resData property.
     *
     * @return possible object is
     * {@link ExtAnyType }
     */
    public ExtAnyType getResData() {
        return resData;
    }

    /**
     * Sets the value of the resData property.
     *
     * @param value allowed object is
     *              {@link ExtAnyType }
     */
    public void setResData(ExtAnyType value) {
        this.resData = value;
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
     * Gets the value of the trID property.
     *
     * @return possible object is
     * {@link TrIDType }
     */
    public TrIDType getTrID() {
        return trID;
    }

    /**
     * Sets the value of the trID property.
     *
     * @param value allowed object is
     *              {@link TrIDType }
     */
    public void setTrID(TrIDType value) {
        this.trID = value;
    }

    @XmlElement(name = "result", namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    protected List<ResultType> results;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected MsgQType msgQ;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ExtAnyType resData;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0")
    protected ExtAnyType extension;

    @XmlElement(namespace = "urn:ietf:params:xml:ns:epp-1.0", required = true)
    protected TrIDType trID;

}
