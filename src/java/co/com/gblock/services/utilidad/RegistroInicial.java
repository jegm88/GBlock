/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.utilidad;

import co.com.gblock.services.interfaceServicios.IBodegaServicio;
import co.com.gblock.services.interfaceServicios.ICategoriaArticuloServicio;
import co.com.gblock.services.interfaceServicios.IFormaPagoServicio;
import co.com.gblock.services.interfaceServicios.IPerfilServicio;
import co.com.gblock.services.interfaceServicios.IUsuarioServicio;
import co.com.gblock.entity.*;
import co.com.gblock.services.interfaceServicios.IArticuloServicio;
import co.com.gblock.services.interfaceServicios.IPermisoServicio;
import co.com.gblock.services.interfaceServicios.ITerceroServicio;
import co.com.gblock.services.interfaceServicios.ITipoDocumentoServicio;
import java.util.ArrayList;
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
    @EJB
    private IBodegaServicio bodegaServicio;
    @EJB
    private IPerfilServicio perfilServicio;
    @EJB
    private IPermisoServicio permisoServicio;
    @EJB
    private IFormaPagoServicio formaPagoServicio;
    @EJB
    private ITerceroServicio terceroServicio;
    @EJB
    private ITipoDocumentoServicio tipoDocumentoServicio;
    @EJB
    private ICategoriaArticuloServicio categoriaArticuloServicio;
    @EJB
    private IArticuloServicio articuloServicio;
    @EJB
    private IUsuarioServicio usuarioServicio;

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Inicio del metodo init ({0})", this.getClass().getSimpleName());

        //<editor-fold defaultstate="collapsed" desc="Definicion de permisos">
        Permiso p1 = new Permiso("AC", "Acceso a Compra", 1);
        Permiso p2 = new Permiso("CC", "Crear Compra", 1);
        Permiso p3 = new Permiso("MC", "Modificar Compra", 1);
        Permiso p4 = new Permiso("EC", "Eliminar Compra", 1);
        Permiso p5 = new Permiso("IC", "Imprimir Compra", 1);
        Permiso p6 = new Permiso("RC", "Reportar Compra", 1);

        Permiso p7 = new Permiso("AV", "Acceso a venta", 1);
        Permiso p8 = new Permiso("CV", "Crear venta", 1);
        Permiso p9 = new Permiso("MV", "Modificar venta", 1);
        Permiso p10 = new Permiso("EV", "Eliminar venta", 1);
        Permiso p11 = new Permiso("IV", "Imprimir venta", 1);
        Permiso p12 = new Permiso("RV", "Reportar venta", 1);

        Permiso p13 = new Permiso("AB", "Acceso a Bodega", 1);
        Permiso p14 = new Permiso("CB", "Crear Bodega", 1);
        Permiso p15 = new Permiso("MB", "Modificar Bodega", 1);
        Permiso p16 = new Permiso("EB", "Eliminar Bodega", 1);

        Permiso p17 = new Permiso("AU", "Acceso a Usuario", 1);
        Permiso p18 = new Permiso("CU", "Crear Usuairo", 1);
        Permiso p19 = new Permiso("MU", "Modificar Usuario", 1);
        Permiso p20 = new Permiso("EU", "Eliminar Usuario", 1);

        Permiso p21 = new Permiso("AT", "Acceso a Tercero", 1);
        Permiso p22 = new Permiso("CT", "Crear Tercero", 1);
        Permiso p23 = new Permiso("MT", "Modificar Tercero", 1);
        Permiso p24 = new Permiso("ET", "Eliminar Tercero", 1);
        
        Permiso p25 = new Permiso("AA", "Acceso a Articulo", 1);
        Permiso p26 = new Permiso("CA", "Crear Articulo", 1);
        Permiso p27 = new Permiso("MA", "Modificar Articulo", 1);
        Permiso p28 = new Permiso("EA", "Eliminar Articulo", 1);

        Permiso p29 = new Permiso("ACA", "Acceso a Categoria Articulo", 1);
        Permiso p30 = new Permiso("CCA", "Crear Categoria Articulo", 1);
        Permiso p31 = new Permiso("MCA", "Modificar Categoria Articulo", 1);
        Permiso p32 = new Permiso("ECA", "Eliminar Categoria Articulo", 1);
        
        Permiso p33 = new Permiso("AR", "Acceso a Reportes", 1);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Permisos Administrador por defecto">
        ArrayList<Permiso> perAdmin = new ArrayList<Permiso>();
        perAdmin.add(p1);
        perAdmin.add(p2);
        perAdmin.add(p3);
        perAdmin.add(p4);
        perAdmin.add(p5);
        perAdmin.add(p7);
        perAdmin.add(p8);
        perAdmin.add(p9);
        perAdmin.add(p10);
        perAdmin.add(p11);
        perAdmin.add(p13);
        perAdmin.add(p14);
        perAdmin.add(p15);
        perAdmin.add(p16);
        perAdmin.add(p17);
        perAdmin.add(p18);
        perAdmin.add(p19);
        perAdmin.add(p20);
        perAdmin.add(p21);
        perAdmin.add(p22);
        perAdmin.add(p23);
        perAdmin.add(p24);
        perAdmin.add(p25);
        perAdmin.add(p26);
        perAdmin.add(p27);
        perAdmin.add(p28);
        perAdmin.add(p29);
        perAdmin.add(p30);
        perAdmin.add(p31);
        perAdmin.add(p32);
        perAdmin.add(p33);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Permisos Vendedor por defecto">
        ArrayList<Permiso> perVendedor = new ArrayList<Permiso>();
        perVendedor.add(p7);
        perVendedor.add(p8);
        perVendedor.add(p11);
        perVendedor.add(p12);
        perVendedor.add(p21);
        perVendedor.add(p22);
        perVendedor.add(p23);
        perVendedor.add(p24);
        perVendedor.add(p25);
        perVendedor.add(p26);
        perVendedor.add(p27);
        perVendedor.add(p28);
        perVendedor.add(p29);
        perVendedor.add(p30);
        perVendedor.add(p31);
        perVendedor.add(p32);
        //</editor-fold>

        Perfil perfil1 = new Perfil("Admnistrador", "Acceso a todo el sistema", 1);
        perfil1.setPermisos(perAdmin);
        Perfil perfil2 = new Perfil("Vendedor", "Acceso solo a ventas y consultas", 1);
        perfil2.setPermisos(perVendedor);

        Usuario usuario1 = new Usuario("fgulfo", "flavio", null, perfil2, 1);
        Usuario usuario2 = new Usuario("admin", "admin", null, perfil1, 1);

        Bodega bodega = new Bodega("Principal", "", "", 1);

        TipoDocumento tipo1 = new TipoDocumento("Venta", "Venta de Articulo", Long.valueOf(0), "FCT#", -1, 1);
        TipoDocumento tipo2 = new TipoDocumento("Compra", "Compra de Articulo", Long.valueOf(0), "#", 1, 1);

        FormaPago formaPago = new FormaPago("Efectivo", "Dinero en efectivo", 1);

        Tercero dueno = new Tercero("0001", "nit", 1, "GBlock", "Inc", "Cartagena", TipoTercero.DUEÑO, 1);

        CategoriaArticulo categoriaArticulo = new CategoriaArticulo("Amortiguador", "", 1);
        Articulo art = new Articulo("Amortiguador01", "Amortiguador para vehiculos carga", "suzuki", "rtp102", 120000.0, 16.0F, 19200.0, categoriaArticulo, null, 1);

        try {

            //<editor-fold defaultstate="collapsed" desc="Registro de perrmisos">
//            permisoServicio.insertar(p1);
//            permisoServicio.insertar(p2);
//            permisoServicio.insertar(p3);
//            permisoServicio.insertar(p4);
//            permisoServicio.insertar(p5);
//            permisoServicio.insertar(p6);
//            permisoServicio.insertar(p7);
//            permisoServicio.insertar(p8);
//            permisoServicio.insertar(p9);
//            permisoServicio.insertar(p10);
//            permisoServicio.insertar(p11);
//            permisoServicio.insertar(p12);
//            permisoServicio.insertar(p13);
//            permisoServicio.insertar(p14);
//            permisoServicio.insertar(p15);
//            permisoServicio.insertar(p16);
//            permisoServicio.insertar(p17);
//            permisoServicio.insertar(p18);
//            permisoServicio.insertar(p19);
//            permisoServicio.insertar(p20);
//            permisoServicio.insertar(p21);
//            permisoServicio.insertar(p22);
//            permisoServicio.insertar(p23);
//            permisoServicio.insertar(p24);
            //</editor-fold>
//
            perfilServicio.insertar(perfil1);
            perfilServicio.insertar(perfil2);

            usuarioServicio.insertar(usuario1);
            usuarioServicio.insertar(usuario2);

            bodegaServicio.insertar(bodega);

            formaPagoServicio.insertar(formaPago);

            tipoDocumentoServicio.insertar(tipo1);
            tipoDocumentoServicio.insertar(tipo2);

            terceroServicio.insertar(dueno);

            categoriaArticuloServicio.insertar(categoriaArticulo);
            articuloServicio.insertar(art);
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, "Error al realizar el registro inicial3 ({0})", this.getClass().getSimpleName());
        }
    }
}
