package Modelos;

import Clases.Empleado;
import config.bdConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class inicio {
   
    bdConnection bdConnection;
    int r;
    public inicio() {
        bdConnection = new bdConnection();
    }
    public Empleado  Consultar(String user, String dni){
        try(Connection connection = DriverManager.getConnection(bdConnection.getUrl(),bdConnection.getUser(),bdConnection.getPass())){
            String query ="select * from empleado where User =? and Dni =?";
            PreparedStatement statementPersona = connection.prepareStatement(query);
            System.out.println("***Estoy recibiendo por dni a : "+dni+" y por user a : "+user);
            
            statementPersona.setString(1, user);
            statementPersona.setString(2, dni);
           
            ResultSet resultado = statementPersona.executeQuery();
            while (resultado.next()){
                int id = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String user2 = resultado.getString(3);
                String dni2 = resultado.getString(4);
                String tel = resultado.getString(5);
                
              
                Empleado empleado = new Empleado( id,dni2,nombre,tel, user2);
                
                return empleado;
            }
            
            System.out.println("No se encontro el empleado");
           return null;
        }catch(Exception e){
            System.out.println("La excepcion es:!"+ e);
            return null;
        }
    }
}
