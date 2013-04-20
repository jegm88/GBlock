/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.TipoTercero;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="ITipoTerceroServicio")
public interface ITipoTerceroServicio extends IGenericaServicio<TipoTercero, Integer> {
    
}
