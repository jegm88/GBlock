/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.entity.Correo;
import co.com.gblock.entity.Tercero;
import co.com.gblock.services.interfaceServicios.ICorreoServicio;
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
public class CorreoServicio extends GenericaServicio<Correo, Long> implements ICorreoServicio {

    private static final Logger LOGGER = Logger.getLogger("CorreoServicio");

    @Override
    public List<Correo> consultarPorTercero(Tercero t) {
        LOGGER.log(Level.INFO, "Ejecutando metodo consultar por tercero ({0})", this.getClass().getSimpleName());
        TypedQuery<Correo> query = entityManager.createNamedQuery("Correo.consultarPorTercero", Correo.class);
        query.setParameter("tercero", t);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
