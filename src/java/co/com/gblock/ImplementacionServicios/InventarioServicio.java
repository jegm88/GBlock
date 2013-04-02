/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ImplementacionServicios;

import co.com.gblock.InterfaceServicios.IInventarioServicio;
import co.com.gblock.entity.Inventario;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.IInventarioServicio")
public class InventarioServicio extends GenericaServicio<Inventario, Integer> implements IInventarioServicio{
    
}
