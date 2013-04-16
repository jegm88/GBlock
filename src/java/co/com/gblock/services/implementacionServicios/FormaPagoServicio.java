/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.ImplementacionServicios;

import co.com.gblock.services.InterfaceServicios.IFormaPagoServicio;
import co.com.gblock.entity.FormaPago;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.IFormaPagoServicio")
public class FormaPagoServicio extends GenericaServicio<FormaPago, Integer> implements IFormaPagoServicio{
    
}
