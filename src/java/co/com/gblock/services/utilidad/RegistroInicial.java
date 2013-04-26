/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.utilidad;

import co.com.gblock.services.interfaceServicios.IBodegaServicio;
import co.com.gblock.services.interfaceServicios.ICategoriaArticuloServicio;
import co.com.gblock.services.interfaceServicios.IFormaPagoServicio;
import co.com.gblock.services.interfaceServicios.IPerfilServicio;
import co.com.gblock.services.interfaceServicios.ITipoTerceroServicio;
import co.com.gblock.services.interfaceServicios.IUsuarioServicio;
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
public class RegistroInicial {
    private static final Logger LOGGER = Logger.getLogger("RegistroDeUtilidad");
    
    @EJB private IBodegaServicio bodegaServicio;
    @EJB private IPerfilServicio perfilServicio;
    @EJB private IFormaPagoServicio formaPagoServicio;
    @EJB private ITipoTerceroServicio tipoTerceroServicio;
    @EJB private ICategoriaArticuloServicio categoriaArticuloServicio;
    @EJB private IUsuarioServicio usuarioServicio;
    
    @PostConstruct
    private void init(){
        LOGGER.log(Level.INFO, "Inicio del metodo init ({0})", this.getClass().getSimpleName());
        Usuario usuario = new Usuario("fgulfo", "flavio");
        Bodega bodega = new Bodega("Principal", "", "Av. Pedro Heredia", 1);
        Perfil perfil = new Perfil("Admnistrador", "Acceso a todo el sistema", 1);
        FormaPago formaPago = new FormaPago("Efectivo", "dinero a la mano ", 1);
        TipoTercero tipoTercero = new TipoTercero("Cliente", "Posible comparador de productos", 1);
        CategoriaArticulo categoriaArticulo = new CategoriaArticulo("Amortiguador", "", 1);
        
        try{
            usuarioServicio.insertar(usuario);
            bodegaServicio.insertar(bodega);
            perfilServicio.insertar(perfil);
            formaPagoServicio.insertar(formaPago);
            tipoTerceroServicio.insertar(tipoTercero);
            categoriaArticuloServicio.insertar(categoriaArticulo);
            
        }catch(Exception ex){
            LOGGER.log(Level.INFO, "Error al realizar el registro inicial ({0})", this.getClass().getSimpleName());
        }
    }
    
}
