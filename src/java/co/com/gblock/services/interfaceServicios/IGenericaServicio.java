/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.InterfaceServicios;

import java.util.List;

/**
 *Esta interface es generica, va ser implementada por los servicios y heredada por las interfaces de servicios.
 *Recibe dos parametros.
 *El primero puede ser una entidad, y el otro el identificador de dicha entidad. 
 *Contiene los metodos principales del CRUD.
 * @author FGulfo
 */
public interface IGenericaServicio<Entity, Key> {
    
    void insertar(Entity obj);
    
    Entity consultarPorId(Key id, Class<Entity> clazz);
    
    void modificar(Entity obj);
    
    void elimiinar(Key id, Class clazz);
    
    List<Entity> listarTodo(Class clazz);
}
