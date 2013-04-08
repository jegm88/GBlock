/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.ICarteraServicio;
import co.com.gblock.entity.Cartera;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author Jhonny
 */
@Stateless
@WebService(endpointInterface="co.com.gblock.InterfaceServicios.ICarteraServicio")
public class CarteraServicio extends GenericaServicio<Cartera, Long> implements ICarteraServicio{
    
}
