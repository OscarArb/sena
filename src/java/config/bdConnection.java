package config;


/**
 *
 * @author OscarArb
 */
public class bdConnection {

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    //conexion de forma local
    
    private final String user = "root";
     private final String pass = "";
    private final String url = "jdbc:mysql://localhost:3306/analisis_desarrollo";
    
    //conexion servidor publico
    
    //private final String user = "cutuspias12";
  // private final String pass = "Qwerty12345678.";
   // private final String url = "jdbc:mysql://db4free.net:3306/cutu_pia1";
     
     //azure
     //private final String user = "Oscar";
   //    private final String pass = "Vane222019";
    //private final String url = "jdbc:mysql://cutu.mysql.database.azure.com:3306/cutu";
    
    
}
