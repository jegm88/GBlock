/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.InterfaceServicios;

import co.com.gblock.entity.TipoDocumento;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="ITipoDocumentoServicio")
public interface ITipoDocumentoServicio extends IGenericaServicio<TipoDocumento, Integer> {
    
}
