/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.TipoDocumento;
import javax.ejb.Local;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="ITipoDocumentoServicio")
@Local
public interface ITipoDocumentoServicio extends IGenericaServicio<TipoDocumento, Integer> {
    
}
