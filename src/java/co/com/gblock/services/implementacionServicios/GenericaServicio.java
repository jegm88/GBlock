/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IGenericaServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author FGulfo
 */
@Local
public class GenericaServicio<Entity, Key> implements IGenericaServicio<Entity, Key> {
    
    private static final Logger logger = Logger.getLogger("GenericaServicio");
    
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void insertar(Entity obj) {
        logger.log(Level.INFO, "Ejecutando metodo insetar");
        entityManager.persist(obj);
    }

    @Override
    public Entity consultarPorId(Key id, Class<Entity> clazz) {
        return entityManager.find(clazz, id);
    }

    @Override
    public void modificar(Entity obj) {
        entityManager.merge(obj);
    }

    @Override
    public void elimiinar(Key id, Class clazz) {
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
        logger.log(Level.INFO, "Listando todas las entidades");
        jpql.toString();
        
        Query query = entityManager.createQuery(jpql.toString());
        entities = query.getResultList();
        
        logger.log(Level.FINE, "Listando entidades consultadas");
        
        return entities;
    }
    
}
