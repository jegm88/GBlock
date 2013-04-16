/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.ImplementacionServicios;

import co.com.gblock.services.InterfaceServicios.IDocumentoServicio;
import co.com.gblock.entity.Documento;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.IDocumentoServicio")
public class VentaServicio extends GenericaServicio<Documento, Long> implements IDocumentoServicio{
    
}
