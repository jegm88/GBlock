/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.TipoDocumento;
import co.com.gblock.services.interfaceServicios.ITipoDocumentoServicio;
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
public class TipoDocumentoEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("TipoDocumentoEBean");
    @EJB
    private ITipoDocumentoServicio tipoDocumentoServicio;
    private TipoDocumento tipoDocumento;
    private List<TipoDocumento> listaTipoDocumentos;

    public TipoDocumentoEBean() {

        tipoDocumento = new TipoDocumento();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando tipo de documento ({0})", this.getClass().getSimpleName());

        try {

            if (tipoDocumento.getId() == null || tipoDocumento.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando tipo  de documento ({0})", this.getClass().getSimpleName());
                tipoDocumento.setEstado(1);
                tipoDocumentoServicio.insertar(tipoDocumento);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos del tipo de documento ({0})", this.getClass().getSimpleName());
                tipoDocumentoServicio.modificar(tipoDocumento);
            }

            listar();

            tipoDocumento = new TipoDocumento();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar tipo de documento ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaTipoDocumentos = tipoDocumentoServicio.listarTodo(TipoDocumento.class);
    }

    public void seleccionar(TipoDocumento tipoDocumento) {

        LOGGER.log(Level.INFO, "Seleccionando tipo de documento ({0})", this.getClass().getSimpleName());
        this.tipoDocumento = tipoDocumento;
    }

    public void eliminar(TipoDocumento tipoDocumento) {

        LOGGER.log(Level.INFO, "Eliminando tipo de documento ({0})", this.getClass().getSimpleName());

        try {

            tipoDocumentoServicio.eliminar(tipoDocumento.getId(), TipoDocumento.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar tipo de documento ({0})", this.getClass().getSimpleName());
        }
    }

    public List<TipoDocumento> getListaTipoDocumentos() {
        return listaTipoDocumentos;
    }

    public void setListaTipoDocumentos(List<TipoDocumento> listaTipoDocumentos) {
        this.listaTipoDocumentos = listaTipoDocumentos;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
