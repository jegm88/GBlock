/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.Articulo;
import co.com.gblock.services.interfaceServicios.IArticuloServicio;
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
public class ArticuloEBean implements Serializable{
    private static final Logger LOGGER = Logger.getLogger("ArticuloEBean");
    
    @EJB private IArticuloServicio articuloServicio;
    
    private Articulo articulo;
    
    private List<Articulo> listaArticulos;
    
    public ArticuloEBean(){
        
        articulo = new Articulo();
    }
    
    @PostConstruct
    private void init(){
        
        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());
        
        listar();
    }
    
    public void guardar(){
        
        LOGGER.log(Level.INFO, "Registrando articulo ({0})", this.getClass().getSimpleName());
        
        try {
            
            if(articulo.getId() == null || articulo.getId() == 0){
                LOGGER.log(Level.INFO, "Guardando articulo ({0})", this.getClass().getSimpleName());
                articulo.setEstado(1);
                articuloServicio.insertar(articulo);
            }else{
                
                LOGGER.log(Level.INFO, "Modificando datos del articulo ({0})", this.getClass().getSimpleName());
                articuloServicio.modificar(articulo);
            }
            
            listar();
            
            articulo = new Articulo();
        } catch (Exception e) {
            
            LOGGER.log(Level.SEVERE, "Error al registrar articulo ({0})", this.getClass().getSimpleName());
        }
    }
    
    private void listar(){
        
        LOGGER.log(Level.INFO, "Actualizando...");
        
        listaArticulos = articuloServicio.listarTodo(Articulo.class);
    }
    
    public void seleccionar(Articulo articulo){
        
        LOGGER.log(Level.INFO, "Seleccionando articulo ({0})", this.getClass().getSimpleName());
        this.articulo = articulo;
    }
    
    public void eliminar(Articulo articulo){
        
        LOGGER.log(Level.INFO, "Eliminando articulo ({0})", this.getClass().getSimpleName());
        
        try {
            
            articuloServicio.eliminar(articulo.getId(), Articulo.class);
            
            listar();
        } catch (Exception e) {
            
            LOGGER.log(Level.SEVERE, "Error al eliminar articulo ({0})", this.getClass().getSimpleName());
        }
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public List<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }
    
    
}
