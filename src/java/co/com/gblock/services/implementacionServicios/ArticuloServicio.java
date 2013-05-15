/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IArticuloServicio;
import co.com.gblock.entity.Articulo;
import javax.ejb.Stateless;

/**
 *
 * @author FGulfo
 */
@Stateless
public class ArticuloServicio extends GenericaServicio<Articulo, Long> implements IArticuloServicio{
    
}
