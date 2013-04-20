/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.services.interfaceServicios.IUsuarioServicio;
import co.com.gblock.entity.Usuario;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author FGulfo
 */
@ManagedBean
@SessionScoped
public class LoginEBean implements Serializable{
    private static final Logger LOGGER = Logger.getLogger("LoginBean");
    
    @EJB private IUsuarioServicio usuarioServicio;
    
    private Usuario usuario;
    
    public LoginEBean(){
        usuario = new Usuario();
    }    
    
    public String login(){
        LOGGER.log(Level.INFO, "Intentando logear con el usuario", usuario);
        
        Usuario usuarioLogin = usuarioServicio.login(usuario);
        
        if(usuarioLogin != null){
            LOGGER.info("Usuario logeado "+ usuario.getNick() +" exitosamente!");
            usuario = usuarioLogin;
            
            
            return "Principal.jsp";
        }else{
            return "Error.jsp";
        }
    }
    
    public String regresar(){
        
        return "index.jsp";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}