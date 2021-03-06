/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.ITerceroServicio;
import co.com.gblock.entity.Tercero;
import co.com.gblock.services.utilidad.TipoTercero;
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
public class TerceroServicio extends GenericaServicio<Tercero, Long> implements ITerceroServicio {

    private static final Logger LOGGER = Logger.getLogger("TerceroServicio");

    @Override
    public Tercero consultarPorNumeroId(String id) {
        LOGGER.log(Level.INFO, "Ejecutando metodo consultar por id({0})", this.getClass().getSimpleName());
        TypedQuery<Tercero> query = entityManager.createNamedQuery("Tercero.buscarPorNumeroId", Tercero.class);
        query.setParameter("numeroId", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Tercero> listarPorTipo(TipoTercero tipo) {
        LOGGER.log(Level.INFO, "Ejecutando metodo listar por tipo ({0})", this.getClass().getSimpleName());
        TypedQuery<Tercero> query = entityManager.createNamedQuery("Tercero.listarPorTipo", Tercero.class);
        query.setParameter("tipo", tipo);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Tercero> listarHabilitados() {
        LOGGER.log(Level.INFO, "Ejecutando metodo listar habilitados ({0})", this.getClass().getSimpleName());
        TypedQuery<Tercero> query = entityManager.createNamedQuery("Tercero.listarHabilitados", Tercero.class);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
