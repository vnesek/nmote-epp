//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.02 at 01:16:04 PM CEST 
//


package hr.dns.epp.contact;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for info complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contact" type="{http://www.dns.hr/epp/hr-1.0}contactData" minOccurs="0"/&gt;
 *         &lt;element name="registrar" type="{http://www.dns.hr/epp/hr-1.0}registrarData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "info", namespace = "http://www.dns.hr/epp/hr-1.0", propOrder = {
        "contact",
        "registrar"
})
@XmlRootElement(name = "info", namespace = "http://www.dns.hr/epp/hr-1.0")
public class Info {

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

    /**
     * Gets the value of the registrar property.
     *
     * @return possible object is
     * {@link RegistrarData }
     */
    public RegistrarData getRegistrar() {
        return registrar;
    }

    /**
     * Sets the value of the registrar property.
     *
     * @param value allowed object is
     *              {@link RegistrarData }
     */
    public void setRegistrar(RegistrarData value) {
        this.registrar = value;
    }

    @XmlElement(namespace = "http://www.dns.hr/epp/hr-1.0")
    protected ContactData contact;

    @XmlElement(namespace = "http://www.dns.hr/epp/hr-1.0")
    protected RegistrarData registrar;

}
