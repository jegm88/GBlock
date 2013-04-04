/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ImplementacionServicios;

import co.com.gblock.InterfaceServicios.IDetalleDocumentoServicio;
import co.com.gblock.entity.DetalleDocumento;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.IDetalleDocumentoServicio")
public class DetalleDocumentoServicio extends GenericaServicio<DetalleDocumento, Long> implements IDetalleDocumentoServicio{
    
}
