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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonny
 */
@ManagedBean
@Entity
@Table(name = "telefonos")
@NamedQuery(name = "Telefono.consultarPorTercero", query = "SELECT o FROM Telefono o WHERE o.tercero = :tercero")
public class Telefono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Pattern(regexp="^\\d+$", message="Teléfono no válido")
    private String numero;
    @Size(max = 50)
    private String tipo;
    @JoinColumn(name = "tercero", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tercero tercero;
    @NotNull
    private Integer estado;

    public Telefono() {
    }

    public Telefono(String numero, String tipo, Tercero tercero, Integer estado) {
        this.numero = numero;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 29 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 29 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 29 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 29 * hash + (this.tercero != null ? this.tercero.hashCode() : 0);
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
        final Telefono other = (Telefono) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
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
        return numero;
    }
    //</editor-fold>

    //Metodo seteo managedbean (al utilizar el immediate="true")
    public void setNumero(ValueChangeEvent ev) {
        setNumero((String) ev.getNewValue());
        ((UIInput) ev.getComponent()).setLocalValueSet(false);
    }
}
