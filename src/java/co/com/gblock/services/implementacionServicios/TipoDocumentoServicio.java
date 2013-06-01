/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.ITipoDocumentoServicio;
import co.com.gblock.entity.TipoDocumento;
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
public class TipoDocumentoServicio extends GenericaServicio<TipoDocumento, Integer> implements ITipoDocumentoServicio{
    private static final Logger LOGGER = Logger.getLogger("TipoDocumentoServicio");

    @Override
    public TipoDocumento consultarPorNombre(String nombre) {
        LOGGER.log(Level.INFO, "Ejecutando metodo consultar por nombre({0})", this.getClass().getSimpleName());
        TypedQuery<TipoDocumento> query = entityManager.createNamedQuery("TipoDocumento.buscarPorNombre", TipoDocumento.class);
        query.setParameter("nombre", nombre);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<TipoDocumento> listarHabilitados() {
        LOGGER.log(Level.INFO, "Ejecutando metodo listar habilitados ({0})", this.getClass().getSimpleName());
        TypedQuery<TipoDocumento> query = entityManager.createNamedQuery("TipoDocumento.listarHabilitados", TipoDocumento.class);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
