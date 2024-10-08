/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Usuario;
import ModelDAO.UsuarioDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ALEJANDRO DIAZ
 */
public class Controller extends HttpServlet {

    String listar = "vistas/show_usuarios.jsp";
    String add = "vistas/add_usuario.jsp";
    String edit = "vistas/edit_usuario.jsp";
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("agregar")) {
            String nombre = request.getParameter("txt_nombre");
            String correo = request.getParameter("txt_correo");
            String matricula = request.getParameter("txt_matricula");
            String apellidos = request.getParameter("txt_apellidos");
            String celular = request.getParameter("txt_celular");
            String fecha = request.getParameter("txt_fecha_nac");
            String hora = request.getParameter("txt_hora");

            Date fechaFinal = Date.valueOf(fecha);
            Time horaFinal = Time.valueOf(hora);
            
            usuario.setApellidos(apellidos);
            usuario.setCelular(celular);
            usuario.setCorreo(correo);
            usuario.setFecha_nac(fechaFinal);
            usuario.setMatricula(matricula);
            usuario.setNombre(nombre);
            usuario.setHora(horaFinal);
            usuarioDAO.agregarUsuario(usuario);

            response.sendRedirect(request.getContextPath() + "/Controller?accion=listar");
            return;

        }else if (action.equalsIgnoreCase("editar")){
            request.setAttribute("matricula", request.getParameter("matricula"));
            acceso = edit;
        }else if (action.equalsIgnoreCase("actualizar")){
            String nombre = request.getParameter("txt_nombre");
            String correo = request.getParameter("txt_correo");
            String matricula = request.getParameter("txt_matricula");
            String apellidos = request.getParameter("txt_apellidos");
            String celular = request.getParameter("txt_celular");
            String fecha = request.getParameter("txt_fecha_nac");
            String hora = request.getParameter("txt_hora");

            Date fechaFinal = Date.valueOf(fecha);
            Time horaFinal = Time.valueOf(hora);
            
            usuario.setApellidos(apellidos);
            usuario.setCelular(celular);
            usuario.setCorreo(correo);
            usuario.setFecha_nac(fechaFinal);
            usuario.setHora(horaFinal);
            usuario.setNombre(nombre);
            usuario.setMatricula(matricula);
            
            usuarioDAO.editarUsuario(usuario);
            
            response.sendRedirect(request.getContextPath()+"/Controller?accion=listar");
            return;
        }else if (action.equalsIgnoreCase("eliminar")){
            String matricula = request.getParameter("matricula");
            usuario.setMatricula(matricula);
            usuarioDAO.borrarUsuario(matricula);
            response.sendRedirect(request.getContextPath()+"/Controller?accion=listar");
            return;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
