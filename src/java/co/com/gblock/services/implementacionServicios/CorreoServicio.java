/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.ICorreoServicio;
import co.com.gblock.entity.Correo;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.ICorreoServicio")
public class CorreoServicio extends GenericaServicio<Correo, Long> implements ICorreoServicio{
    
}
