//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.02 at 01:16:04 PM CEST 
//


package hr.dns.epp.contact;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for update complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="update"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contact" type="{http://www.dns.hr/epp/hr-1.0}contactData"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "update", namespace = "http://www.dns.hr/epp/hr-1.0", propOrder = {
        "contact"
})
@XmlRootElement(name = "update", namespace = "http://www.dns.hr/epp/hr-1.0")
public class Update {

    /**
     * Gets the value of the contact property.
     *
     * @return possible object is
     * {@link ContactData }
     */
    public ContactData getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     *
     * @param value allowed object is
     *              {@link ContactData }
     */
    public void setContact(ContactData value) {
        this.contact = value;
    }

    @XmlElement(namespace = "http://www.dns.hr/epp/hr-1.0", required = true)
    protected ContactData contact;

}
