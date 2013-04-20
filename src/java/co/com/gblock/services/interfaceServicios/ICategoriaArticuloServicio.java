/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.CategoriaArticulo;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="ICategoriaArticuloServicio")
public interface ICategoriaArticuloServicio extends IGenericaServicio<CategoriaArticulo, Integer> {
    
}
