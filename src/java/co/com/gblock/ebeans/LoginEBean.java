/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.entity.Permiso;
import co.com.gblock.services.interfaceServicios.IUsuarioServicio;
import co.com.gblock.entity.Usuario;
import co.com.gblock.services.utilidad.Mensajes;
import java.io.Serializable;
import java.util.List;
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
    private String ppal = "principal?faces-redirect=true";
    private String login = "index?faces-redirect=true";
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
            String[] a = {usuarioLogin.getNick(), usuarioLogin.getPerfil().getNombre()};
            LOGGER.log(Level.INFO, "Usuario {0} logeado exitosamente como {1}!", a);
            for (Permiso p : usuarioLogin.getPerfil().getPermisos()) {
                LOGGER.log(Level.INFO, a[1] + " puede " + p.getNombre());
            }
            usuario = usuarioLogin;
            return ppal;
        } else {
            LOGGER.log(Level.WARNING, "Login incorrecto, usuario o contraseña inválido!");
            Mensajes.agregarErrorMensaje("¡Error: Usuario inválido!", null);
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

    public Boolean puede(String permiso) throws Exception {
        if (usuario == null || usuario.getPerfil() == null || usuario.getPerfil().getPermisos() == null || usuario.getPerfil().getPermisos().isEmpty()) {
            Mensajes.agregarErrorMensaje("¡Error: Usuario inválido!", null);
            throw new Exception("Usuario inválido");
        }

        List<Permiso> permisos = usuario.getPerfil().getPermisos();
        Boolean r = false;
        for (Permiso p : permisos) {
            if (p.getNombre().toUpperCase().equals(permiso.toUpperCase())) {
                r = true;
                break;
            }
        }
        return r;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
