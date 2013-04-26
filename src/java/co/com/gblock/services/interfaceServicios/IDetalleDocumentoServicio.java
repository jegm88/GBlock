/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.DetalleDocumento;
import javax.ejb.Local;

/**
 *
 * @author FGulfo
 */
@Local
public interface IDetalleDocumentoServicio extends IGenericaServicio<DetalleDocumento, Long> {
    
}
