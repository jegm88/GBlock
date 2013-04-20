/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IFormaPagoServicio;
import co.com.gblock.entity.FormaPago;
import javax.ejb.Stateless;

/**
 *
 * @author FGulfo
 */
@Stateless
public class FormaPagoServicio extends GenericaServicio<FormaPago, Integer> implements IFormaPagoServicio{
    
}
