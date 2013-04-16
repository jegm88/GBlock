/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.Utilidad;

import co.com.gblock.services.InterfaceServicios.IBodegaServicio;
import co.com.gblock.services.InterfaceServicios.ICategoriaArticuloServicio;
import co.com.gblock.services.InterfaceServicios.IFormaPagoServicio;
import co.com.gblock.services.InterfaceServicios.IPerfilServicio;
import co.com.gblock.services.InterfaceServicios.ITipoTerceroServicio;
import co.com.gblock.services.InterfaceServicios.IUsuarioServicio;
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
public class RegistroDeUtilidad {
    private static final Logger LOGGER = Logger.getLogger("RegistroDeUtilidad");
    
    @EJB private IBodegaServicio bodegaServicio;
    @EJB private IPerfilServicio perfilServicio;
    @EJB private IFormaPagoServicio formaPagoServicio;
    @EJB private ITipoTerceroServicio tipoTerceroServicio;
    @EJB private ICategoriaArticuloServicio categoriaArticuloServicio;
    @EJB private IUsuarioServicio usuarioServicio;
    
    @PostConstruct
    private void init(){
        LOGGER.log(Level.INFO, "Inicio del metodo init");
        Usuario usuario = new Usuario("fgulfo", "flavio");
        Bodega bodega = new Bodega(1, "Principal", "", "Av. Pedro Heredia", 1);
        Perfil perfil = new Perfil(1, "Admnistrador", "Acceso a todo el sistema", 1);
        FormaPago formaPago = new FormaPago(1, "Efectivo", "dinero a la mano ", 1);
        TipoTercero tipoTercero = new TipoTercero(1, "Cliente", "Posible comparador de productos", 1);
        CategoriaArticulo categoriaArticulo = new CategoriaArticulo(1, "Amortiguador", "", 1);
        
        try{
            usuarioServicio.insertar(usuario);
            bodegaServicio.insertar(bodega);
            perfilServicio.insertar(perfil);
            formaPagoServicio.insertar(formaPago);
            tipoTerceroServicio.insertar(tipoTercero);
            categoriaArticuloServicio.insertar(categoriaArticulo);
            
        }catch(Exception ex){
            LOGGER.log(Level.INFO, "Registro realizado");
        }
    }
    
}
