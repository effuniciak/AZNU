
package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="libraryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="bookId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "libraryId",
    "bookId"
})
@XmlRootElement(name = "removeBookRequest")
public class RemoveBookRequest {

    protected int libraryId;
    protected int bookId;

    /**
     * Gets the value of the libraryId property.
     * 
     */
    public int getLibraryId() {
        return libraryId;
    }

    /**
     * Sets the value of the libraryId property.
     * 
     */
    public void setLibraryId(int value) {
        this.libraryId = value;
    }

    /**
     * Gets the value of the bookId property.
     * 
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Sets the value of the bookId property.
     * 
     */
    public void setBookId(int value) {
        this.bookId = value;
    }

}
