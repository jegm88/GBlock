/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonny
 */
@ManagedBean
@Entity
@Table(name = "correos")
@NamedQuery(name = "Correo.consultarPorTercero", query = "SELECT o FROM Correo o WHERE o.tercero = :tercero")
public class Correo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 150)
    private String email;
    @Size(max = 50)
    private String tipo;
    @JoinColumn(name = "tercero", referencedColumnName = "id")
    @ManyToOne
    private Tercero tercero;
    @NotNull
    private Integer estado;

    public Correo() {
    }

    public Correo(String email, String tipo, Tercero tercero, Integer estado) {
        this.email = email;
        this.tipo = tipo;
        this.tercero = tercero;
        this.estado = estado;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Tercero getTercero() {
        return tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodos Sobreescritos">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 23 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 23 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 23 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 23 * hash + (this.tercero != null ? this.tercero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Correo other = (Correo) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.tipo == null) ? (other.tipo != null) : !this.tipo.equals(other.tipo)) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        if (this.tercero != other.tercero && (this.tercero == null || !this.tercero.equals(other.tercero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return email;
    }
    //</editor-fold>

    //Metodo seteo managedbean (al utilizar el immediate="true")
    public void setEmail(ValueChangeEvent ev) {
        setEmail((String) ev.getNewValue());
        ((UIInput) ev.getComponent()).setLocalValueSet(false);
    }
}
