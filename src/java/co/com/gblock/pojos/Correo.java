/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.pojos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonny
 */
@Entity
@Table(name = "correos")
public class Correo implements Serializable {

    @Id
    @NotNull
    @Size(min = 1, max = 50)
    private String email;
    @Size(max = 50)
    private String tipo;
    @NotNull
    private Short estado;
    @JoinColumn(name = "tercero", referencedColumnName = "id")
    @ManyToOne
    private Tercero tercero;

    public Correo() {
    }

    public Correo(String email, String tipo, Short estado, Tercero tercero) {
        this.email = email;
        this.tipo = tipo;
        this.estado = estado;
        this.tercero = tercero;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
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

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
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
        return "Correo{" + "email=" + email + ", tipo=" + tipo + ", estado=" + estado + ", tercero=" + tercero + '}';
    }
    //</editor-fold>
}
