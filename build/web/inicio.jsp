<%-- 
    Document   : clientes
    Created on : 13 oct 2023, 06:11:11
    Author     : Oscar Arb
--%>

<%@page import="Modelos.mdlIngreso"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList" %>
<%@page import="Clases.clsGasto" %>
<%@page import="Modelos.mdlGasto" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" />
    </head>
    <body>
        <%!
            //CategoriaDAO categoriaDAO = new CategoriaDAO();
            mdlGasto GastoDAO = new mdlGasto();
        %>
        <div class="container">
            <%--  <%@include file="../template/menu.jsp" %>--%>
            <hr>
            <div class="row align-items-start">
                <div class="col-9"><h1>Centro De Actividades</h1>
                    <%Date todayDate = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                        String fecha = sdf.format(todayDate);%>
                    <b>
                        <label>Fecha Hoy: <%=fecha%></label> </b> <br><!-- comment -->
                    <label>" El aprendizaje constante hace al maestro</label><br>
                    <label>      hoy es dia de luchar por tus sueños "</label>
                </div>

                <div class="col-3 align-self-center">
                    <div class="d-grid gap-2">
                        <%DecimalFormat formatea = new DecimalFormat("###,###.##");
                            mdlIngreso mdlIngreso = new mdlIngreso();
                            int cantidad = mdlIngreso.ConsultaObligaciones();
                            String v = String.valueOf(formatea.format(cantidad));%>
                        <%

                            int disponible = mdlIngreso.ConsultaDisponible();
                            int obligaciones = mdlIngreso.ConsultaObligaciones2();
                            int valor = disponible - obligaciones;
                            String valorAmostrar = "";
                            if (valor <= 0) {
                                valorAmostrar = ("No Disponible");
                            } else {
                                valorAmostrar = String.valueOf(formatea.format(valor));
                                System.out.println("Valor a mostrar Disponible:" + disponible);
                            }
                        %>
                        <label>Actividades sin desarrollar: </label>
                        <input type="text" name="txtTotalIngreso" class="form-control" id="txtTotalIngreso" value="<%=valorAmostrar%>" readonly="true">

                    </div>                    
                </div>
            </div>


            <hr>
            <div class="table-responsive">
                <table class="table table-striped" id="mydataTable">
                    <thead>
                    <th>Código</th>
                    <th>Actividad</th>
                    <th>Fecha de entrega</th>
                    <th>Observaciones</th>
                    <th>Responsable</th>
                    <th>Area</th>
                    <th>Acciones</th>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<clsGasto> listaCliente = GastoDAO.mostrarClientes();

                            for (clsGasto elem : listaCliente) {

                        %>
                        <tr>
                            

                            <td class="codigo"><%= elem.getId()%></td>
                            <td class="nombre"><%= elem.getDetalle()%></td>
                            <td class="valor"><%= elem.getValor()%></td>
                            <td class="fecha"><%= elem.getFecha()%></td>
                            <td class="repetido"><%= elem.getRepetido()%></td>
                            <td class="cuotas"><%= elem.getCantidad()%></td>
                            <td>
                                <button type="button" class="btn btn-success btnEditar" data-bs-toggle="modal" data-bs-target="#exampleModal">Editar</button>
                                <a class="btn btn-info" href="Control?menu=Gasto&accion=Delete&id=<%= elem.getId()%>">Iniciar</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- Button trigger modal -->
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Pagos y Abonos</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <center>
                            <label>--Ingrese la cantidad a pagar--</label>
                        </center>
                        <br>
                        <form action="Control?menu=Gasto"  method="POST" role="form">
                            <div class="row">
                                <div class="col-6">
                                    <label>Codigo</label>
                                    <input type="text" name="txtCodigo" class="form-control" id="txtCodigo" value="0" readonly="true">
                                </div>

                                <div class="col-6">
                                    <label>Detalles</label>
                                    <input type="text" name="txtNombre" class="form-control" id="txtNombre" readonly="true">
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-6">
                                    <label>Valor</label>
                                    <input type="number" name="txtValor" class="form-control" id="txtValor">
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-12">

                                    <input type="submit" name="accion" value="Quiero Pagar" class="btn btn-success">


                                    <button type="button" class="btn btn-info" data-bs-dismiss="modal">Cancelar</button>

                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" ></script>
        <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script>

        <%
            System.out.println(request.getAttribute("em") + "kfabfhbdhfbk");
            if (request.getAttribute("em") != null) {
                System.out.println("eliminado correctamente");
        %>

        <script>
            $(document).ready(function () {
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: '<%= request.getAttribute("message")%>',
                    showConfirmButton: false,
                    timer: 3000
                });
            });
        </script>
        <%
            }
        %>

        <script src="${pageContext.servletContext.contextPath}/js/init.js"></script>
    </body>
</html>
