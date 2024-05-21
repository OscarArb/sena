/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Clases.Empleado;

import Clases.clsGasto;
import Clases.clsIngreso;
import Modelos.mdlGasto;
import Modelos.mdlIngreso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

int ide;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
           
         String menu=request.getParameter("menu");
         String accion=request.getParameter("accion");
         if(menu.equals("Index")){
             request.getRequestDispatcher("Principal.jsp").forward(request, response);
             
         }
         if(menu.equals("Principal")){
             System.out.println("Inreso aaaaXDDVFR pRINCIPAL");
             request.getRequestDispatcher("inicio.jsp").forward(request, response);
         }
         if(menu.equals("Ingreso")){
             request.getRequestDispatcher("ingreso.jsp").forward(request, response);
             
             switch (accion) {
                 case "Listar":
                     
                     String nom="Oscar Arrieta Basilio";
                     request.setAttribute("em", nom);
                     
                     request.getRequestDispatcher("Empleado.jsp").forward(request, response);

                     break;
                 case "Agregar":
                     String idA =request.getParameter("txtCodigo");
                    String detalleA = request.getParameter("txtNombre");
                    int valorA = Integer.parseInt(request.getParameter("txtValor"));
                    String fechapagoA = request.getParameter("txtFecha");
                   
                    clsIngreso crearI = new clsIngreso(idA,detalleA,fechapagoA,valorA);
                    int agregado;
                    mdlIngreso ingresoCrear= new mdlIngreso();
                    agregado = ingresoCrear.Crear(crearI);
                    if(agregado==1){
                         System.out.println("Agregado correctamente");
                    }
                      break;
                 case "Delete":
                     ide=Integer.parseInt(request.getParameter("id"));
                    mdlIngreso mdlIngreso =new mdlIngreso();
                    int repuesta=mdlIngreso.eliminarCliente(ide);
                    String r2=String.valueOf(repuesta);
                    request.setAttribute("em", r2);
                     request.getRequestDispatcher("ingreso.jsp").forward(request, response);
                     break;
                 
                 case "Actualizar":
                     String id =request.getParameter("txtCodigo");
                    String detalle = request.getParameter("txtNombre");
                    int valor = Integer.parseInt(request.getParameter("txtValor"));
                    String fechapago = request.getParameter("txtFecha");
                    clsIngreso ActualizarI = new clsIngreso(id,detalle,fechapago,valor);
                    int estado;
                    mdlIngreso IngresoAct= new mdlIngreso();
                    estado = IngresoAct.Actualizar(ActualizarI);
                    break;
                 default:
                     throw new AssertionError();
             }
         }
         if(menu.equals("Gasto")){
             
             request.getRequestDispatcher("gasto.jsp").forward(request, response);
             switch (accion) {
                 case "Delete":
                     ide=Integer.parseInt(request.getParameter("id"));
                    mdlGasto mdlGasto= new mdlGasto();
                    int repuesta=mdlGasto.eliminarCliente(ide);
                    String r2=String.valueOf(repuesta);
                    request.setAttribute("em", r2);
                     request.getRequestDispatcher("gasto.jsp").forward(request, response);
                     
                 case "listar":
                    request.getRequestDispatcher("vistas/gastos.jsp").forward(request, response);
                     System.out.println("Listar*********");
                    break;
                case "Actualizar":
                    String id =request.getParameter("txtCodigo");
                    String detalle = request.getParameter("txtNombre");
                    String valor = request.getParameter("txtValor");
                    String fechapago = request.getParameter("txtFecha");
                    String rep1 = request.getParameter("txtRepetido");
                    String repetido ="";
                    String cuotas1 =request.getParameter("txtCuotas");
                    String cuotas="";
                    if(rep1.equals("Si")){
                        repetido = "true";
                        cuotas=cuotas1;
                    }else if(rep1.equals("No")){
                        cuotas="0";
                        repetido = "false";
                    }
                    System.out.println("id= "+id+" detalle= "+detalle+" valor= "+valor+" fecha= "+fechapago+" repetido= "+repetido+" cuotas= "+cuotas1);
                    
                    clsGasto gActualizar = new clsGasto(id,detalle,fechapago,valor,repetido,cuotas);
                    int estado;
                    mdlGasto gastoActualizar= new mdlGasto();
                    estado = gastoActualizar.Actualizar(gActualizar);
                     
                     
                    // client=new Cliente(codigoAct,dniAct,nombreAct,direccionAct,estadoAct);
                     //int res=cDao.actualizar(client);
                    // System.out.println("Respuesta es:::::::"+res);
                     break;
                case "Agregar":
                    String idA =request.getParameter("txtCodigo");
                    String detalleA = request.getParameter("txtActividad");
                    String valorA = request.getParameter("txtFechaEntrega");
                    String fechapagoA = request.getParameter("txtObservacion");
                    String repetidoA =request.getParameter("txtResponsable");
                    String cuotasA =request.getParameter("txtArea");
                    
                   
                    clsGasto gCrear = new clsGasto(idA,detalleA,fechapagoA,valorA,repetidoA,cuotasA);
                    int agregado;
                    mdlGasto gastoCrear= new mdlGasto();
                    agregado = gastoCrear.Crear(gCrear);
                    if(agregado==1){
                         System.out.println("Agregado correctamente");
                    }
                     break;
             }
         }
         if(menu.equals("Producto")){
             request.getRequestDispatcher("Producto.jsp").forward(request, response);
             
         }
         if(menu.equals("Graficas")){
             request.getRequestDispatcher("Graficas.jsp").forward(request, response);
         }
         if(menu.equals("Informe")){
             request.getRequestDispatcher("informe.jsp").forward(request, response);
         }
         } catch (Exception e) {
        }
          
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
