/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.services.interfaceServicios.IUsuarioServicio;
import co.com.gblock.entity.Usuario;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FGulfo
 */
@ManagedBean
@SessionScoped
public class LoginEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("LoginBean");
    private String ppal = "principal";
    private String login = "index";
    @EJB
    private IUsuarioServicio usuarioServicio;
    private Usuario usuario;

    public LoginEBean() {
        usuario = new Usuario();
    }

    public String login() {
        LOGGER.log(Level.INFO, "Intentando logear con el usuario {0}", usuario.getNick());

        Usuario usuarioLogin = usuarioServicio.login(usuario);

        if (usuarioLogin != null) {
            LOGGER.log(Level.INFO, "Usuario {0} logeado exitosamente!", usuario.getNick());
            usuario = usuarioLogin;
            return ppal;
        } else {
            LOGGER.log(Level.WARNING, "Login incorrecto, usuario o contraseña inválido!");
            return regresar();
        }
    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().
                getExternalContext().getSession(false);

        session.invalidate();
        return regresar();
    }

    public String regresar() {
        return login;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
