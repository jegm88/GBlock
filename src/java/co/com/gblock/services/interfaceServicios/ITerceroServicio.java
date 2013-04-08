/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Tercero;
import javax.ejb.Local;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="ITerceroServicio")
@Local
public interface ITerceroServicio extends IGenericaServicio<Tercero, Long> {
    
}
