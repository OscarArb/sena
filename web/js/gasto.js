/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function llenarFormulario(fila){
    var codigo = $(fila).find(".codigo").text();
    var actividad = $(fila).find(".nombre").text();
    var fechaEntrega = $(fila).find(".valor").text();
    var Observacion = $(fila).find(".fecha").text();
    var area = $(fila).find(".repetido").text();
    
    var responsable = $(fila).find(".cuotas").text();
    
    $("#txtCodigo").val(codigo);
    $("#txtActividad").val(actividad);
    $("#txtFechaentrega").val(fechaEntrega);
    $("#txtObservacion").val(Observacion);
    $("#txtResponsable").val(responsable);
    $("#txtArea").val(area); 
    $("#txtCategoria option[selected]").removeAttr('selected');
    
}

$(document).ready(function(){
    $('#mydataTable').DataTable();
    
    $("#exampleModal").on("hidden.bs.modal", function(){
        $('form')[0].reset();
        $("#txtCategoria option[selected]").removeAttr('selected');
    });
    
    $(document).on('click', '.btnEditar', function(){
        llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnEliminar', function(){
        llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnAdd', function(){
        $('.btnOcultar').attr('disabled', 'disabled');
        $('.btnOcultar1').removeAttr('disabled');
    });
});
