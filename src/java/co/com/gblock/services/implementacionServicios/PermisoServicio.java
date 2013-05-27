/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.implementacionServicios;

import co.com.gblock.services.interfaceServicios.IPermisoServicio;
import co.com.gblock.entity.Permiso;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author FGulfo
 */
@Stateless
public class PermisoServicio extends GenericaServicio<Permiso, Integer> implements IPermisoServicio {
    private static final Logger LOGGER = Logger.getLogger("PermisoServicio");
}
