/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.ImplementacionServicios;

import co.com.gblock.services.InterfaceServicios.IArqueoServicio;
import co.com.gblock.entity.Arqueo;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.IArqueoServicio")
public class ArqueoServicio extends GenericaServicio<Arqueo, Long> implements IArqueoServicio{
    
}
