/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.ITelefonoServicio;
import co.com.gblock.entity.Telefono;
import co.com.gblock.entity.Tercero;
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
public class TelefonoServicio extends GenericaServicio<Telefono, Long> implements ITelefonoServicio {

    private static final Logger LOGGER = Logger.getLogger("TelefonoServicio");
    
    @Override
    public List<Telefono> consultarPorTercero(Tercero t) {
        LOGGER.log(Level.INFO, "Ejecutando metodo consultar por tercero ({0})", this.getClass().getSimpleName());
        TypedQuery<Telefono> query = entityManager.createNamedQuery("Telefono.consultarPorTercero", Telefono.class);
        query.setParameter("tercero", t);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
