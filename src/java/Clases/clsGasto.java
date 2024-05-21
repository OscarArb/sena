/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Virgilio Ramos
 */
public class clsGasto {

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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getRepetido() {
        return repetido;
    }

    public void setRepetido(String repetido) {
        this.repetido = repetido;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    private String id;
    private String detalle;
    private String fecha;
    private String valor;
    private String repetido;
    private String cantidad;

    public clsGasto() {
    }

    public clsGasto(String id,String detalle, String fecha, String valor, String repetido,String cantidad) {
        this.id = id;
        this.detalle = detalle;
        this.fecha = fecha;
        this.valor = valor;
        this.repetido = repetido;
        this.cantidad=cantidad;
    }
}
    