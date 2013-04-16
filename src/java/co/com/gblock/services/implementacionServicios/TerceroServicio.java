/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.ImplementacionServicios;

import co.com.gblock.services.InterfaceServicios.ITerceroServicio;
import co.com.gblock.entity.Tercero;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.ITerceroServicio")
public class TerceroServicio extends GenericaServicio<Tercero, String> implements ITerceroServicio{
    
}
