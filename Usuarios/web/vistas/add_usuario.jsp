<%-- 
    Document   : add_usuario
    Created on : 4/09/2024, 07:00:28 PM
    Author     : RUFINA RUIZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        </head>
    <body>
        <div>
            <h1>Registrar Usuario</h1>
            <form action="Controller">
                APELLIDO: <br>
                <input type="text" name="txt_apellidos"><br>
                NOMBRE: <br>
                <input type="text" name="txt_nombre"><br>
                CELULAR: <br>
                <input minlength="10" maxlength="10" type="tel" name="txt_celular"><br>
                CORREO: <br>
                <input type="text" name="txt_correo"><br>
                FECHA_NACIMIENTO: <br>
                <input type="date" name="txt_fecha_nac"><br>
                MATRICULA: <br>
                <input maxlength="9" type="text" name="txt_matricula"><br> 
                HORA: <br>
                <input type="time" name="txt_hora" step="1"><br>
                <input type="submit" name="accion" value="Agregar">
            </form>
        </div>
    </body>
</html>
