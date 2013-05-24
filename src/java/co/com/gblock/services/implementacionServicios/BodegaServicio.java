/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IBodegaServicio;
import co.com.gblock.entity.Bodega;
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
public class BodegaServicio extends GenericaServicio<Bodega, Integer> implements IBodegaServicio {
    private static final Logger LOGGER = Logger.getLogger("BodegaServicio");

    @Override
    public Bodega consultarPorNombre(String nombre) {
        LOGGER.log(Level.INFO, "Ejecutando metodo consultar por nombre({0})", this.getClass().getSimpleName());
        TypedQuery<Bodega> query = entityManager.createNamedQuery("Bodega.buscarPorNombre", Bodega.class);
        query.setParameter("nombre", nombre);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Bodega> listarHabilitados() {
        LOGGER.log(Level.INFO, "Ejecutando metodo listar habilitados ({0})", this.getClass().getSimpleName());
        TypedQuery<Bodega> query = entityManager.createNamedQuery("Bodega.listarHabilitados", Bodega.class);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
