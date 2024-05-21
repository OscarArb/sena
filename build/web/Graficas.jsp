<%-- 
    Document   : clientes
    Created on : 13 oct 2023, 06:11:11
    Author     : Oscar Arb
--%>


<%@page import="java.awt.BorderLayout"%>
<%@page import="java.awt.Dimension"%>
<%@page import="org.jfree.chart.ChartPanel"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="org.jfree.chart.ChartFactory"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@page import="Modelos.mdlIngreso"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Generador de Gráfico</title>
        <link rel="stylesheet" href="css/grafica.css">
        <link href="css/grafica.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <h1>Generador de Gráficos</h1>

        <div class="left">
            <%
                mdlIngreso mdlIngreso = new mdlIngreso();
                int enero = mdlIngreso.ConsultaMes("01");
                int febrero = mdlIngreso.ConsultaMes("02");
                int marzo = mdlIngreso.ConsultaMes("03");
                int abril = mdlIngreso.ConsultaMes("04");
                int mayo = mdlIngreso.ConsultaMes("05");
                int junio = mdlIngreso.ConsultaMes("06");
                int julio = mdlIngreso.ConsultaMes("07");
                int agosto = mdlIngreso.ConsultaMes("08");
                int septiembre = mdlIngreso.ConsultaMes("09");
                int octubre = mdlIngreso.ConsultaMes("10");
                int noviembre = mdlIngreso.ConsultaMes("11");
                int diciembre = mdlIngreso.ConsultaMes("12");

                

               
                
            %>
            <select name="" id="tipo">
                <option value="circular">
                    Gráfico Circular
                </option>
                <option value="columna">
                    Gráfico de Columnas
                </option>
            </select>
            <input type="text" Value="Grafico Año Actual" id="titulo" readonly="false">
            <div class="datos" id="datos">
                <div class="dato">
                    <input type="text" value="Enero" class="serie" readonly="false">
                    <input type="text" value="<%=enero%>" class="valor" readonly="false">
                </div>
                <div class="dato">
                    <input type="text" value="Febrero" class="serie" readonly="false">
                    <input type="text" value="<%=febrero%>" class="valor" readonly="false">
                </div>
                <div class="dato">
                    <input type="text" value="Marzo" class="serie" readonly="false">
                    <input type="text" value="<%=marzo%>" class="valor" readonly="false">
                </div>
                <div class="dato">
                    <input type="text" value="Abril" class="serie" readonly="false">
                    <input type="text" value="<%=abril%>" class="valor" readonly="false">
                </div>
               
                <div class="dato">
                    <input type="text" value="Mayo" class="serie" readonly="false">
                    <input type="text" value="<%=mayo%>" class="valor" readonly="false">
                </div>
                <div class="dato">
                    <input type="text" value="Junio" class="serie" readonly="false">
                    <input type="text" value="<%=junio%>" class="valor" readonly="false">
                </div>
                <div class="dato">
                    <input type="text"  class="serie" value="Julio" readonly="false">
                    <input type="text"  class="valor" value="<%=julio%>" readonly="false">
                </div>
                <div class="dato">
                    <input type="text"  class="serie" value="Agosto" readonly="false">
                    <input type="text" value="<%=agosto%>" class="valor" readonly="false">
                </div>
                <div class="dato">
                    <input type="text" value="Septiembre" class="serie" readonly="false">
                    <input type="text" value="<%=septiembre%>" class="valor" readonly="false">
                </div>
                <div class="dato">
                    <input type="text" value="Octubre" class="serie" readonly="false">
                    <input type="text" value="<%=octubre%>" class="valor" readonly="false">
                </div>
                <div class="dato">
                    <input type="text" value="Noviembre" class="serie" readonly="false">
                    <input type="text" value="<%=noviembre%>" class="valor" readonly="false">
                </div>
                <div class="dato">
                    <input type="text" value="Diciembre" class="serie" readonly="false">
                    <input type="text" value="<%=diciembre%>" class="valor" readonly="false" >
                </div>

            </div>
            
            <button onclick="cargarGrafico()" class="crear-grafico">Crear Gráfico</button>
        </div>
        <div class="right">
            <div id="piechart"></div>
        </div>


        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script src="script.js"></script>
        <script src="js/grafica.js" type="text/javascript"></script>
    </body>

</html>