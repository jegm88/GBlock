/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.entity.Articulo;
import co.com.gblock.entity.CategoriaArticulo;
import co.com.gblock.services.interfaceServicios.IArticuloServicio;
import co.com.gblock.services.interfaceServicios.ICategoriaArticuloServicio;
import co.com.gblock.services.utilidad.Mensajes;
import java.io.Serializable;
import java.util.ArrayList;
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
public class ArticuloEBean implements Serializable{
    private static final Logger LOGGER = Logger.getLogger("ArticuloEBean");
    
    @EJB 
    private IArticuloServicio articuloServicio;
    @EJB 
    private ICategoriaArticuloServicio categoriaArticuloServicio;
    private Articulo articulo;
    private CategoriaArticulo categoria;
    private List<CategoriaArticulo> listaCategoriaArticulos;
    private List<Articulo> listaArticulos;
    private List<Articulo> clasificados;
    
    public ArticuloEBean(){
        
        articulo = new Articulo();
        categoria = new CategoriaArticulo();
    }
    
    @PostConstruct
    private void init(){
        
        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());
        
        listar();
    }
    
    public void nuevo() {
        LOGGER.log(Level.INFO, "Creando nuevo articulo");
        categoria = new CategoriaArticulo();
        articulo = new Articulo();
        Mensajes.agregarInfoMensaje("¡Nuevo articulo!", null);
    }
    public void clasificar(String categoria){
        LOGGER.log(Level.INFO, "clasificando articulos por categoria {0}", categoria);
        categoriaArticuloServicio.listarHabilitados();
        clasificados = articuloServicio.listarArticulo(categoria);
    }
    public void guardar() {
        LOGGER.log(Level.INFO, "Registrando articulo ({0})", this.getClass().getSimpleName());
        try {
            if (articulo.getId() == null) {
                Articulo tmp = articuloServicio.consultarPorNombre(articulo.getNombre());
                if (tmp!= null) {
                    throw new Exception("Ya existe un articulo con el nombre: " + articulo.getNombre());
                } else {
                    LOGGER.log(Level.INFO, "Guardando articulo ({0})", articulo.getNombre());
                    articulo.setEstado(1);
                    articuloServicio.insertar(articulo);
                    Mensajes.agregarInfoMensaje("¡Articulo " + articulo.getNombre() + " guardado exitosamente!", null);
                    nuevo();
                }
            } else {
                Articulo tmp = articuloServicio.consultarPorNombre(articulo.getNombre());
                if (tmp != null && (!articulo.getId().equals(tmp.getId())&& tmp.getEstado()!=0)) {
                    throw new Exception("Ya existe un articulo con el nombre: " + articulo.getNombre());
                } else {
                    LOGGER.log(Level.INFO, "Modificando datos del articulo ({0})", articulo.getNombre());
                    articuloServicio.modificar(articulo);
                    Mensajes.agregarInfoMensaje("¡Articulo " + articulo.getNombre() + " modificado!", null);
                }
            }
            listar();
            articulo = new Articulo();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al guardar/eliminar: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }
    
    private void listar() {
        LOGGER.log(Level.INFO, "Actualizando lista articulos...");
        listaArticulos = articuloServicio.listarHabilitados();
        listaCategoriaArticulos = categoriaArticuloServicio.listarHabilitados();
    }
    
    public void seleccionar(Articulo articulo) {
        LOGGER.log(Level.INFO, "Seleccionando articulo ({0})", this.getClass().getSimpleName());
        this.articulo = articulo;
        Mensajes.agregarInfoMensaje("¡Datos de articulo"+ (articulo.getNombre())+" cargados! ", null);
    }
    
    public void eliminar() {
        eliminar(articulo);
    }
    
    public void eliminar(Articulo articulo) {
        LOGGER.log(Level.INFO, "Eliminando articulo ({0})", articulo.getNombre());
        try {
            //bodegaServicio.eliminar(bodega.getId(), Bodega.class);
            articulo.setEstado(0);
            articuloServicio.modificar(articulo);
            Mensajes.agregarInfoMensaje("Articulo " + articulo.getNombre() + " eliminado exitosamente!", null);
            listar();
            nuevo();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al eliminar articulo: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
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

    public List<Articulo> getClasificados() {
        return clasificados;
    }

    public void setClasificados(List<Articulo> clasificados) {
        this.clasificados = clasificados;
    }

    public CategoriaArticulo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaArticulo categoria) {
        this.categoria = categoria;
    }

    public List<CategoriaArticulo> getListaCategoriaArticulos() {
        return listaCategoriaArticulos;
    }

    public void setListaCategoriaArticulos(List<CategoriaArticulo> listaCategoriaArticulos) {
        this.listaCategoriaArticulos = listaCategoriaArticulos;
    }
}
