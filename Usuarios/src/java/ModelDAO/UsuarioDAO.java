/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import Config.ConnectionBD;
import Interface.CrudUsuario;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements CrudUsuario{
    ConnectionBD conexion = new ConnectionBD();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usuario = new Usuario();
    
    @Override
    public List listar() {
        ArrayList<Usuario> listaUsarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setCorreo(rs.getString("corrreo"));
                usuario.setFecha_nac(rs.getDate("fecha"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setHora(rs.getTime("hora"));
                listaUsarios.add(usuario);
            }
        } catch (Exception e) {
            System.err.println("ERROR DE CARGA DE DATOS: "+e);
        }
        
        return listaUsarios;
    }

    @Override
    public Usuario mostrarUsuario(String matricula) {
        String sql = "select * from usuarios where matricula = "+matricula; 
                Usuario usuario = new Usuario();
        try {
            conn = conexion.getConnectionBD();
            ps  = conn.prepareStatement(sql);
            rs  = ps.executeQuery();
            while(rs.next()){
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setCorreo(rs.getString("corrreo"));
                usuario.setFecha_nac(rs.getDate("fecha"));
                usuario.setHora(rs.getTime("hora"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNombre(rs.getString("nombre"));
                
            }
        } catch (Exception e) {
            System.err.println("Error: "+e);
        }
        
        return usuario;
    }

    @Override
    public Boolean agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (apellidos, celular, corrreo, "+
                "fecha, matricula, nombre, hora) VALUES ('"+usuario.getApellidos()+"','"+
                usuario.getCelular()+"','"+usuario.getCorreo()+"','"+
                usuario.getFecha_nac()+"','"+usuario.getMatricula()+"','"+
                usuario.getNombre()+"','"+usuario.getHora()+"')";
        
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();           
        } catch (Exception e) {
            System.out.println("ERROR AL INSERTAR: "+e);
        }
        return false;
    }

    @Override
    public Boolean editarUsuario(Usuario usuario) {
        //apellidos, celular, correo, ""fecha_nac, matricula, nombre, hora
        String sql = "UPDATE usuarios SET apellidos = '"+usuario.getApellidos()+
                "', celular = '"+usuario.getCelular()+
                "', fecha = '"+usuario.getFecha_nac()+
                "', nombre = '"+usuario.getNombre()+
                "', hora = '"+usuario.getHora()+
                "', corrreo = '"+usuario.getCorreo()+
                "' WHERE matricula like '"+usuario.getMatricula()+"'";
        System.out.println("SQL: ***" + sql);
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: "+e);
        }
        return false;
    }

    @Override
    public Boolean borrarUsuario(String matricula) {
        String sql = "DELETE FROM usuarios where matricula LIKE '"+matricula+"'";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al borrar los datos: "+e);
        }
        return false;         
    }
    
}
