/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.entity.Telefono;
import co.com.gblock.services.interfaceServicios.ITelefonoServicio;
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
public class TelefonoEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("TelefonoEBean");
    @EJB
    private ITelefonoServicio telefonoServicio;
    private Telefono telefono;
    private List<Telefono> listaTelefonos;

    public TelefonoEBean() {

        telefono = new Telefono();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando telefono ({0})", this.getClass().getSimpleName());

        try {

            if (telefono.getId() == null || telefono.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando telfono ({0})", this.getClass().getSimpleName());
                telefono.setEstado(1);
                telefonoServicio.insertar(telefono);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos del telefono ({0})", this.getClass().getSimpleName());
                telefonoServicio.modificar(telefono);
            }

            listar();

            telefono = new Telefono();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar telefono ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaTelefonos = telefonoServicio.listarTodo(Telefono.class);
    }

    public void seleccionar(Telefono telefono) {

        LOGGER.log(Level.INFO, "Seleccionando telefono ({0})", this.getClass().getSimpleName());
        this.telefono = telefono;
    }

    public void eliminar(Telefono telefono) {

        LOGGER.log(Level.INFO, "Eliminando telefono ({0})", this.getClass().getSimpleName());

        try {

            telefonoServicio.eliminar(telefono.getId(), Telefono.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar telefono ({0})", this.getClass().getSimpleName());
        }
    }

    public List<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }

    public void setListaTelefonos(List<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
}
