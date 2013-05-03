/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.Bodega;
import co.com.gblock.services.interfaceServicios.IBodegaServicio;
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
public class BodegaEBean implements Serializable{
    private static final Logger LOGGER = Logger.getLogger("BodegaEBean");
    
    @EJB private IBodegaServicio bodegaServicio;
    
    private Bodega bodega;
    private List<Bodega> listaBodegas;
    
    public BodegaEBean(){
        
        bodega = new Bodega();
    }
    
    @PostConstruct
    private void init(){
        
        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());
        
        listar();
    }
    
    public void guardar(){
        
        LOGGER.log(Level.INFO, "Registrando bodega ({0})", this.getClass().getSimpleName());
        
        try {
            
            if(bodega.getId() == null || bodega.getId() == 0){
                LOGGER.log(Level.INFO, "Guardando bodega ({0})", this.getClass().getSimpleName());
                bodega.setEstado(1);
                bodegaServicio.insertar(bodega);
            }else{
                
                LOGGER.log(Level.INFO, "Modificando datos de la bodega ({0})", this.getClass().getSimpleName());
                bodegaServicio.modificar(bodega);
            }
            
            listar();
            
            bodega = new Bodega();
        } catch (Exception e) {
            
            LOGGER.log(Level.SEVERE, "Error al registrar bodega ({0})", this.getClass().getSimpleName());
        }
    }
    
    private void listar(){
        
        LOGGER.log(Level.INFO, "Actualizando...");
        
        listaBodegas = bodegaServicio.listarTodo(Bodega.class);
    }
    
    public void seleccionar(Bodega bodega){
        
        LOGGER.log(Level.INFO, "Seleccionando bodega ({0})", this.getClass().getSimpleName());
        this.bodega = bodega;
    }
    
    public void eliminar(Bodega bodega){
        
        LOGGER.log(Level.INFO, "Eliminando bodega ({0})", this.getClass().getSimpleName());
        
        try {
            
            bodegaServicio.eliminar(bodega.getId(), Bodega.class);
            
            listar();
        } catch (Exception e) {
            
            LOGGER.log(Level.SEVERE, "Error al eliminar bodega ({0})", this.getClass().getSimpleName());
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
