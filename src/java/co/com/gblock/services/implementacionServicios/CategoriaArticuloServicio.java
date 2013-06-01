/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.entity.Articulo;
import co.com.gblock.services.interfaceServicios.ICategoriaArticuloServicio;
import co.com.gblock.entity.CategoriaArticulo;
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
public class CategoriaArticuloServicio extends GenericaServicio<CategoriaArticulo, Integer> implements ICategoriaArticuloServicio{
    private static final Logger LOGGER = Logger.getLogger("CategoriaArticuloServicio");
    
    @Override
    public CategoriaArticulo consultarPorNombre(String nombre) {
        LOGGER.log(Level.INFO, "Ejecutando metodo consultar por nombre({0})", this.getClass().getSimpleName());
        TypedQuery<CategoriaArticulo> query = entityManager.createNamedQuery("CategoriaArticulo.buscarPorNombre", CategoriaArticulo.class);
        query.setParameter("nombre", nombre);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<CategoriaArticulo> listarHabilitados() {
        LOGGER.log(Level.INFO, "Ejecutando metodo listar habilitados ({0})", this.getClass().getSimpleName());
        TypedQuery<CategoriaArticulo> query = entityManager.createNamedQuery("CategoriaArticulo.listarHabilitados", CategoriaArticulo.class);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
