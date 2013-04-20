/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Usuario;
import javax.ejb.Local;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Local
@WebService(name="IUsuarioServicio")
public interface IUsuarioServicio extends IGenericaServicio<Usuario, Integer> {
    
    Usuario login(Usuario usuario);
}
