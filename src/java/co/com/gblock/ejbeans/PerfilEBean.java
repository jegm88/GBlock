/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.ejbeans;

import co.com.gblock.entity.Perfil;
import co.com.gblock.services.interfaceServicios.IPerfilServicio;
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
public class PerfilEBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("PerfilEBean");
    @EJB
    private IPerfilServicio perfilServicio;
    private Perfil perfil;
    private List<Perfil> listaPerfils;

    public PerfilEBean() {

        perfil = new Perfil();
    }

    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Ejecutando metodo init ({0})", this.getClass().getSimpleName());

        listar();
    }

    public void guardar() {

        LOGGER.log(Level.INFO, "Registrando perfil ({0})", this.getClass().getSimpleName());

        try {

            if (perfil.getId() == null || perfil.getId() == 0) {
                LOGGER.log(Level.INFO, "Guardando perfil ({0})", this.getClass().getSimpleName());
                perfil.setEstado(1);
                perfilServicio.insertar(perfil);
            } else {

                LOGGER.log(Level.INFO, "Modificando datos del perfil ({0})", this.getClass().getSimpleName());
                perfilServicio.modificar(perfil);
            }

            listar();

            perfil = new Perfil();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al registrar perfil ({0})", this.getClass().getSimpleName());
        }
    }

    private void listar() {

        LOGGER.log(Level.INFO, "Actualizando...");

        listaPerfils = perfilServicio.listarTodo(Perfil.class);
    }

    public void seleccionar(Perfil perfil) {

        LOGGER.log(Level.INFO, "Seleccionando perfil ({0})", this.getClass().getSimpleName());
        this.perfil = perfil;
    }

    public void eliminar(Perfil perfil) {

        LOGGER.log(Level.INFO, "Eliminando perfil ({0})", this.getClass().getSimpleName());

        try {

            perfilServicio.eliminar(perfil.getId(), Perfil.class);

            listar();
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error al eliminar perfil ({0})", this.getClass().getSimpleName());
        }
    }

    public List<Perfil> getListaPerfils() {
        return listaPerfils;
    }

    public void setListaPerfils(List<Perfil> listaPerfils) {
        this.listaPerfils = listaPerfils;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
