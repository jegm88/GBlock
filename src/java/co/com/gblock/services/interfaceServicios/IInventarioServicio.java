/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.InterfaceServicios;

import co.com.gblock.entity.Inventario;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IInventarioServicio")
public interface IInventarioServicio extends IGenericaServicio<Inventario, Integer> {
    
}
