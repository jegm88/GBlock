/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.TipoTercero;
import co.com.gblock.services.interfaceServicios.ITipoTerceroServicio;
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
public class TipoTerceroEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("TipoTerceroEBean");
    @EJB
    private ITipoTerceroServicio tipoTerceroServicio;
    private TipoTercero tipoTercero;
    private List<TipoTercero> listaTipoTerceros;

    public TipoTerceroEBean() {

        tipoTercero = new TipoTercero();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando tipo de tercero ({0})", this.getClass().getSimpleName());

        try {

            if (tipoTercero.getId() == null || tipoTercero.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando tipo de tercero ({0})", this.getClass().getSimpleName());
                tipoTercero.setEstado(1);
                tipoTerceroServicio.insertar(tipoTercero);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos del tipo de tercero ({0})", this.getClass().getSimpleName());
                tipoTerceroServicio.modificar(tipoTercero);
            }

            listar();

            tipoTercero = new TipoTercero();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar tipo de tercero ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaTipoTerceros = tipoTerceroServicio.listarTodo(TipoTercero.class);
    }

    public void seleccionar(TipoTercero tipoTercero) {

        LOGGER.log(Level.INFO, "Seleccionando tipo de tercero ({0})", this.getClass().getSimpleName());
        this.tipoTercero = tipoTercero;
    }

    public void eliminar(TipoTercero tipoTercero) {

        LOGGER.log(Level.INFO, "Eliminando tipo de tercero ({0})", this.getClass().getSimpleName());

        try {

            tipoTerceroServicio.eliminar(tipoTercero.getId(), TipoTercero.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar tipo de tercero ({0})", this.getClass().getSimpleName());
        }
    }

    public List<TipoTercero> getListaTipoTerceros() {
        return listaTipoTerceros;
    }

    public void setListaTipoTerceros(List<TipoTercero> listaTipoTerceros) {
        this.listaTipoTerceros = listaTipoTerceros;
    }

    public TipoTercero getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(TipoTercero tipoTercero) {
        this.tipoTercero = tipoTercero;
    }
}
