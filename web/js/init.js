/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function llenarFormulario(fila){
    var codigo = $(fila).find(".codigo").text();
    var nombre = $(fila).find(".nombre").text();
    var valor = $(fila).find(".valor").text();
    var fecha = $(fila).find(".fecha").text();
    
    $("#txtCodigo").val(codigo);
    $("#txtNombre").val(nombre);
    $("#txtValor").val(valor);
    $("#txtFecha").val(fecha);
    
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
