//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.02 at 01:16:04 PM CEST 
//


package hr.dns.epp.contact;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for contactDataCreate complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="contactDataCreate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="type" type="{http://www.dns.hr/epp/hr-1.0}contactType"/&gt;
 *         &lt;element name="in" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contactDataCreate", namespace = "http://www.dns.hr/epp/hr-1.0", propOrder = {
        "type",
        "in"
})
public class ContactDataCreate {

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link ContactType }
     */
    public ContactType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link ContactType }
     */
    public void setType(ContactType value) {
        this.type = value;
    }

    /**
     * Gets the value of the in property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIn() {
        return in;
    }

    /**
     * Sets the value of the in property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIn(String value) {
        this.in = value;
    }

    @XmlElement(namespace = "http://www.dns.hr/epp/hr-1.0", required = true)
    @XmlSchemaType(name = "token")
    protected ContactType type;

    @XmlElement(namespace = "http://www.dns.hr/epp/hr-1.0")
    protected String in;

}
