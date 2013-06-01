/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Articulo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FGulfo
 */
@Local
public interface IArticuloServicio extends IGenericaServicio<Articulo, Long> {
   
    Articulo consultarPorNombre(String nombre);

    List<Articulo> listarHabilitados();
    
     List<Articulo>listarArticulo(String categoria);
}
