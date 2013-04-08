/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Telefono;
import javax.ejb.Local;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="ITelefonoServicio")
@Local
public interface ITelefonoServicio extends IGenericaServicio<Telefono, Long> {
    
}
