/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IDocumentoServicio;
import co.com.gblock.entity.Documento;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.IDocumentoServicio")
public class CompraServicio extends GenericaServicio<Documento, Long> implements IDocumentoServicio{
    
}
