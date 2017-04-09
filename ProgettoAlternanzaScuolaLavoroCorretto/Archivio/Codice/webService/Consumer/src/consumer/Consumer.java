/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumer;

/**
 *
 * @author carlo
 */
public class Consumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String docente = iscrividocente("palla", "nuoto", 213948723, "sonoUn@ma.il", "rosso");
       String studente = iscrivistudente("andrea", "andle","informatico","5^C","01/10/1998","prova@hotmail.it");
       boolean resultLogin = login("Pippo","Passowrd.2017");
    }

    private static String iscrividocente(java.lang.String nome, java.lang.String cognome, long telefono, java.lang.String email, java.lang.String lotto) {
        org.progetto.webservice.WSProgetto_Service service = new org.progetto.webservice.WSProgetto_Service();
        org.progetto.webservice.WSProgetto port = service.getWSProgettoPort();
        return port.iscrividocente(nome, cognome, telefono, email, lotto);
    }

    private static String iscrivistudente(java.lang.String nome, java.lang.String cognome, java.lang.String indirizzo, java.lang.String classe, java.lang.String dataNascita, java.lang.String email) {
        org.progetto.webservice.WSProgetto_Service service = new org.progetto.webservice.WSProgetto_Service();
        org.progetto.webservice.WSProgetto port = service.getWSProgettoPort();
        return port.iscrivistudente(nome, cognome, indirizzo, classe, dataNascita, email);
    }

    private static boolean login(java.lang.String nomeUtente, java.lang.String password) {
        org.progetto.webservice.WSProgetto_Service service = new org.progetto.webservice.WSProgetto_Service();
        org.progetto.webservice.WSProgetto port = service.getWSProgettoPort();
        return port.login(nomeUtente, password);
    }
    
}
