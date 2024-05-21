/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.clsGasto;
import Modelos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Virgilio Ramos
 */
public class mdlGasto extends Conexion {
    public int Crear(clsGasto c){
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO `actividades`(`detalle`, `valor`, `fecha`, `repetido`, `cantidad`) VALUES (?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getDetalle());
            pre.setString(2, c.getValor());
            pre.setString(3, c.getFecha());
            pre.setString(4, c.getRepetido());
            pre.setString(5, c.getCantidad());
            
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        
        return res;
    }
    
    public ArrayList<clsGasto> mostrarClientes(){
        ArrayList<clsGasto> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM actividades";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){
                clsGasto c = new clsGasto();
                c.setId(rs.getString(1));
                c.setDetalle(rs.getString(2));
                c.setValor(rs.getString(3));
                c.setFecha(rs.getString(4));
                c.setRepetido(rs.getString(5));
                c.setCantidad(rs.getString(6));
                System.out.println(rs.getString(5));
                
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int Actualizar(clsGasto gasto){
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE `actividades` SET `detalle`=? ,`valor`=?,`fecha`=?,`repetido`=?,`cantidad`=? WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
             pre.setString(1, gasto.getDetalle());
            pre.setString(2, gasto.getValor());
            pre.setString(3, gasto.getFecha());
            pre.setString(4, gasto.getRepetido());
            pre.setString(5, gasto.getCantidad());
            pre.setString(6,gasto.getId());
            
            res = pre.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error al modificar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }    
    
    public int eliminarCliente(int GastoDelete){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM `actividades` WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, GastoDelete);
            
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
