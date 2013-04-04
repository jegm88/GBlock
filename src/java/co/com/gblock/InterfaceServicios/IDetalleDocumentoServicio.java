/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.InterfaceServicios;

import co.com.gblock.entity.DetalleDocumento;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IDetalleDocumentoServicio")
public interface IDetalleDocumentoServicio extends IGenericaServicio<DetalleDocumento, Long> {
    
}
