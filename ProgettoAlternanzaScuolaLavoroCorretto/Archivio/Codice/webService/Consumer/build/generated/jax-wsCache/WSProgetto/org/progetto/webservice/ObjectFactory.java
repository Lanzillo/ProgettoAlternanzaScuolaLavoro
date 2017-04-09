
package org.progetto.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.progetto.webservice package. 
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

    private final static QName _Login_QNAME = new QName("http://webservice.progetto.org/", "login");
    private final static QName _Iscrivistudente_QNAME = new QName("http://webservice.progetto.org/", "iscrivistudente");
    private final static QName _IscrivistudenteResponse_QNAME = new QName("http://webservice.progetto.org/", "iscrivistudenteResponse");
    private final static QName _IscrividocenteResponse_QNAME = new QName("http://webservice.progetto.org/", "iscrividocenteResponse");
    private final static QName _Iscrividocente_QNAME = new QName("http://webservice.progetto.org/", "iscrividocente");
    private final static QName _LoginResponse_QNAME = new QName("http://webservice.progetto.org/", "loginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.progetto.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Iscrividocente }
     * 
     */
    public Iscrividocente createIscrividocente() {
        return new Iscrividocente();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link IscrividocenteResponse }
     * 
     */
    public IscrividocenteResponse createIscrividocenteResponse() {
        return new IscrividocenteResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link Iscrivistudente }
     * 
     */
    public Iscrivistudente createIscrivistudente() {
        return new Iscrivistudente();
    }

    /**
     * Create an instance of {@link IscrivistudenteResponse }
     * 
     */
    public IscrivistudenteResponse createIscrivistudenteResponse() {
        return new IscrivistudenteResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.progetto.org/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Iscrivistudente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.progetto.org/", name = "iscrivistudente")
    public JAXBElement<Iscrivistudente> createIscrivistudente(Iscrivistudente value) {
        return new JAXBElement<Iscrivistudente>(_Iscrivistudente_QNAME, Iscrivistudente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IscrivistudenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.progetto.org/", name = "iscrivistudenteResponse")
    public JAXBElement<IscrivistudenteResponse> createIscrivistudenteResponse(IscrivistudenteResponse value) {
        return new JAXBElement<IscrivistudenteResponse>(_IscrivistudenteResponse_QNAME, IscrivistudenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IscrividocenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.progetto.org/", name = "iscrividocenteResponse")
    public JAXBElement<IscrividocenteResponse> createIscrividocenteResponse(IscrividocenteResponse value) {
        return new JAXBElement<IscrividocenteResponse>(_IscrividocenteResponse_QNAME, IscrividocenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Iscrividocente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.progetto.org/", name = "iscrividocente")
    public JAXBElement<Iscrividocente> createIscrividocente(Iscrividocente value) {
        return new JAXBElement<Iscrividocente>(_Iscrividocente_QNAME, Iscrividocente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.progetto.org/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

}
