/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.InterfaceServicios;

import co.com.gblock.entity.Perfil;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IPerfilServicio")
public interface IPerfilServicio extends IGenericaServicio<Perfil, Integer> {
    
}
