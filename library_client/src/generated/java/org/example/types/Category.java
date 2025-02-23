
package org.example.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for category.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="category"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="fantasy"/&gt;
 *     &lt;enumeration value="sci_fi"/&gt;
 *     &lt;enumeration value="horror"/&gt;
 *     &lt;enumeration value="romance"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
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

    public String value() {
        return value;
    }

    public static Category fromValue(String v) {
        for (Category c: Category.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
