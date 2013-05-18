/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.entity.Documento;
import co.com.gblock.entity.Tercero;
import co.com.gblock.services.utilidad.TipoTercero;
import co.com.gblock.services.implementacionServicios.TerceroServicio;
import co.com.gblock.services.implementacionServicios.TipoDocumentoServicio;
import co.com.gblock.services.implementacionServicios.VentaServicio;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author FGulfo
 */
@ManagedBean
@SessionScoped
public class VentaEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("VentaEBeban");
    @EJB
    private VentaServicio ventaServicio;
    private TerceroServicio terceroServicio;
    private TipoDocumentoServicio tipoDocumentoServicio;
    private Tercero dueno;
    private Documento venta;
    private List<Documento> listaVentas;

    public VentaEBean() {
        venta = prepararVenta();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());
        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando venta ({0})", this.getClass().getSimpleName());

        try {

            if (venta.getId() == null || venta.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando venta ({0})", this.getClass().getSimpleName());
                venta.setEstado(1);
                ventaServicio.insertar(venta);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos de la venta ({0})", this.getClass().getSimpleName());
                ventaServicio.modificar(venta);
            }

            listar();

            venta = new Documento();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar la venta ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando ventas...");

        listaVentas = ventaServicio.listarTodo(Documento.class);
    }

    public void seleccionar(Documento venta) {

        LOGGER.log(Level.INFO, "Seleccionando la venta ({0})", this.getClass().getSimpleName());
        this.venta = venta;
    }

    public void eliminar(Documento venta) {

        LOGGER.log(Level.INFO, "Eliminando la venta ({0})", this.getClass().getSimpleName());

        try {

            ventaServicio.eliminar(venta.getId(), Documento.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar la venta ({0})", this.getClass().getSimpleName());
        }
    }

    private Documento prepararVenta() {
        Documento d = new Documento();
        List<Tercero>lista = terceroServicio.listarPorTipo(TipoTercero.DUEÑO);
        if (!lista.isEmpty()) {
            dueno = lista.get(0);
            d.setTipo(null);
        }
        return d;
    }

    public Documento getDocumento() {
        return venta;
    }

    public void setDocumento(Documento venta) {
        this.venta = venta;
    }

    public List<Documento> getListaDocumentos() {
        return listaVentas;
    }

    public void setListaDocumentos(List<Documento> listaDocumentos) {
        this.listaVentas = listaDocumentos;
    }
}
