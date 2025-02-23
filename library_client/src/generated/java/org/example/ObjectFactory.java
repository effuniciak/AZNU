
package org.example;

import javax.xml.namespace.QName;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import org.example.types.Book;
import org.example.types.Exception;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example package. 
 * <p>An ObjectFactory allows you to programatically 
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
    private final static QName _AddBookResponse_QNAME = new QName("http://www.example.org", "addBookResponse");
    private final static QName _GetLibraryDetailsResponse_QNAME = new QName("http://www.example.org", "getLibraryDetailsResponse");
    private final static QName _GetLibraryListRequest_QNAME = new QName("http://www.example.org", "getLibraryListRequest");
    private final static QName _LibrariesDbException_QNAME = new QName("http://www.example.org", "librariesDbException");
    private final static QName _RemoveBookResponse_QNAME = new QName("http://www.example.org", "removeBookResponse");

    private final static QName _GetBookResponse_QNAME = new QName("http://www.example.org", "getBookResponse");
    private final static QName _GetBooksRequest_QNAME = new QName("http://www.example.org", "getBooksRequest");
    private final static QName _LibraryManagerException_QNAME = new QName("http://www.example.org", "libraryManagerException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddNewBookRequest }
     * 
     */
    public AddNewBookRequest createAddNewBookRequest() {
        return new AddNewBookRequest();
    }

    /**
     * Create an instance of {@link AddNewBookResponse }
     * 
     */
    public AddNewBookResponse createAddNewBookResponse() {
        return new AddNewBookResponse();
    }

    /**
     * Create an instance of {@link GetBookRequest }
     * 
     */
    public GetBookRequest createGetBookRequest() {
        return new GetBookRequest();
    }

    /**
     * Create an instance of {@link GetBooksResponse }
     * 
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
        return new JAXBElement<Book>(_GetBookResponse_QNAME, Book.class, null, value);
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
        return new JAXBElement<Object>(_GetBooksRequest_QNAME, Object.class, null, value);
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
        return new JAXBElement<Exception>(_LibraryManagerException_QNAME, Exception.class, null, value);
    }
    
    
    
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.org", name = "getLibraryDetailsResponse")
    public JAXBElement<GetLibraryDetailsResponse> createGetLibraryDetailsResponse(GetLibraryDetailsResponse value) {
        return new JAXBElement<GetLibraryDetailsResponse>(_GetLibraryDetailsResponse_QNAME, GetLibraryDetailsResponse.class, null, value);
    }
    
    
    
    /**
     * Create an instance of {@link GetLibraryDetailsResponse }
     * 
     */
    public GetLibraryDetailsResponse createGetLibraryDetailsResponse() {
        return new GetLibraryDetailsResponse();
    }
    
    
    

    /**
     * Create an instance of {@link GetLibraryDetailsRequest }
     * 
     */
    public GetLibraryDetailsRequest createGetLibraryDetailsRequest() {
        return new GetLibraryDetailsRequest();
    }

    /**
     * Create an instance of {@link GetLibraryListResponse }
     * 
     */
    public GetLibraryListResponse createGetLibraryListResponse() {
        return new GetLibraryListResponse();
    }

    /**
     * Create an instance of {@link RemoveBookRequest }
     * 
     */
    public RemoveBookRequest createRemoveBookRequest() {
        return new RemoveBookRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.org", name = "addBookResponse")
    public JAXBElement<Object> createAddBookResponse(Object value) {
        return new JAXBElement<Object>(_AddBookResponse_QNAME, Object.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.org", name = "getLibraryListRequest")
    public JAXBElement<Object> createGetLibraryListRequest(Object value) {
        return new JAXBElement<Object>(_GetLibraryListRequest_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.org", name = "librariesDbException")
    public JAXBElement<Exception> createLibrariesDbException(Exception value) {
        return new JAXBElement<Exception>(_LibrariesDbException_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.org", name = "removeBookResponse")
    public JAXBElement<Object> createRemoveBookResponse(Object value) {
        return new JAXBElement<Object>(_RemoveBookResponse_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link GetLibraryListRequest }
     * 
     */
    public GetLibraryListRequest createGetLibraryListRequest() {
        return new GetLibraryListRequest();
    }

}
