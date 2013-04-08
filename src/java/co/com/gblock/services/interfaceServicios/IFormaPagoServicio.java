/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.FormaPago;
import javax.ejb.Local;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IFormaPagoServicio")
@Local
public interface IFormaPagoServicio extends IGenericaServicio<FormaPago, Integer> {
    
}
