/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.interfaceServicios;

import co.com.gblock.entity.Cartera;
import javax.ejb.Local;
import javax.jws.WebService;

/**
 *
 * @author Jhonny
 */
@WebService(name="ICarteraServicio")
@Local
public interface ICarteraServicio extends IGenericaServicio<Cartera, Long> {
    
}