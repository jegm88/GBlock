/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ImplementacionServicios;

import co.com.gblock.InterfaceServicios.ICorreoServicio;
import co.com.gblock.entity.Correo;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.ICorreoServicio")
public class CorreoServicio extends GenericaServicio<Correo, Integer> implements ICorreoServicio{
    
}
