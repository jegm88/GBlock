/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.entity.Perfil;
import co.com.gblock.entity.Usuario;
import co.com.gblock.services.interfaceServicios.IPerfilServicio;
import co.com.gblock.services.interfaceServicios.IUsuarioServicio;
import co.com.gblock.services.utilidad.Mensajes;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author FGulfo
 */
@ManagedBean
@SessionScoped
public class UsuarioEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("usuarioEBean");
    @EJB
    private IUsuarioServicio usuarioServicio;
    private Usuario usuario;
    private List<Usuario> listaUsuarios;
    @EJB
    private IPerfilServicio perfilServicio;
    private Perfil perfil;
    private List<Perfil> listaPerfiles;
    
    public UsuarioEBean() {
        LOGGER.log(Level.INFO, "Ejecutando constructor ({0})", this.getClass().getSimpleName());
        //listar();
    }

    @PostConstruct
    private void init() {
        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());
        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando usuario ({0})", this.getClass().getSimpleName());

        try {
            Usuario ttmp = usuarioServicio.consultarPorNick(usuario.getNick());
            if (usuario.getId() == null) {
                if (ttmp != null) {
                    throw new Exception("Ya existe un usuario con el nick: " + usuario.getNick());
                } else {
                    LOGGER.log(Level.INFO, "Guardando usuario ({0})", usuario.getNick());
                    usuario.setEstado(1);
                    usuario.setPerfil(perfil);
                    usuarioServicio.insertar(usuario);
                    Mensajes.agregarInfoMensaje("¡usuario " + usuario.getNick() + " guardado exitosamente!", null);
                }
            } else {
                if (ttmp != null && (!usuario.getId().equals(ttmp.getId()) && ttmp.getEstado() != 0)) {
                    throw new Exception("Ya existe un usuario con el nick: " + usuario.getNick());
                } else {
                    LOGGER.log(Level.INFO, "Modificando datos del usuario ({0})", usuario.getNick());
                    usuarioServicio.modificar(usuario);
                    Mensajes.agregarInfoMensaje("¡usuario " + usuario.getNick() + " modificada!", null);
                }
            }
            listar();
            nuevo();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al guardar/modificar: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }

    private void listar() {
        LOGGER.log(Level.INFO, "Actualizando...");
        listaUsuarios = usuarioServicio.listarHabilitados();
        listaPerfiles = perfilServicio.listarHabilitados();
    }

    public void seleccionar(Usuario usuario) {
        LOGGER.log(Level.INFO, "Seleccionando usuario ({0})", this.getClass().getSimpleName());
        this.usuario = usuario;
        this.perfil = usuario.getPerfil();
    }

    public void imprimir(Usuario u) {
        LOGGER.log(Level.INFO, "Imprimir: {0}", u);
    }

    public void eliminar() {
        eliminar(usuario);
    }

    public void eliminar(Usuario usuario) {
        LOGGER.log(Level.INFO, "Eliminando usuario ({0})", usuario.getNick());
        try {
            //usuarioServicio.eliminar(bodega.getId(), Bodega.class);
            usuario.setEstado(0);
            usuarioServicio.modificar(usuario);
            Mensajes.agregarInfoMensaje("usuario " + usuario.getNick() + " eliminado exitosamente!", null);
            listar();
            nuevo();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al eliminar usuario: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }

    public void nuevo() {
        LOGGER.log(Level.INFO, "Creando nuevo usuario");
        usuario = new Usuario();
        Mensajes.agregarInfoMensaje("¡Nuevo usuario!", null);
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

    public List<Perfil> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(List<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }   
}