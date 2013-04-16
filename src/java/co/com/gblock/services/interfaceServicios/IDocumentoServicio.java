/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.InterfaceServicios;

import co.com.gblock.entity.Documento;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IDocumentoServicio")
public interface IDocumentoServicio extends IGenericaServicio<Documento, Long> {
    
}
