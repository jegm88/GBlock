/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Bodega;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FGulfo
 */
@Local
public interface IBodegaServicio extends IGenericaServicio<Bodega, Integer> {

    Bodega consultarPorNombre(String nombre);

    List<Bodega> listarHabilitados();
}
