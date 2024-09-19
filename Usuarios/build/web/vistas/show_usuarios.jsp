<%-- 
    Document   : show_usuarios
    Created on : 4/09/2024, 07:00:58 PM
    Author     : ALEJANDRO DIAZ 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Iterator"%>
<%@page import = "java.util.List"%>
<%@page import = "Model.Usuario"%>
<%@page import = "ModelDAO.UsuarioDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        <h1>lISTA DE LOS USUARIOS REGISTRADOS</h1>
        <a href="Controller?accion=add">AGREGAR USUARIO</a>
        <table border="1">
            <thead>
                <tr>
                    <th>APELLIDOS</th>
                    <th>NOMBRE</th>
                    <th>CORREO</th>
                    <th>MATRICULA</th>
                    <th>CELULAR</th>
                    <th>FECHA DE NACIMIENTO</th>
                    <th>HORA</th>
                </tr>
            </thead>
            <%
                    UsuarioDAO dao = new UsuarioDAO();
                    List<Usuario> lista = dao.listar();
                    if (lista.isEmpty()){
                        System.out.println("No hay registros en la lista");
                    }
                    
                    Iterator <Usuario> iterador = lista.iterator();
                    Usuario user1 = null;
                    
                    while (iterador.hasNext()){
                        user1 = iterador.next();  
                       
                %>
            <tbody>
                
                <tr>
                    <td><%= user1.getApellidos() %></td>
                    <td><%= user1.getNombre() %></td>
                    <td><%= user1.getCorreo() %></td>
                    <td><%= user1.getMatricula() %></td>
                    <td><%= user1.getCelular() %></td>                    
                    <td><%= user1.getFecha_nac() %></td>
                    <td><%= user1.getHora()%></td>
                    <td>
                        <a href="Controller?accion=editar&matricula=<%= user1.getMatricula() %>">Editar</a>
                        <a href="Controller?accion=eliminar&matricula=<%= user1.getMatricula() %>">Borrar</a>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
