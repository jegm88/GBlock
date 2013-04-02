/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.InterfaceServicios;

import co.com.gblock.entity.Tercero;
import javax.jws.WebService;

/**
 *
 * @author FGulfo
 */
@WebService(name="ITerceroServicio")
public interface ITerceroServicio extends IGenericaServicio<Tercero, Integer> {
    
}
