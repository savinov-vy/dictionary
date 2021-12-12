
package ru.savinov.dictionary.backend.soap.xml.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PayloadType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PayloadType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Users" type="{}UsersType"/>
 *         &lt;element name="Cities" type="{}CitiesType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="xmls" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayloadType", propOrder = {
    "users",
    "cities"
})
public class PayloadType {

    @XmlElement(name = "Users", required = true)
    protected UsersType users;
    @XmlElement(name = "Cities", required = true)
    protected CitiesType cities;
    @XmlAttribute(name = "xmls")
    protected String xmls;

    /**
     * Gets the value of the users property.
     * 
     * @return
     *     possible object is
     *     {@link UsersType }
     *     
     */
    public UsersType getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsersType }
     *     
     */
    public void setUsers(UsersType value) {
        this.users = value;
    }

    /**
     * Gets the value of the cities property.
     * 
     * @return
     *     possible object is
     *     {@link CitiesType }
     *     
     */
    public CitiesType getCities() {
        return cities;
    }

    /**
     * Sets the value of the cities property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitiesType }
     *     
     */
    public void setCities(CitiesType value) {
        this.cities = value;
    }

    /**
     * Gets the value of the xmls property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmls() {
        return xmls;
    }

    /**
     * Sets the value of the xmls property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmls(String value) {
        this.xmls = value;
    }

}
