/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.ImplementacionServicios;

import co.com.gblock.services.InterfaceServicios.ITelefonoServicio;
import co.com.gblock.entity.Telefono;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.ITelefonoServicio")
public class TelefonoServicio extends GenericaServicio<Telefono, String> implements ITelefonoServicio{
    
}
