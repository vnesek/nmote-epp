//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.02 at 01:16:04 PM CEST 
//


package hr.dns.epp.contact;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;


/**
 * <p>Java class for registrarAccountAmount complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="registrarAccountAmount"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;decimal"&gt;
 *       &lt;attribute name="currency" use="required" type="{http://www.dns.hr/epp/hr-1.0}currencyName" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registrarAccountAmount", namespace = "http://www.dns.hr/epp/hr-1.0", propOrder = {
        "value"
})
public class RegistrarAccountAmount {

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return possible object is
     * {@link CurrencyName }
     */
    public CurrencyName getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is
     *              {@link CurrencyName }
     */
    public void setCurrency(CurrencyName value) {
        this.currency = value;
    }

    @XmlValue
    protected BigDecimal value;

    @XmlAttribute(name = "currency", required = true)
    protected CurrencyName currency;

}
