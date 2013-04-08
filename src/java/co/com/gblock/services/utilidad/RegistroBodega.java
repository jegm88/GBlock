/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.utilidad;

import co.com.gblock.services.interfaceServicios.IBodegaServicio;
import co.com.gblock.entity.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author FGulfo
 */
@Singleton
@Startup
public class RegistroBodega {
    private static final Logger LOGGER = Logger.getLogger("RegistroBodega");
    
    @EJB
    private IBodegaServicio bodegaServicio;
    
    @PostConstruct
    private void init(){
        
        //Creacion de bodega e insercion de bodega en la BD.
        Bodega bodega = new Bodega(1, "Bodega Principal", "", "Av. Pedro Heredia", 1);
        try{
            bodegaServicio.insertar(bodega);
        }catch(Exception ex){
            LOGGER.log(Level.INFO, "¡Bodega ya registrada!");
        }
    }
    
}
