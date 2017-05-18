import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author Canna
 */
@WebService(serviceName = "GestioneDelleAziende", targetNamespace = "http://my.org/ns/")
public class GestioneDelleAziende {

    
    private String Visualizza() throws SQLException, ClassNotFoundException
    {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/AlternanzaScuolaLavoro";

        //  Database credentials
        String USER = "root";
        String PASS = "";

        //  Object for connection
        Connection conn = null;
        
        //  Object for SQL query
        Statement stmt = null;
        String sql = "SELECT * FROM azienda ORDER BY data";
       
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
         
           
                ResultSet rs = stmt.executeQuery(sql);
                String temp="";
                while(rs.next())
                {
                    temp+=rs.getString("denominazione")+";"+rs.getString("indirizzo")+";"+rs.getLong("telefono")+";"+rs.getString("email")+";"+rs.getString("persona")+";"+rs.getString("tutor")+";"+rs.getString("luogo")+";"+rs.getString("documento")+";"+rs.getString("persona")+";"+rs.getString("competenze")+";"+rs.getString("attivita")+";"+rs.getString("note")+"\r\n";
                }
            return temp;   

    }
     private boolean Modifica(int riga,String denominazione, String email, String indirizzo, long telefono, String persona,String tutor,String luogo,String documento,String competenze,String attivita,String note) throws ClassNotFoundException, SQLException
        {
             String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/AlternanzaScuolaLavoro";

        //  Database credentials
        String USER = "root";
        String PASS = "";

        //  Object for connection
        Connection conn = null;
        
        //  Object for SQL query
        Statement stmt = null;
        String sql = "DELETE from segnalazione WHERE "+riga;
       
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
    
            stmt.executeUpdate(sql);
            
           sql="INSERT INTO segnalazione (denominazione,email,indirizzo,telefono,persona,data,tutor,luogo,documento,competenze,attivita,note) VALUES ("+denominazione+","+email+","+indirizzo+","+telefono+","+persona+","+Date.valueOf(LocalDate.now())+","+tutor+","+luogo+","+documento+","+competenze+","+attivita+","+note+")";
            stmt.executeUpdate(sql);
            
           return true;
        }
    private Boolean Inserisci(String denominazione,String indirizzo,Long telefono,String email,String persona,String tutor,String luogo,String documento,String competenze,String attivita,String note) throws SQLException, ClassNotFoundException
    {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/AlternanzaScuolaLavoro";

        //  Database credentials
        String USER = "root";
        String PASS = "";

        //  Object for connection
        Connection conn = null;
        
        //  Object for SQL query
        Statement stmt = null;
        String sql = "SELECT * FROM segnalazione WHERE denominazione='"+denominazione+"'";
       
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
                {
                    rs.close();
                    return false;
                }
            
            sql="INSERT INTO segnalazione (denominazione,emai,indirizzo,telefono,persona,data,tutor,luogo,documento,competenze,attivita,note) VALUES ("+denominazione+","+email+","+indirizzo+","+telefono+","+persona+","+Date.valueOf(LocalDate.now())+","+tutor+","+luogo+","+documento+","+competenze+","+attivita+","+note+")";
            stmt.executeUpdate(sql);
            
            
                return true;
    }

    private Boolean Elimina(int riga) throws SQLException, ClassNotFoundException
    {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/AlternanzaScuolaLavoro";

        //  Database credentials
        String USER = "root";
        String PASS = "";

        //  Object for connection
        Connection conn = null;
        
        //  Object for SQL query
        Statement stmt = null;
        String sql = "DELETE from segnalazione WHERE "+riga;
       
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
                    
            stmt.executeUpdate(sql);
            
            return true;
    }
    /**
     * Web service operation
     */
    public String VisualizzaAziende() throws SQLException, ClassNotFoundException {
        //TODO write your implementation code here:
        return Visualizza();
    }
    public Boolean InserisciSegnalazione(String denominazione,String indirizzo,Long telefono,String email,String persona,String tutor,String luogo,String documento,String competenze,String attivita,String note) throws SQLException, ClassNotFoundException {
        //TODO write your implementation code here:
        return Inserisci(denominazione, indirizzo, telefono, email, persona, tutor, luogo, documento, competenze, attivita, note);
    }
    
    public Boolean ModificaSegnalazioni(int riga, String denominazione, String email, String indirizzo, long telefono, String persona,String tutor,String luogo,String documento,String competenze,String attivita,String note) throws ClassNotFoundException, SQLException {
        //TODO write your implementation code here:
        return Modifica( riga, denominazione,  email,  indirizzo,  telefono,  persona, tutor, luogo, documento, competenze, attivita, note);
    }

    /**
     * Web service operation
     */
    public Boolean EliminaAzienda(int riga) throws SQLException, SQLException, ClassNotFoundException {
        //TODO write your implementation code here:
        return Elimina(riga);
    }
    
}
