<%-- 
    Document   : clientes
    Created on : 13 oct 2023, 06:11:11
    Author     : Oscar Arb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList" %>
<%@page import="Clases.clsIngreso" %>
<%@page import="Modelos.mdlIngreso" %>
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
            mdlIngreso GastoDAO = new mdlIngreso();
        %>
        
        <!-- Button trigger modal -->
        <!-- Modal -->
        
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Datos Del Ingreso</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="Control?menu=Gasto"  method="POST" role="form">
                            <div class="row">
                                <div class="col-6">
                                    <label>Codigo</label>
                                    <input type="text" name="txtCodigo" class="form-control" id="txtCodigo" value="0" readonly="true">
                                </div>
                                
                                <div class="col-6">
                                    <label>Actividad</label>
                                    <input type="text" name="txtActividad" class="form-control" id="txtActividad">
                                </div>
                                <div class="col-6">
                                    <label>Fecha De Entrega</label>
                                    <input type="date" name="txtFechaEntrega" class="form-control" id="txtFechaEntrega">
                                </div>
                                <div class="col-6">
                                    <label>Observaciones</label>
                                    <input type="text" name="txtObservacion" class="form-control" id="txtObservacion">
                                </div>
                            </div>
                            
                           
                            <div class="row">
                                <div class="col-6">
                                    <label>Responsable</label>
                                    <input type="text" name="txtResponsable" class="form-control" id="txtResponsable">
                                </div>
                                <div class="col-6">
                                    <label>Area</label>
                                    <input type="text" name="txtArea" class="form-control" id="txtArea">
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-12">

                                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                                    

                                    <button type="button" class="btn btn-info" data-bs-dismiss="modal">Cancelar</button>
                                    
                                </div>
                                
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" ></script>
        <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script>

        <%
            System.out.println(request.getAttribute("em") +"kfabfhbdhfbk");
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

        <script src="${pageContext.servletContext.contextPath}/js/gasto.js"></script>
    </body>
</html>
