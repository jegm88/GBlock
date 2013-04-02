/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ImplementacionServicios;

import co.com.gblock.InterfaceServicios.IBodegaServicio;
import co.com.gblock.entity.Bodega;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.IBodegaServicio")
public class BodegaServicio extends GenericaServicio<Bodega, Integer> implements IBodegaServicio{
    
}
