/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.Usuario;
import co.com.gblock.services.interfaceServicios.IUsuarioServicio;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author FGulfo
 */
@ManagedBean
@ViewScoped
public class UsuarioEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("UsuarioEBean");
    @EJB
    private IUsuarioServicio usuarioServicio;
    private Usuario usuario;
    private List<Usuario> listaUsuarios;

    public UsuarioEBean() {

        usuario = new Usuario();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando susuario ({0})", this.getClass().getSimpleName());

        try {

            if (usuario.getId() == null || usuario.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando usuario ({0})", this.getClass().getSimpleName());
                usuario.setEstado(1);
                usuarioServicio.insertar(usuario);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos del usuario ({0})", this.getClass().getSimpleName());
                usuarioServicio.modificar(usuario);
            }

            listar();

            usuario = new Usuario();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar usuario ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaUsuarios = usuarioServicio.listarTodo(Usuario.class);
    }

    public void seleccionar(Usuario usuario) {

        LOGGER.log(Level.INFO, "Seleccionando usuario ({0})", this.getClass().getSimpleName());
        this.usuario = usuario;
    }

    public void eliminar(Usuario usuario) {

        LOGGER.log(Level.INFO, "Eliminando usuario ({0})", this.getClass().getSimpleName());

        try {

            usuarioServicio.eliminar(usuario.getId(), Usuario.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar usuario ({0})", this.getClass().getSimpleName());
        }
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
