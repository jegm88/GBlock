/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IArqueoServicio;
import co.com.gblock.entity.Arqueo;
import javax.ejb.Stateless;

/**
 *
 * @author FGulfo
 */
@Stateless
public class ArqueoServicio extends GenericaServicio<Arqueo, Long> implements IArqueoServicio{
    
}
