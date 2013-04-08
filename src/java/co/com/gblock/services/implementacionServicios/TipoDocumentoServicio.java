/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.ITipoDocumentoServicio;
import co.com.gblock.entity.TipoDocumento;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.ITipoDocumentoServicio")
public class TipoDocumentoServicio extends GenericaServicio<TipoDocumento, Integer> implements ITipoDocumentoServicio{
    
}
