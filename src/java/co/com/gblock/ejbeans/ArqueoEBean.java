/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.Arqueo;
import co.com.gblock.services.interfaceServicios.IArqueoServicio;
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
public class ArqueoEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("ArqueoEBeans");
    @EJB
    private IArqueoServicio arqueoServicio;
    private Arqueo arqueo;
    private List<Arqueo> listaArqueos;

    public ArqueoEBean() {

        arqueo = new Arqueo();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando Arqueo ({0})", this.getClass().getSimpleName());

        try {

            if (arqueo.getId() == null || arqueo.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando arqueo ({0})", this.getClass().getSimpleName());
                arqueo.setEstado(1);
                arqueoServicio.insertar(arqueo);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos del arqueo ({0})", this.getClass().getSimpleName());
                arqueoServicio.modificar(arqueo);
            }

            listar();

            arqueo = new Arqueo();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar arqueo ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaArqueos = arqueoServicio.listarTodo(Arqueo.class);
    }

    public void seleccionar(Arqueo arqueo) {

        LOGGER.log(Level.INFO, "Seleccionando arqueo ({0})", this.getClass().getSimpleName());
        this.arqueo = arqueo;
    }

    public void eliminar(Arqueo arqueo) {

        LOGGER.log(Level.INFO, "Eliminando arqueo ({0})", this.getClass().getSimpleName());

        try {

            arqueoServicio.eliminar(arqueo.getId(), Arqueo.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar arqueo ({0})", this.getClass().getSimpleName());
        }
    }

    public Arqueo getArqueo() {
        return arqueo;
    }

    public void setArqueo(Arqueo arqueo) {
        this.arqueo = arqueo;
    }

    public List<Arqueo> getListaArqueos() {
        return listaArqueos;
    }

    public void setListaArqueos(List<Arqueo> listaArqueos) {
        this.listaArqueos = listaArqueos;
    }
    
        
}
