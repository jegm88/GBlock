/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.DetalleDocumento;
import co.com.gblock.services.interfaceServicios.IDetalleDocumentoServicio;
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
public class DetalleDocumentoEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("DetalleDocumentoEBean");
    
    @EJB private IDetalleDocumentoServicio detalleDocumentoServicio;
    
    private DetalleDocumento detalleDocumento;
    
    private List<DetalleDocumento> listaDetalleDocumentos;

    public DetalleDocumentoEBean() {

        detalleDocumento = new DetalleDocumento();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando detalle de documento ({0})", this.getClass().getSimpleName());

        try {

            if (detalleDocumento.getId() == null || detalleDocumento.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando detalle de documento ({0})", this.getClass().getSimpleName());
                detalleDocumento.setEstado(1);
                detalleDocumentoServicio.insertar(detalleDocumento);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos del detalle de documento ({0})", this.getClass().getSimpleName());
                detalleDocumentoServicio.modificar(detalleDocumento);
            }

            listar();

            detalleDocumento = new DetalleDocumento();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar detalle de documento ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaDetalleDocumentos = detalleDocumentoServicio.listarTodo(DetalleDocumento.class);
    }

    public void seleccionar(DetalleDocumento detalleDocumento) {

        LOGGER.log(Level.INFO, "Seleccionando detalle de documento ({0})", this.getClass().getSimpleName());
        this.detalleDocumento = detalleDocumento;
    }

    public void eliminar(DetalleDocumento detalleDocumento) {

        LOGGER.log(Level.INFO, "Eliminando detalle de documento ({0})", this.getClass().getSimpleName());

        try {

            detalleDocumentoServicio.eliminar(detalleDocumento.getId(), DetalleDocumento.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar detalle de documento ({0})", this.getClass().getSimpleName());
        }
    }

    public DetalleDocumento getDetalleDocumento() {
        return detalleDocumento;
    }

    public void setDetalleDocumento(DetalleDocumento detalleDocumento) {
        this.detalleDocumento = detalleDocumento;
    }

    public List<DetalleDocumento> getListaDetalleDocumentos() {
        return listaDetalleDocumentos;
    }

    public void setListaDetalleDocumentos(List<DetalleDocumento> listaDetalleDocumentos) {
        this.listaDetalleDocumentos = listaDetalleDocumentos;
    }
}
