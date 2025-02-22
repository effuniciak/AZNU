
package org.example.types;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for category</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="category">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="fantasy"/>
 *     <enumeration value="sci_fi"/>
 *     <enumeration value="horror"/>
 *     <enumeration value="romance"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "category")
@XmlEnum
public enum Category {

    @XmlEnumValue("fantasy")
    FANTASY("fantasy"),
    @XmlEnumValue("sci_fi")
    SCI_FI("sci_fi"),
    @XmlEnumValue("horror")
    HORROR("horror"),
    @XmlEnumValue("romance")
    ROMANCE("romance");
    private final String value;

    Category(String v) {
        value = v;
    }

    /**
     * Gets the value associated to the enum constant.
     * 
     * @return
     *     The value linked to the enum.
     */
    public String value() {
        return value;
    }

    /**
     * Gets the enum associated to the value passed as parameter.
     * 
     * @param v
     *     The value to get the enum from.
     * @return
     *     The enum which corresponds to the value, if it exists.
     * @throws IllegalArgumentException
     *     If no value matches in the enum declaration.
     */
    public static Category fromValue(String v) {
        for (Category c: Category.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
