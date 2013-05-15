/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhonny
 */
@Entity
@Table(name = "carteras")
public class Cartera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @JoinColumn(name = "tercero", referencedColumnName = "id")
    @ManyToOne
    private Tercero tercero;
    @NotNull
    @JoinColumn(name = "documento", referencedColumnName = "id")
    @ManyToOne
    private Documento documento;
    @NotNull
    private Double abono;
    @NotNull
    private Double saldo;
    @NotNull
    private Integer estado;

    public Cartera(Tercero tercero, Documento documento, Double abono, Double saldo, Integer estado) {
        this.tercero = tercero;
        this.documento = documento;
        this.abono = abono;
        this.saldo = saldo;
        this.estado = estado;
    }

    public Cartera() {
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tercero getTercero() {
        return tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

    public Double getAbono() {
        return abono;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodos Sobreescritos">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.tercero != null ? this.tercero.hashCode() : 0);
        hash = 97 * hash + (this.documento != null ? this.documento.hashCode() : 0);
        hash = 97 * hash + (this.abono != null ? this.abono.hashCode() : 0);
        hash = 97 * hash + (this.saldo != null ? this.saldo.hashCode() : 0);
        hash = 97 * hash + (this.estado != null ? this.estado.hashCode() : 0);
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
        final Cartera other = (Cartera) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.tercero != other.tercero && (this.tercero == null || !this.tercero.equals(other.tercero))) {
            return false;
        }
        if (this.documento != other.documento && (this.documento == null || !this.documento.equals(other.documento))) {
            return false;
        }
        if (this.abono != other.abono && (this.abono == null || !this.abono.equals(other.abono))) {
            return false;
        }
        if (this.saldo != other.saldo && (this.saldo == null || !this.saldo.equals(other.saldo))) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cartera{" + "id=" + id + ", tercero=" + tercero + ", documento=" + documento + ", abono=" + abono + ", saldo=" + saldo + ", estado=" + estado + '}';
    }
    //</editor-fold>
}
