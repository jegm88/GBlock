/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Articulo;
import co.com.gblock.entity.CategoriaArticulo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FGulfo
 */
@Local
public interface ICategoriaArticuloServicio extends IGenericaServicio<CategoriaArticulo, Integer> {
    
    CategoriaArticulo consultarPorNombre(String nombre);

    List<CategoriaArticulo> listarHabilitados();
}
