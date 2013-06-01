/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IArticuloServicio;
import co.com.gblock.entity.Articulo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author FGulfo
 */
@Stateless
public class ArticuloServicio extends GenericaServicio<Articulo, Long> implements IArticuloServicio{
    private static final Logger LOGGER = Logger.getLogger("CategoriaArticuloServicio");
    
    @Override
    public Articulo consultarPorNombre(String nombre) {
        LOGGER.log(Level.INFO, "Ejecutando metodo consultar por nombre({0})", this.getClass().getSimpleName());
        TypedQuery<Articulo> query = entityManager.createNamedQuery("Articulo.buscarPorNombre", Articulo.class);
        query.setParameter("nombre", nombre);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Articulo> listarHabilitados() {
        LOGGER.log(Level.INFO, "Ejecutando metodo listar habilitados ({0})", this.getClass().getSimpleName());
        TypedQuery<Articulo> query = entityManager.createNamedQuery("Articulo.listarHabilitados", Articulo.class);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    @Override
    public List<Articulo> listarArticulo(String categoria) {
       LOGGER.log(Level.INFO, "Ejecutando metodo listar habilitados ({0})", this.getClass().getSimpleName());
        TypedQuery<Articulo> query = entityManager.createNamedQuery("Articulo.listarArticulo", Articulo.class);
        query.setParameter("categoria", categoria);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
