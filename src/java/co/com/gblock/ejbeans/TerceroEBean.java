/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.Correo;
import co.com.gblock.entity.Telefono;
import co.com.gblock.entity.Tercero;
import co.com.gblock.entity.TipoTercero;
import co.com.gblock.services.interfaceServicios.ICorreoServicio;
import co.com.gblock.services.interfaceServicios.ITelefonoServicio;
import co.com.gblock.services.interfaceServicios.ITerceroServicio;
import co.com.gblock.services.interfaceServicios.ITipoTerceroServicio;
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
    @EJB
    private ITipoTerceroServicio tipoTerceroServicio;
    private Tercero tercero;
    private List<Tercero> listaTerceros;
    private Telefono telefono;
    private Correo correo;
    private List<TipoTercero> listaTipoTerceros;
    private List<Telefono> listaTelefonos;
    private List<Correo> listaCorreos;

    public TerceroEBean() {

        tercero = new Tercero();
        telefono = new Telefono();
        correo = new Correo();
        
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());
        listar();

        listaTelefonos = listarTelefono();
        listaCorreos = listarCorreo();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando tercero ({0})", this.getClass().getSimpleName());

        try {

            if (tercero.getId() == null || tercero.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando tercero ({0})", this.getClass().getSimpleName());
                tercero.setEstado(1);
                terceroServicio.insertar(tercero);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos del tercero ({0})", this.getClass().getSimpleName());
                terceroServicio.modificar(tercero);
            }

            listar();

            tercero = new Tercero();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar tercero ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaTerceros = terceroServicio.listarTodo(Tercero.class);
        listaTipoTerceros = tipoTerceroServicio.listarTodo(TipoTercero.class);
    }

    public void seleccionar(Tercero tercero) {

        LOGGER.log(Level.INFO, "Seleccionando tercero ({0})", this.getClass().getSimpleName());
        this.tercero = tercero;
    }

    public void eliminar(Tercero tercero) {

        LOGGER.log(Level.INFO, "Eliminando tercero ({0})", this.getClass().getSimpleName());

        try {

            terceroServicio.eliminar(tercero.getId(), Tercero.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar tercero ({0})", this.getClass().getSimpleName());
        }
    }
    
    public void addTelefono(){
        LOGGER.log(Level.INFO, "agregando telefono");
        listaTelefonos.add(telefono);
        listarTelefono();
        telefono = new Telefono();
    }
    public void editarTelefono(Telefono telefono){
        LOGGER.log(Level.INFO, "Editando telefono");
        listaTelefonos.remove(telefono);
        listaTelefonos.add(telefono);
        listarTelefono();
    }
    public void eliminarTelefono(Telefono telefono){
        LOGGER.log(Level.INFO, "Eliminando telefono");
        listaTelefonos.remove(telefono);
        listarTelefono();
    }
    
    public List<Telefono> listarTelefono(){
        LOGGER.log(Level.INFO, "listando telefonos");
        List<Telefono> l = new ArrayList<Telefono>();
        for (Telefono tel : listaTelefonos) {
            l.add(tel);
        }
        return l;
    }
    
    public void addCorreo(){
        LOGGER.log(Level.INFO, "agregando telefono");
        listaCorreos.add(correo);
        listarCorreo();
        correo = new Correo();
    }
    
    public void editarCorreo(Correo correo){
        LOGGER.log(Level.INFO, "Editando correo");
        listaCorreos.remove(correo);
        listaCorreos.add(correo);
        listarCorreo();
    }
    public void eliminarCorreo(Correo correo){
        LOGGER.log(Level.INFO, "Eliminando correo");
        listaCorreos.remove(correo);
        listarCorreo();
    }
    public List<Correo> listarCorreo(){
        LOGGER.log(Level.INFO, "listando correos");
        List<Correo> l = new ArrayList<Correo>();
        for (Correo tel : listaCorreos) {
            l.add(tel);
        }
        return l;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
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
}
