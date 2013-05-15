/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhonny
 */
@Entity
@Table(name = "arqueos")
public class Arqueo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @JoinColumn(name = "bodega", referencedColumnName = "id")
    @ManyToOne
    private Bodega bodega;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaApertura;
    
    @NotNull
    private Double valorApertura;
    
    @NotNull
    @JoinColumn(name = "usuarioApertura", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioApertura;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaCierre;
    
    @NotNull
    private Double valorCierre;
    
    @NotNull
    @JoinColumn(name = "usuarioCierre", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioCierre;
    
    @NotNull
    private Double descuadre;
    
    @NotNull
    private Integer estado;

    public Arqueo() {
    }

    public Arqueo(Bodega bodega, Calendar fechaApertura, Double valorApertura, Usuario usuarioApertura, Calendar fechaCierre, Double valorCierre, Usuario usuarioCierre, Double descuadre, Integer estado) {
        this.bodega = bodega;
        this.fechaApertura = fechaApertura;
        this.valorApertura = valorApertura;
        this.usuarioApertura = usuarioApertura;
        this.fechaCierre = fechaCierre;
        this.valorCierre = valorCierre;
        this.usuarioCierre = usuarioCierre;
        this.descuadre = descuadre;
        this.estado = estado;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Calendar fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Double getValorApertura() {
        return valorApertura;
    }

    public void setValorApertura(Double valorApertura) {
        this.valorApertura = valorApertura;
    }

    public Calendar getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Calendar fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Double getValorCierre() {
        return valorCierre;
    }

    public void setValorCierre(Double valorCierre) {
        this.valorCierre = valorCierre;
    }

    public Double getDescuadre() {
        return descuadre;
    }

    public void setDescuadre(Double descuadre) {
        this.descuadre = descuadre;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioCierre() {
        return usuarioCierre;
    }

    public void setUsuarioCierre(Usuario usuarioCierre) {
        this.usuarioCierre = usuarioCierre;
    }

    public Usuario getUsuarioApertura() {
        return usuarioApertura;
    }

    public void setUsuarioApertura(Usuario usuarioApertura) {
        this.usuarioApertura = usuarioApertura;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodos Sobreescritos">
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.fechaApertura != null ? this.fechaApertura.hashCode() : 0);
        hash = 67 * hash + (this.valorApertura != null ? this.valorApertura.hashCode() : 0);
        hash = 67 * hash + (this.fechaCierre != null ? this.fechaCierre.hashCode() : 0);
        hash = 67 * hash + (this.valorCierre != null ? this.valorCierre.hashCode() : 0);
        hash = 67 * hash + (this.descuadre != null ? this.descuadre.hashCode() : 0);
        hash = 67 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 67 * hash + (this.usuarioCierre != null ? this.usuarioCierre.hashCode() : 0);
        hash = 67 * hash + (this.usuarioApertura != null ? this.usuarioApertura.hashCode() : 0);
        hash = 67 * hash + (this.bodega != null ? this.bodega.hashCode() : 0);
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
        final Arqueo other = (Arqueo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.fechaApertura != other.fechaApertura && (this.fechaApertura == null || !this.fechaApertura.equals(other.fechaApertura))) {
            return false;
        }
        if (this.valorApertura != other.valorApertura && (this.valorApertura == null || !this.valorApertura.equals(other.valorApertura))) {
            return false;
        }
        if (this.fechaCierre != other.fechaCierre && (this.fechaCierre == null || !this.fechaCierre.equals(other.fechaCierre))) {
            return false;
        }
        if (this.valorCierre != other.valorCierre && (this.valorCierre == null || !this.valorCierre.equals(other.valorCierre))) {
            return false;
        }
        if (this.descuadre != other.descuadre && (this.descuadre == null || !this.descuadre.equals(other.descuadre))) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        if (this.usuarioCierre != other.usuarioCierre && (this.usuarioCierre == null || !this.usuarioCierre.equals(other.usuarioCierre))) {
            return false;
        }
        if (this.usuarioApertura != other.usuarioApertura && (this.usuarioApertura == null || !this.usuarioApertura.equals(other.usuarioApertura))) {
            return false;
        }
        if (this.bodega != other.bodega && (this.bodega == null || !this.bodega.equals(other.bodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Arqueo{" + "id=" + id + ", fechaApertura=" + fechaApertura + ", valorApertura=" + valorApertura + ", fechaCierre=" + fechaCierre + ", valorCierre=" + valorCierre + ", descuadre=" + descuadre + ", estado=" + estado + ", usuarioCierre=" + usuarioCierre + ", usuarioApertura=" + usuarioApertura + ", bodega=" + bodega + '}';
    }
    //</editor-fold>
}
