/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.TipoTercero;
import javax.ejb.Local;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="ITipoTerceroServicio")
@Local
public interface ITipoTerceroServicio extends IGenericaServicio<TipoTercero, Integer> {
    
}
