/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.InterfaceServicios;

import co.com.gblock.entity.Telefono;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="ITelefonoServicio")
public interface ITelefonoServicio extends IGenericaServicio<Telefono, String> {
    
}
