/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.InterfaceServicios;

import co.com.gblock.entity.FormaPago;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IFormaPagoServicio")
public interface IFormaPagoServicio extends IGenericaServicio<FormaPago, Integer> {
    
}
