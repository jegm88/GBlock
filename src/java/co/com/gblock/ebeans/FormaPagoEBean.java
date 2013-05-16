/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ebeans;

import co.com.gblock.entity.FormaPago;
import co.com.gblock.services.interfaceServicios.IFormaPagoServicio;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author FGulfo
 */
@ManagedBean
@ViewScoped
public class FormaPagoEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("FormaPagoEBean");
    @EJB
    private IFormaPagoServicio formaPagoServicio;
    private FormaPago formaPago;
    private List<FormaPago> listaFormaPagos;

    public FormaPagoEBean() {

        formaPago = new FormaPago();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando forma de pago ({0})", this.getClass().getSimpleName());

        try {

            if (formaPago.getId() == null || formaPago.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando forma de pago ({0})", this.getClass().getSimpleName());
                formaPago.setEstado(1);
                formaPagoServicio.insertar(formaPago);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos de la forma de pago ({0})", this.getClass().getSimpleName());
                formaPagoServicio.modificar(formaPago);
            }

            listar();

            formaPago = new FormaPago();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar forma de pago ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaFormaPagos = formaPagoServicio.listarTodo(FormaPago.class);
    }

    public void seleccionar(FormaPago formaPago) {

        LOGGER.log(Level.INFO, "Seleccionando forma de pago ({0})", this.getClass().getSimpleName());
        this.formaPago = formaPago;
    }

    public void eliminar(FormaPago formaPago) {

        LOGGER.log(Level.INFO, "Eliminando forma de pago ({0})", this.getClass().getSimpleName());

        try {

            formaPagoServicio.eliminar(formaPago.getId(), FormaPago.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar forma de pago ({0})", this.getClass().getSimpleName());
        }
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public List<FormaPago> getListaFormaPagos() {
        return listaFormaPagos;
    }

    public void setListaFormaPagos(List<FormaPago> listaFormaPagos) {
        this.listaFormaPagos = listaFormaPagos;
    }
}
