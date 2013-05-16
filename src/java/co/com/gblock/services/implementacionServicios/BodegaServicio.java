/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IBodegaServicio;
import co.com.gblock.entity.Bodega;
import javax.ejb.Stateless;

/**
 *
 * @author FGulfo
 */
@Stateless
public class BodegaServicio extends GenericaServicio<Bodega, Integer> implements IBodegaServicio{
    
}
