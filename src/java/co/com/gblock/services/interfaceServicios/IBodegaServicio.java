/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Bodega;
import javax.ejb.Local;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IBodegaServicio")
@Local
public interface IBodegaServicio extends IGenericaServicio<Bodega, Integer> {
    
}
