/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IPerfilServicio;
import co.com.gblock.entity.Perfil;
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
public class PerfilServicio extends GenericaServicio<Perfil, Integer> implements IPerfilServicio {

    private static final Logger LOGGER = Logger.getLogger("PerfilServicio");

    @Override
    public List<Perfil> listarHabilitados() {
        LOGGER.log(Level.INFO, "Ejecutando metodo listar habilitados ({0})", this.getClass().getSimpleName());
        TypedQuery<Perfil> query = entityManager.createNamedQuery("Perfil.listarHabilitados", Perfil.class);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
