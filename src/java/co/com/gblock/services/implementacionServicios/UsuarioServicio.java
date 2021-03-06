/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.entity.Usuario;
import co.com.gblock.services.interfaceServicios.IUsuarioServicio;
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
public class UsuarioServicio extends GenericaServicio<Usuario, Integer> implements IUsuarioServicio {

    private static final Logger LOGGER = Logger.getLogger("UsuarioServicio");

    @Override
    public Usuario login(Usuario usuario) {

        TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.login", Usuario.class);
        query.setParameter("nick", usuario.getNick());
        query.setParameter("password", usuario.getPassword());

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.WARNING, "Usuario no existe");
            return null;
        }
    }

    @Override
    public Usuario consultarPorNick(String nick) {

        TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.consultarPorNick", Usuario.class);
        query.setParameter("nick", nick);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.WARNING, "Usuario no existe");
            return null;
        }
    }

    @Override
    public List<Usuario> listarHabilitados() {
        LOGGER.log(Level.INFO, "Ejecutando metodo listar habilitados ({0})", this.getClass().getSimpleName());
        TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.listarHabilitados", Usuario.class);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
