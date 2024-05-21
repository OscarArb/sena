<%-- 
    Document   : index
    Created on : 13/11/2023, 9:32:37 p. m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/estilos.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Desarrolladores.App</title>
</head>
<body>
    <div class="login-container">
        <form class="form-login" action="Validar" method="POST">
            
            <ul class="login-nav">
                <li class="login-nav__item active">
                    <a href="#">Sign In</a>
                </li>
                
            </ul>
            <label for="login-input-user" class="login__label">
                Username
            </label>
            
            <input type="text" name="txtuser" class="login__input">
            <label for="login-input-password" class="login__label">
                Password
            </label>
            <input type="password" name="txtpass" class="login__input">
            <center>
                <br><label for="login-input-password" class="login__label">
                
                </label></center>
            <label for="login-sign-up" class="login__label--checkbox">
                <input id="login-sign-up" type="checkbox" class="login__input--checkbox" />
                Recordar Datos
            </label>
            <input type="submit" name="accion" value="Ingresar" class="login__submit">
            
        </form>
        <a href="#" class="login__forgot">Olvide mi contraseña?</a>
    </div>
      
    <script src="js/scrip.js"></script>
    
</body>
</html>

