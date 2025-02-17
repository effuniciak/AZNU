
package org.example;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import org.example.types.Exception;
import org.example.types.Library;


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

    private static final QName _GetLibraryListRequest_QNAME = new QName("http://www.example.org", "getLibraryListRequest");
    private static final QName _GetLibraryDetailsResponse_QNAME = new QName("http://www.example.org", "getLibraryDetailsResponse");
    private static final QName _LibrariesDbException_QNAME = new QName("http://www.example.org", "librariesDbException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLibraryListResponse }
     * 
     * @return
     *     the new instance of {@link GetLibraryListResponse }
     */
    public GetLibraryListResponse createGetLibraryListResponse() {
        return new GetLibraryListResponse();
    }

    /**
     * Create an instance of {@link GetLibraryDetailsRequest }
     * 
     * @return
     *     the new instance of {@link GetLibraryDetailsRequest }
     */
    public GetLibraryDetailsRequest createGetLibraryDetailsRequest() {
        return new GetLibraryDetailsRequest();
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
        return new JAXBElement<>(_GetLibraryListRequest_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Library }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Library }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.org", name = "getLibraryDetailsResponse")
    public JAXBElement<Library> createGetLibraryDetailsResponse(Library value) {
        return new JAXBElement<>(_GetLibraryDetailsResponse_QNAME, Library.class, null, value);
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
        return new JAXBElement<>(_LibrariesDbException_QNAME, Exception.class, null, value);
    }

}
