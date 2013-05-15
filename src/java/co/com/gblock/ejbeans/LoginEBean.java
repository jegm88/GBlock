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
 * 
 * jaas (inv)
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
        LOGGER.log(Level.INFO, "Intentando logear con el usuario {0}", usuario.getNick());
        
        Usuario usuarioLogin = usuarioServicio.login(usuario);
        
        if(usuarioLogin != null){
            LOGGER.log(Level.INFO, "Usuario {0} logeado exitosamente!", usuario.getNick());
            usuario = usuarioLogin;
            return "principal.xhtml";
        }else{
            LOGGER.log(Level.WARNING, "Login incorrecto, usuario o contraseña inválido!");
            return regresar();
        }
    }
    
    public String regresar(){
        return "index.xhtml";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   
}
