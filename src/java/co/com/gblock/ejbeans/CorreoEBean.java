/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.Correo;
import co.com.gblock.services.interfaceServicios.ICorreoServicio;
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
public class CorreoEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("CorreoEBean");
    @EJB
    private ICorreoServicio correoServicio;
    private Correo correo;
    private List<Correo> listaCorreos;

    public CorreoEBean() {

        correo = new Correo();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando correo ({0})", this.getClass().getSimpleName());

        try {

            if (correo.getId() == null || correo.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando correo ({0})", this.getClass().getSimpleName());
                correo.setEstado(1);
                correoServicio.insertar(correo);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos del correo ({0})", this.getClass().getSimpleName());
                correoServicio.modificar(correo);
            }

            listar();

            correo = new Correo();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar correo ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaCorreos = correoServicio.listarTodo(Correo.class);
    }

    public void seleccionar(Correo correo) {

        LOGGER.log(Level.INFO, "Seleccionando correo ({0})", this.getClass().getSimpleName());
        this.correo = correo;
    }

    public void eliminar(Correo correo) {

        LOGGER.log(Level.INFO, "Eliminando correo ({0})", this.getClass().getSimpleName());

        try {

            correoServicio.eliminar(correo.getId(), Correo.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar correo ({0})", this.getClass().getSimpleName());
        }
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    public List<Correo> getListaCorreos() {
        return listaCorreos;
    }

    public void setListaCorreos(List<Correo> listaCorreos) {
        this.listaCorreos = listaCorreos;
    }
}
