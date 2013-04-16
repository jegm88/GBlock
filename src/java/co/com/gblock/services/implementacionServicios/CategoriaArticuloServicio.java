/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.ImplementacionServicios;

import co.com.gblock.services.InterfaceServicios.ICategoriaArticuloServicio;
import co.com.gblock.entity.CategoriaArticulo;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.ICategoriaArticuloServicio")
public class CategoriaArticuloServicio extends GenericaServicio<CategoriaArticulo, Integer> implements ICategoriaArticuloServicio{
    
}
