/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Inventario;
import javax.ejb.Local;

/**
 *
 * @author FGulfo
 */
@Local
public interface IInventarioServicio extends IGenericaServicio<Inventario, Integer> {
    
}
