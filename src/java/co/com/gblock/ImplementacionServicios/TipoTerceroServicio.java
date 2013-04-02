/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ImplementacionServicios;

import co.com.gblock.InterfaceServicios.ITipoTerceroServicio;
import co.com.gblock.entity.TipoTercero;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.ITipoTerceroServicio")
public class TipoTerceroServicio extends GenericaServicio<TipoTercero, Integer> implements ITipoTerceroServicio{
    
}
