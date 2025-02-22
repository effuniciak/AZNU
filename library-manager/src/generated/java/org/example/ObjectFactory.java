
package org.example;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import org.example.types.Book;
import org.example.types.Exception;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example package. 
 * <p>An ObjectFactory allows you to programmatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _GetBookResponse_QNAME = new QName("http://www.example.org", "getBookResponse");
    private static final QName _GetBooksRequest_QNAME = new QName("http://www.example.org", "getBooksRequest");
    private static final QName _LibraryManagerException_QNAME = new QName("http://www.example.org", "libraryManagerException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddNewBookRequest }
     * 
     * @return
     *     the new instance of {@link AddNewBookRequest }
     */
    public AddNewBookRequest createAddNewBookRequest() {
        return new AddNewBookRequest();
    }

    /**
     * Create an instance of {@link AddNewBookResponse }
     * 
     * @return
     *     the new instance of {@link AddNewBookResponse }
     */
    public AddNewBookResponse createAddNewBookResponse() {
        return new AddNewBookResponse();
    }

    /**
     * Create an instance of {@link GetBookRequest }
     * 
     * @return
     *     the new instance of {@link GetBookRequest }
     */
    public GetBookRequest createGetBookRequest() {
        return new GetBookRequest();
    }

    /**
     * Create an instance of {@link GetBooksResponse }
     * 
     * @return
     *     the new instance of {@link GetBooksResponse }
     */
    public GetBooksResponse createGetBooksResponse() {
        return new GetBooksResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Book }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.org", name = "getBookResponse")
    public JAXBElement<Book> createGetBookResponse(Book value) {
        return new JAXBElement<>(_GetBookResponse_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.org", name = "getBooksRequest")
    public JAXBElement<Object> createGetBooksRequest(Object value) {
        return new JAXBElement<>(_GetBooksRequest_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.org", name = "libraryManagerException")
    public JAXBElement<Exception> createLibraryManagerException(Exception value) {
        return new JAXBElement<>(_LibraryManagerException_QNAME, Exception.class, null, value);
    }

}
