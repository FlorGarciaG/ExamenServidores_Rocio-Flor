/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Usuario;
import java.util.List;

/**
 *
 * @author 
 */
public interface CrudUsuario {
    
    public List listar();
    
    public Usuario mostrarUsuario (String matricula);
    
    public Boolean agregarUsuario (Usuario usuario);
    
    public Boolean editarUsuario (Usuario usuario);
    
    public Boolean borrarUsuario (String matricula);
}
