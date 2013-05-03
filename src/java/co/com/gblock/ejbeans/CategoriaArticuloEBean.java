/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.CategoriaArticulo;
import co.com.gblock.services.interfaceServicios.ICategoriaArticuloServicio;
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

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando categoria de articulo ({0})", this.getClass().getSimpleName());

        try {

            if (categoriaArticulo.getId() == null || categoriaArticulo.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando categoria de articulo ({0})", this.getClass().getSimpleName());
                categoriaArticulo.setEstado(1);
                categoriaArticuloServicio.insertar(categoriaArticulo);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos de la categoria de articulo ({0})", this.getClass().getSimpleName());
                categoriaArticuloServicio.modificar(categoriaArticulo);
            }

            listar();

            categoriaArticulo = new CategoriaArticulo();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar categoria de articulo ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaCategoriaArticulos = categoriaArticuloServicio.listarTodo(CategoriaArticulo.class);
    }

    public void seleccionar(CategoriaArticulo categoriaArticulo) {

        LOGGER.log(Level.INFO, "Seleccionando categoria de articulo ({0})", this.getClass().getSimpleName());
        this.categoriaArticulo = categoriaArticulo;
    }

    public void eliminar(CategoriaArticulo categoriaArticulo) {

        LOGGER.log(Level.INFO, "Eliminando categoria de articulo ({0})", this.getClass().getSimpleName());

        try {

            categoriaArticuloServicio.eliminar(categoriaArticulo.getId(), CategoriaArticulo.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar categoria de articulo ({0})", this.getClass().getSimpleName());
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
