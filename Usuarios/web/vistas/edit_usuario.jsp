<%-- 
    Document   : edit_usuario
    Created on : 4/09/2024, 07:00:39 PM
    Author     : RUFINA RUIZ
--%>

<%@page import="Model.Usuario"%>
<%@page import="ModelDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UsuarioDAO usuariodao = new UsuarioDAO();
            String matricula = (String)request.getAttribute("matricula");
            Usuario usuario = (Usuario)usuariodao.mostrarUsuario(matricula);
        %>
        <h1>Modificar Usuario</h1>
        <form action="Controller">
            MATRICULA: <br>
            <input maxlength="9" type="hidden" name="txt_matricula" value="<%= usuario.getMatricula()%>"> <br> 
            APELLIDO: <br>
            <input type="text" name="txt_apellidos" value="<%= usuario.getApellidos()%>"> <br> 
            NOMBRE: <br>
            <input type="text" name="txt_nombre" value="<%= usuario.getNombre()%>"> <br> 
            CELULAR: <br>
            <input minlength="10" maxlength="10" type="tel" name="txt_celular" value="<%= usuario.getCelular()%>"> <br> 
            CORREO: <br>
            <input type="text" name="txt_correo" value="<%= usuario.getCorreo()%>"> <br> 
            FECHA_NACIMIENTO: <br>
            <input type="date" name="txt_fecha_nac" value="<%= usuario.getFecha_nac()%>"> <br> 
            HORA: <br>
            <input type="time" name="txt_hora" step="1" value="<%= usuario.getHora()%>"> <br> 
            <input type="submit" name="accion" value="actualizar">
        </form>
    </body>
</html>
