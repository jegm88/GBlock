/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.entity.Correo;
import co.com.gblock.entity.Telefono;
import co.com.gblock.entity.Tercero;
import co.com.gblock.services.interfaceServicios.ICorreoServicio;
import co.com.gblock.services.interfaceServicios.ITelefonoServicio;
import co.com.gblock.services.utilidad.TipoTercero;
import co.com.gblock.services.interfaceServicios.ITerceroServicio;
import co.com.gblock.services.utilidad.Mensajes;
import java.io.Serializable;
import java.util.ArrayList;
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
public class TerceroEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("TerceroEBean");
    @EJB
    private ITerceroServicio terceroServicio;
    private Tercero tercero;
    private List<Tercero> listaTerceros;
    @EJB
    private ITelefonoServicio telefonoServicio;
    private List<Telefono> listaTelefonos;
    @EJB
    private ICorreoServicio correoServicio;
    private List<Correo> listaCorreos;
    private List<TipoTercero> listaTipoTerceros;
    private TipoTercero tipo = TipoTercero.CLIENTE;

    public TerceroEBean() {
        LOGGER.log(Level.INFO, "Ejecutando constructor ({0})", this.getClass().getSimpleName());
        listaTipoTerceros = listarTipoTercero();
        listaTelefonos = listarTelefono();
        listaCorreos = listarCorreo();
        //listar();
    }

    @PostConstruct
    private void init() {
        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());
        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando tercero ({0})", this.getClass().getSimpleName());

        try {
            Tercero ttmp = terceroServicio.consultarPorNumeroId(tercero.getNumeroId());
            if (tercero.getId() == null) {
                if (ttmp != null) {
                    throw new Exception("Ya existe un tercero con el id: " + tercero.getNumeroId());
                } else {
                    LOGGER.log(Level.INFO, "Guardando tercero ({0})", tercero.getNumeroId());
                    tercero.setEstado(1);
                    tercero.setTipo(tipo);
                    tercero.setTelefonos(prepararTelefonos(listaTelefonos));
                    tercero.setCorreos(prepararCorreos(listaCorreos));
                    terceroServicio.insertar(tercero);
                    Mensajes.agregarInfoMensaje("¡Tercero " + tercero.getNumeroId() + " guardado exitosamente!", null);
                }
            } else {
                if (ttmp != null && (!tercero.getId().equals(ttmp.getId()) && ttmp.getEstado() != 0)) {
                    throw new Exception("Ya existe un tercero con el numero: " + tercero.getNumeroId());
                } else {
                    LOGGER.log(Level.INFO, "Modificando datos del tercero ({0})", tercero.getNumeroId());
                    tercero.setTelefonos(prepararTelefonos(listaTelefonos));
                    tercero.setCorreos(prepararCorreos(listaCorreos));
                    terceroServicio.modificar(tercero);
                    Mensajes.agregarInfoMensaje("¡Tercero " + tercero.getNumeroId() + " modificada!", null);
                }
            }
            listar();
            tercero = new Tercero();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al guardar/modificar: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }

    private void listar() {
        LOGGER.log(Level.INFO, "Actualizando...");
        listaTerceros = terceroServicio.listarHabilitados();
    }

    private ArrayList<TipoTercero> listarTipoTercero() {
        ArrayList<TipoTercero> l = new ArrayList<TipoTercero>();
        for (TipoTercero tt : TipoTercero.values()) {
            if (tt.getEscogible()) {
                l.add(tt);
            }
        }
        return l;
    }

    public void seleccionar(Tercero tercero) {
        LOGGER.log(Level.INFO, "Seleccionando tercero ({0})", this.getClass().getSimpleName());
        this.tercero = tercero;
        this.tipo = tercero.getTipo();
        this.listaCorreos = tercero.getCorreos();
        this.listaTelefonos = tercero.getTelefonos();
    }

    private Telefono prepararTelefono(Telefono t) {
        t.setTercero(tercero);
        t.setEstado(1);
        return t;
    }

    private List<Telefono> prepararTelefonos(List<Telefono> lts) {
        List<Telefono> l = new ArrayList<Telefono>();
        for (Telefono t : lts) {
            l.add(prepararTelefono(t));
        }
        return l;
    }

    public void addTelefono(Telefono telefono) {
        if (!listaTelefonos.contains(telefono) && !telefono.getNumero().isEmpty()) {
            LOGGER.log(Level.INFO, "Agregando Telefono {0}", telefono);
            listaTelefonos.add(telefono);
        }
    }

    public void imprimir(Telefono t) {
        LOGGER.log(Level.INFO, "Imprimir: {0}", t);
    }

    public void editarTelefono(Telefono telefono) {
        LOGGER.log(Level.INFO, "Editando telefono");
        listaTelefonos.remove(telefono);
        listaTelefonos.add(telefono);
    }

    public void eliminarTelefono(Telefono telefono) {
        LOGGER.log(Level.INFO, "Eliminando telefono");
        listaTelefonos.remove(telefono);
    }

    private List<Telefono> listarTelefono() {
        List<Telefono> l = new ArrayList<Telefono>();

        if (tercero != null && tercero.getId() != null) {
            LOGGER.log(Level.INFO, "Listando telefonos");
            l = telefonoServicio.consultarPorTercero(tercero);
        }
        return l;
    }

    private Correo prepararCorreo(Correo c) {
        c.setTercero(tercero);
        c.setEstado(1);
        return c;
    }

    private List<Correo> prepararCorreos(List<Correo> lcs) {
        List<Correo> l = new ArrayList<Correo>();
        for (Correo c : lcs) {
            l.add(prepararCorreo(c));
        }
        return l;
    }

    public void addCorreo(Correo correo) {
        if (!listaCorreos.contains(correo) && !correo.getEmail().isEmpty()) {
            LOGGER.log(Level.INFO, "Agregando Correo {0}", correo);
            listaCorreos.add(correo);
        }
    }

    public void editarCorreo(Correo correo) {
        LOGGER.log(Level.INFO, "Editando correo");
        listaCorreos.remove(correo);
        listaCorreos.add(correo);
    }

    public void eliminarCorreo(Correo correo) {
        LOGGER.log(Level.INFO, "Eliminando correo");
        listaCorreos.remove(correo);
    }

    private List<Correo> listarCorreo() {
        List<Correo> c = new ArrayList<Correo>();
        if (tercero != null && tercero.getId() != null) {
            LOGGER.log(Level.INFO, "Listando correos");
            c = correoServicio.consultarPorTercero(tercero);
        }
        return c;
    }

    public void eliminar() {
        eliminar(tercero);
    }

    public void eliminar(Tercero tercero) {
        LOGGER.log(Level.INFO, "Eliminando bodega ({0})", tercero.getNombres());
        try {
            //terceroServicio.eliminar(bodega.getId(), Bodega.class);
            tercero.setEstado(0);
            terceroServicio.modificar(tercero);
            Mensajes.agregarInfoMensaje("Tercero " + tercero.getNombres() + " eliminado exitosamente!", null);
            listar();
            nuevo();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "¡Error al eliminar tercero: ({0})!", e.getMessage());
            Mensajes.agregarErrorMensaje("¡Error: " + e.getMessage() + "!", null);
        }
    }

    public void nuevo() {
        LOGGER.log(Level.INFO, "Creando nuevo tercero");
        listaTipoTerceros = listarTipoTercero();
        listaTelefonos = new ArrayList<Telefono>();
        listaCorreos = new ArrayList<Correo>();
        tercero = new Tercero();
        Mensajes.agregarInfoMensaje("¡Nuevo tercero!", null);
    }

    public List<Correo> getListaCorreos() {
        return listaCorreos;
    }

    public void setListaCorreos(List<Correo> listaCorreos) {
        this.listaCorreos = listaCorreos;
    }

    public List<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }

    public void setListaTelefonos(List<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }

    public List<Tercero> getListaTerceros() {
        return listaTerceros;
    }

    public void setListaTerceros(List<Tercero> listaTerceros) {
        this.listaTerceros = listaTerceros;
    }

    public Tercero getTercero() {
        return tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

    public List<TipoTercero> getListaTipoTerceros() {
        return listaTipoTerceros;
    }

    public void setListaTipoTerceros(List<TipoTercero> listaTipoTerceros) {
        this.listaTipoTerceros = listaTipoTerceros;
    }

    public TipoTercero getTipo() {
        return tipo;
    }

    public void setTipo(TipoTercero tipo) {
        this.tipo = tipo;
    }
}