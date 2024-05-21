/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.clsIngreso;
import Modelos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Virgilio Ramos
 */
public class mdlIngreso extends Conexion {

    public int Crear(clsIngreso c) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO `ejecutandose`( `detalles`, `fecha`, `valor`) VALUES (?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getDetalle());
            pre.setString(2, c.getFecha());
            pre.setInt(3, c.getValor());

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return res;
    }

    public ArrayList<clsIngreso> mostrarClientes() {
        ArrayList<clsIngreso> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM ejecutandose";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                clsIngreso c = new clsIngreso();
                c.setId(rs.getString(1));
                c.setDetalle(rs.getString(2));

                c.setFecha(rs.getString(3));
                c.setValor(rs.getInt(4));

                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int Actualizar(clsIngreso gasto) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE `ejecutandose` SET `detalles`=?,`fecha`=?,`valor`=?  WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, gasto.getDetalle());
            pre.setString(2, gasto.getFecha());
            pre.setInt(3, gasto.getValor());
            pre.setString(4, gasto.getId());

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modificar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int eliminarCliente(int GastoDelete) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM `ejecutandose` WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, GastoDelete);

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int ConsultaObligaciones() {
        int cantidades = 0;
        try {
            this.conectar();
            String sql = "SELECT valor FROM `actividades"
                    + "`";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt(1);

                cantidades = cantidades + cantidad;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return cantidades;
    }
     public int ConsultaDisponible() {
        int cantidades = 0;
        try {
            this.conectar();
            String sql = "SELECT valor FROM `ejecutandose`";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt(1);

                cantidades = cantidades + cantidad;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return cantidades;
    }
     public int ConsultaObligaciones2() {
         Date todayDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String mesActual = sdf.format(todayDate);
        int cantidades = 0;
        try {
            this.conectar();
            String sql = "SELECT valor FROM `pagado` WHERE MONTH(fecha) ="+mesActual;
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt(1);

                cantidades = cantidades + cantidad;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return cantidades;
    }
    
     public int ConsultaMes(String mes) {
          int cantidades = 0;
         
        try {
            this.conectar();
            String sql = "SELECT valor FROM `pagado` WHERE MONTH(fecha) ="+mes;
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt(1);

                cantidades = cantidades + cantidad;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return cantidades;
    }
}
