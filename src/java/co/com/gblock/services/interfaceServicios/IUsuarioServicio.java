/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FGulfo
 */
@Local
public interface IUsuarioServicio extends IGenericaServicio<Usuario, Integer> {

    Usuario login(Usuario usuario);

    Usuario consultarPorNick(String nick);

    List<Usuario> listarHabilitados();
}
