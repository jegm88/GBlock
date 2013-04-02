/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ImplementacionServicios;

import co.com.gblock.InterfaceServicios.ITerceroServicio;
import co.com.gblock.entity.Tercero;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.ITerceroServicio")
public class TerceroServicio extends GenericaServicio<Tercero, Integer> implements ITerceroServicio{
    
}