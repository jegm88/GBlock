/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Documento;
import javax.ejb.Local;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="IDocumentoServicio")
@Local
public interface IDocumentoServicio extends IGenericaServicio<Documento, Long> {
    
}
