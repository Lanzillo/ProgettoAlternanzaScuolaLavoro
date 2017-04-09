/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.progetto.webservice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author carlo
 */
@WebService(serviceName = "WSProgetto")
public class WSProgetto {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "iscrividocente")
    public String iscrividocente(@WebParam(name = "nome") String nome, @WebParam(name = "cognome") String cognome, @WebParam(name = "telefono") long telefono, @WebParam(name = "email") String email, @WebParam(name = "lotto") String lotto) {
        String stringa = "errore";
        try {
            //TODO write your implementation code here:

            File file = new File("fileDocente.txt");

            if (file.exists()) {
                stringa = "Il file esiste";
                stringa = "\n";
            } else if (file.createNewFile()) {
                stringa = "Il file è stato creato";
            } else {
                stringa = "Il file non è stato creato";
            }

            FileWriter fw = new FileWriter(file, true);
            fw.write(nome + ";" + cognome + ";" + telefono + ";" + email + ";" + lotto + ";" + "\n");
            fw.flush();
            fw.close();

        } catch (IOException ex) {
            stringa = "errore";
        }
        return stringa;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "nomeUtente") String nomeUtente, @WebParam(name = "password") String password) {
        if(nomeUtente.equals("Pippo"))
        {
            if(password.equals("Password.2017"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "iscrivistudente")
    public String iscrivistudente(@WebParam(name = "nome") String nome, @WebParam(name = "cognome") String cognome, @WebParam(name = "indirizzo") String indirizzo, @WebParam(name = "classe") String classe, @WebParam(name = "dataNascita") String dataNascita, @WebParam(name = "email") String email) {
        String stringa = "errore";
        try {
            //TODO write your implementation code here:

            File file = new File("fileStudente.txt");

            if (file.exists()) {
                stringa = "Il file esiste";
                stringa = "\n";
            } else if (file.createNewFile()) {
                stringa = "Il file è stato creato";
            } else {
                stringa = "Il file non è stato creato";
            }

            FileWriter fw = new FileWriter(file, true);
            fw.write(nome + ";" + cognome + ";" + indirizzo + ";" + classe + ";" + dataNascita + ";" + email  + ";" + "\n");
            fw.flush();
            fw.close();

        } catch (IOException ex) {
            stringa = "errore";
        }
        return stringa;
    }


}
