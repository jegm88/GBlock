/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.entity.TipoDocumento;
import co.com.gblock.services.interfaceServicios.ITipoDocumentoServicio;
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
public class TipoDocumentoEBean implements Serializable{
    
    private static final Logger LOGGER = Logger.getLogger("TipoDocumentoEBean");
    @EJB
    private ITipoDocumentoServicio tipoDocumentoServicio;
    private TipoDocumento tipoDocumento;
    private List<TipoDocumento> listaTipoDocumentos;
    
    public TipoDocumentoEBean(){
         LOGGER.log(Level.INFO, "Ejecutando constructor ({0})", this.getClass().getSimpleName());
         tipoDocumento = new TipoDocumento();
    }
    
    @PostConstruct
    private void init() {
        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());
        listar();
    }

    public void nuevo() {
        LOGGER.log(Level.INFO, "Creando nuevo tipo de documento");
        tipoDocumento = new TipoDocumento();
        Mensajes.agregarInfoMensaje("¡Nuevo tipoDocumento!", null);
    }

    public void guardar() {
        LOGGER.log(Level.INFO, "Registrando tipo de documento ({0})", this.getClass().getSimpleName());
        try {
            if (tipoDocumento.getId() == null) {
                LOGGER.log(Level.INFO, "entro");
                TipoDocumento tmp = tipoDocumentoServicio.consultarPorNombre(tipoDocumento.getNombre());
                if (tmp!= null) {
                    throw new Exception("Ya existe un tipo de documento con el nombre: " + tipoDocumento.getNombre());
                } else {
                    LOGGER.log(Level.INFO, "Guardando tipo de documento ({0})", tipoDocumento.getNombre());
                    tipoDocumento.setEstado(1);
                    tipoDocumentoServicio.insertar(tipoDocumento);
                    Mensajes.agregarInfoMensaje("¡Tipo de documento " + tipoDocumento.getNombre() + " guardado exitosamente!", null);
                }
            } else {
                TipoDocumento tmp = tipoDocumentoServicio.consultarPorNombre(tipoDocumento.getNombre());
                if (tmp != null && (!tipoDocumento.getId().equals(tmp.getId())&& tmp.getEstado()!=0)) {
                    throw new Exception("Ya existe un tipo de documento con el nombre: " + tipoDocumento.getNombre());
                } else {
                    LOGGER.log(Level.INFO, "Modificando datos del tipo de documento ({0})", tipoDocumento.getNombre());
                    tipoDocumentoServicio.modificar(tipoDocumento);
                    Mensajes.agregarInfoMensaje("¡Tipo de documento " + tipoDocumento.getNombre() + " modificado!", null);
                }
            }
            listar();
            tipoDocumento = new TipoDocumento();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al guardar/eliminar: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }

    private void listar() {
        LOGGER.log(Level.INFO, "Actualizando lista tipo de documento...");
        listaTipoDocumentos = tipoDocumentoServicio.listarHabilitados();
    }

    public void seleccionar(TipoDocumento tipoDocumento) {
        LOGGER.log(Level.INFO, "Seleccionando tipo de documento ({0})", this.getClass().getSimpleName());
        this.tipoDocumento = tipoDocumento;
        Mensajes.agregarInfoMensaje("¡Datos de tipo de documento"+ (tipoDocumento.getNombre())+" cargados! ", null);
    }

    public void eliminar() {
        eliminar(tipoDocumento);
    }

    public void eliminar(TipoDocumento tipoDocumento) {
        LOGGER.log(Level.INFO, "Eliminando tipo de documento ({0})", tipoDocumento.getNombre());
        try {
            //tipoDocumentoServicio.eliminar(tipoDocumento.getId(), TipoDocumento.class);
            tipoDocumento.setEstado(0);
            tipoDocumentoServicio.modificar(tipoDocumento);
            Mensajes.agregarInfoMensaje("Tipo de documento " + tipoDocumento.getNombre() + " eliminado exitosamente!", null);
            listar();
            nuevo();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al eliminar tipo de documento: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<TipoDocumento> getListaTipoDocumentos() {
        return listaTipoDocumentos;
    }

    public void setListaTipoDocumentos(List<TipoDocumento> listaTipoDocumentos) {
        this.listaTipoDocumentos = listaTipoDocumentos;
    }
}
