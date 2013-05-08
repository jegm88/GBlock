/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.Tercero;
import co.com.gblock.entity.TipoTercero;
import co.com.gblock.services.interfaceServicios.ITerceroServicio;
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
public class TerceroEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("TerceroEBean");
    @EJB
    private ITerceroServicio terceroServicio;
    @EJB
    private ITipoTerceroServicio tipoTerceroServicio;
    private Tercero tercero;
    private List<Tercero> listaTerceros;
    private List<TipoTercero> listaTipoTerceros;

    public TerceroEBean() {

        tercero = new Tercero();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando tercero ({0})", this.getClass().getSimpleName());

        try {

            if (tercero.getId() == null || tercero.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando tercero ({0})", this.getClass().getSimpleName());
                tercero.setEstado(1);
                terceroServicio.insertar(tercero);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos del tercero ({0})", this.getClass().getSimpleName());
                terceroServicio.modificar(tercero);
            }

            listar();

            tercero = new Tercero();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar tercero ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaTerceros = terceroServicio.listarTodo(Tercero.class);
        listaTipoTerceros = tipoTerceroServicio.listarTodo(TipoTercero.class);
    }

    public void seleccionar(Tercero tercero) {

        LOGGER.log(Level.INFO, "Seleccionando tercero ({0})", this.getClass().getSimpleName());
        this.tercero = tercero;
    }

    public void eliminar(Tercero tercero) {

        LOGGER.log(Level.INFO, "Eliminando tercero ({0})", this.getClass().getSimpleName());

        try {

            terceroServicio.eliminar(tercero.getId(), Tercero.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar tercero ({0})", this.getClass().getSimpleName());
        }
    }

    public List<Tercero> getListaTerceros() {
        return listaTerceros;
    }

    public void setListaTerceros(List<Tercero> listaTerceros) {
        this.listaTerceros = listaTerceros;
    }

    public Tercero getTercero() {
        return tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

    public List<TipoTercero> getListaTipoTerceros() {
        return listaTipoTerceros;
    }

    public void setListaTipoTerceros(List<TipoTercero> listaTipoTerceros) {
        this.listaTipoTerceros = listaTipoTerceros;
    }   
}
