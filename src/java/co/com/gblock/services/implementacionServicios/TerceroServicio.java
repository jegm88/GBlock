/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.ITerceroServicio;
import co.com.gblock.entity.Tercero;
import javax.ejb.Stateless;

/**
 *
 * @author FGulfo
 */
@Stateless
public class TerceroServicio extends GenericaServicio<Tercero, Long> implements ITerceroServicio{
    
}
