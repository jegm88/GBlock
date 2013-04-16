/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.InterfaceServicios;

import co.com.gblock.entity.Articulo;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IArticuloServicio")
public interface IArticuloServicio extends IGenericaServicio<Articulo, Long> {
    
}
