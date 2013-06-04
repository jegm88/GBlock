/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.entity.Bodega;
import co.com.gblock.services.interfaceServicios.IBodegaServicio;
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
public class BodegaEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("BodegaEBean");
    @EJB
    private IBodegaServicio bodegaServicio;
    private Bodega bodega;
    private List<Bodega> listaBodegas;

    public BodegaEBean() {
        LOGGER.log(Level.INFO, "Ejecutando constructor ({0})", this.getClass().getSimpleName());
        bodega = new Bodega();
    }

    @PostConstruct
    private void init() {
        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());
        listar();
    }

    public void nuevo() {
        LOGGER.log(Level.INFO, "Creando nueva bodega");
        bodega = new Bodega();
        Mensajes.agregarInfoMensaje("¡Nueva bodega!", null);
    }

    public void guardar() {
        LOGGER.log(Level.INFO, "Registrando bodega ({0})", this.getClass().getSimpleName());
        try {
            Bodega tmp = bodegaServicio.consultarPorNombre(bodega.getNombre());
            if (bodega.getId() == null) {
                LOGGER.log(Level.INFO, "entro");
                if (tmp != null) {
                    throw new Exception("Ya existe una bodega con el nombre: " + bodega.getNombre());
                } else {
                    LOGGER.log(Level.INFO, "Guardando bodega ({0})", bodega.getNombre());
                    bodega.setEstado(1);
                    bodegaServicio.insertar(bodega);
                    Mensajes.agregarInfoMensaje("¡Bodega " + bodega.getNombre() + " guardada exitosamente!", null);
                }
            } else {
                if (tmp != null && (!bodega.getId().equals(tmp.getId()) && tmp.getEstado() != 0)) {
                    throw new Exception("Ya existe una bodega con el nombre: " + bodega.getNombre());
                } else {
                    LOGGER.log(Level.INFO, "Modificando datos de la bodega ({0})", bodega.getNombre());
                    bodegaServicio.modificar(bodega);
                    Mensajes.agregarInfoMensaje("¡Bodega " + bodega.getNombre() + " modificada!", null);
                }
            }
            listar();
            bodega = new Bodega();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error alg guardar/eliminar: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }

    private void listar() {
        LOGGER.log(Level.INFO, "Actualizando lista bodegas...");
        listaBodegas = bodegaServicio.listarHabilitados();
    }

    public void seleccionar(Bodega bodega) {
        LOGGER.log(Level.INFO, "Seleccionando bodega ({0})", this.getClass().getSimpleName());
        this.bodega = bodega;
        Mensajes.agregarInfoMensaje("¡Datos de bodega" + (bodega.getNombre()) + " cargados! ", null);
    }

    public void eliminar() {
        eliminar(bodega);
    }

    public void eliminar(Bodega bodega) {
        LOGGER.log(Level.INFO, "Eliminando bodega ({0})", bodega.getNombre());
        try {
            //bodegaServicio.eliminar(bodega.getId(), Bodega.class);
            bodega.setEstado(0);
            bodegaServicio.modificar(bodega);
            Mensajes.agregarInfoMensaje("Bodega " + bodega.getNombre() + " eliminada exitosamente!", null);
            listar();
            nuevo();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al eliminar bodega: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public List<Bodega> getListaBodegas() {
        return listaBodegas;
    }

    public void setListaBodegas(List<Bodega> listaBodegas) {
        this.listaBodegas = listaBodegas;
    }
}
