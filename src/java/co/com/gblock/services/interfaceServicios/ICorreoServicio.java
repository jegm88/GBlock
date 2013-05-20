/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Correo;
import co.com.gblock.entity.Tercero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FGulfo
 */
@Local
public interface ICorreoServicio extends IGenericaServicio<Correo, Long> {
        public List<Correo> consultarPorTercero(Tercero t);
}
