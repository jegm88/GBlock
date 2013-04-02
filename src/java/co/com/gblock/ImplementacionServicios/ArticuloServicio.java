/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ImplementacionServicios;

import co.com.gblock.InterfaceServicios.IArticuloServicio;
import co.com.gblock.entity.Articulo;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.IArticuloServicio")
public class ArticuloServicio extends GenericaServicio<Articulo, Integer> implements IArticuloServicio{
    
}
