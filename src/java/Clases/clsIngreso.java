/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Virgilio Ramos
 */
public class clsIngreso {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    

   
    private String id;
    private String detalle;
    private String fecha;
    private int valor;
    
    public clsIngreso() {
    }

    public clsIngreso(String id,String detalle, String fecha, int valor) {
        this.id = id;
        this.detalle = detalle;
        this.fecha = fecha;
        this.valor = valor;
       
    }
}
    