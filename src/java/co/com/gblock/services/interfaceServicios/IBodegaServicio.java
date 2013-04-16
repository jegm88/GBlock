/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.InterfaceServicios;

import co.com.gblock.entity.Bodega;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IBodegaServicio")
public interface IBodegaServicio extends IGenericaServicio<Bodega, Integer> {
    
}
