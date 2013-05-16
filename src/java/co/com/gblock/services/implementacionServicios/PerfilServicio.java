/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IPerfilServicio;
import co.com.gblock.entity.Perfil;
import javax.ejb.Stateless;

/**
 *
 * @author FGulfo
 */
@Stateless
public class PerfilServicio extends GenericaServicio<Perfil, Integer> implements IPerfilServicio{
    
}
