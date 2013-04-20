/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.ICorreoServicio;
import co.com.gblock.entity.Correo;
import javax.ejb.Stateless;

/**
 *
 * @author FGulfo
 */
@Stateless
public class CorreoServicio extends GenericaServicio<Correo, String> implements ICorreoServicio{
    
}
