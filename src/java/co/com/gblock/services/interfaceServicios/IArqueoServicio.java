/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Arqueo;
import javax.ejb.Local;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IArqueoServicio")
@Local
public interface IArqueoServicio extends IGenericaServicio<Arqueo, Long> {
    
}
