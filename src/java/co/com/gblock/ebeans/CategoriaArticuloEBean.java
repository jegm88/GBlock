/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.entity.CategoriaArticulo;
import co.com.gblock.services.interfaceServicios.ICategoriaArticuloServicio;
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
public class CategoriaArticuloEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("CategoriaArticuloEBean");
    @EJB
    private ICategoriaArticuloServicio categoriaArticuloServicio;
    private CategoriaArticulo categoriaArticulo;
    private List<CategoriaArticulo> listaCategoriaArticulos;

    public CategoriaArticuloEBean() {

        categoriaArticulo = new CategoriaArticulo();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }
    
    public void nuevo() {
        LOGGER.log(Level.INFO, "Creando nueva categoria de articulo");
        categoriaArticulo = new CategoriaArticulo();
        Mensajes.agregarInfoMensaje("¡Nueva categoria de articulo!", null);
    }

    public void guardar() {
        LOGGER.log(Level.INFO, "Registrando categoria de articulo ({0})", this.getClass().getSimpleName());
        try {
            if (categoriaArticulo.getId() == null) {
                CategoriaArticulo tmp = categoriaArticuloServicio.consultarPorNombre(categoriaArticulo.getNombre());
                if (tmp!= null) {
                    throw new Exception("Ya existe una categoria de articulo con el nombre: " + categoriaArticulo.getNombre());
                } else {
                    LOGGER.log(Level.INFO, "Guardando categoria de articulo ({0})", categoriaArticulo.getNombre());
                    categoriaArticulo.setEstado(1);
                    categoriaArticuloServicio.insertar(categoriaArticulo);
                    Mensajes.agregarInfoMensaje("¡Categoria de articulo " + categoriaArticulo.getNombre() + " guardada exitosamente!", null);
                }
            } else {
                CategoriaArticulo tmp = categoriaArticuloServicio.consultarPorNombre(categoriaArticulo.getNombre());
                if (tmp != null && (!categoriaArticulo.getId().equals(tmp.getId())&& tmp.getEstado()!=0)) {
                    throw new Exception("Ya existe una categoriaArticulo con el nombre: " + categoriaArticulo.getNombre());
                } else {
                    LOGGER.log(Level.INFO, "Modificando datos de la categoria de articulo ({0})", categoriaArticulo.getNombre());
                    categoriaArticuloServicio.modificar(categoriaArticulo);
                    Mensajes.agregarInfoMensaje("¡Categoria de articulo " + categoriaArticulo.getNombre() + " modificada!", null);
                }
            }
            listar();
            categoriaArticulo = new CategoriaArticulo();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al guardar/eliminar: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }
    
    private void listar() {
        LOGGER.log(Level.INFO, "Actualizando lista categorias de articulo...");
        listaCategoriaArticulos = categoriaArticuloServicio.listarHabilitados();
    }

    public void seleccionar(CategoriaArticulo categoriaArticulo) {
        LOGGER.log(Level.INFO, "Seleccionando categoria de articulo ({0})", this.getClass().getSimpleName());
        this.categoriaArticulo = categoriaArticulo;
        Mensajes.agregarInfoMensaje("Datos de la categoria de articulo " + (categoriaArticulo.getNombre())+" cargados!", null);
    }
    
    public void eliminar() {
        eliminar(categoriaArticulo);
    }

    public void eliminar(CategoriaArticulo categoriaArticulo) {
        LOGGER.log(Level.INFO, "Eliminando categoria de articulo ({0})", categoriaArticulo.getNombre());
        try {
            categoriaArticuloServicio.eliminar(categoriaArticulo.getId(), CategoriaArticulo.class);
            Mensajes.agregarInfoMensaje("Categoria de articulo " + categoriaArticulo.getNombre() + " eliminada exitosamente!", null);
            listar();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al eliminar categoria de articulo: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }

    public CategoriaArticulo getCategoriaArticulo() {
        return categoriaArticulo;
    }

    public void setCategoriaArticulo(CategoriaArticulo categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }

    public List<CategoriaArticulo> getListaCategoriaArticulos() {
        return listaCategoriaArticulos;
    }

    public void setListaCategoriaArticulos(List<CategoriaArticulo> listaCategoriaArticulos) {
        this.listaCategoriaArticulos = listaCategoriaArticulos;
    }
}
