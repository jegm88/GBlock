/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IInventarioServicio;
import co.com.gblock.entity.Inventario;
import javax.ejb.Stateless;

/**
 *
 * @author FGulfo
 */
@Stateless
public class InventarioServicio extends GenericaServicio<Inventario, Integer> implements IInventarioServicio{
    
}
