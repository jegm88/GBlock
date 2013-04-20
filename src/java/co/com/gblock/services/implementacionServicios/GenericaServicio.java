/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IGenericaServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author FGulfo
 */
public abstract class GenericaServicio<Entity, Key> implements IGenericaServicio<Entity, Key> {

    private static final Logger logger = Logger.getLogger("GenericaServicio");
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void insertar(Entity obj) {
        logger.log(Level.INFO, "Ejecutando metodo insetar ({0})", obj.getClass().getSimpleName());
        entityManager.persist(obj);
    }

    @Override
    public Entity consultarPorId(Key id, Class<Entity> clazz) {
        logger.log(Level.INFO, "Ejecutando metodo consultar por id ({0})", clazz.getSimpleName());
        return entityManager.find(clazz, id);
    }

    @Override
    public void modificar(Entity obj) {
        logger.log(Level.INFO, "Ejecutando metodo modificar ({0})", obj.getClass().getSimpleName());
        entityManager.merge(obj);
    }

    @Override
    public void eliminar(Key id, Class clazz) {
        logger.log(Level.INFO, "Ejecutando metodo eliminar ({0})", clazz.getSimpleName());
        Entity entity = (Entity) entityManager.getReference(clazz, id);
        entityManager.remove(entity);
    }

    @Override
    public List<Entity> listarTodo(Class clazz) {
        List<Entity> entities;
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT o FROM ");
        jpql.append(clazz.getSimpleName());
        jpql.append("o");
        logger.log(Level.INFO, "Listando todas las entidades ({0})", clazz.getSimpleName());
        Query query = entityManager.createQuery(jpql.toString());
        entities = query.getResultList();
        return entities;
    }
}
