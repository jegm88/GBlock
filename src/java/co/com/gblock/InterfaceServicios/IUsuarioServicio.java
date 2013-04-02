/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.InterfaceServicios;

import co.com.gblock.entity.Usuario;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IUsuarioServicio")
public interface IUsuarioServicio extends IGenericaServicio<Usuario, Integer> {
    
}
