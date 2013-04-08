/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonny
 */
@Entity
@Table(name = "terceros")
public class Tercero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 50)
    private String tipoId;
    @NotNull
    @Column(unique=true)
    private String numeroId;
    private Integer digitoVerificacion;
    @Size(max = 50)
    private String nombres;
    @Size(max = 50)
    private String apellidos;
    @Size(max = 50)
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tercero")
    private List<Telefono> telefonos;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoTercero tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tercero")
    private List<Correo> correos;
    @NotNull
    private Integer estado;
    
    public Tercero() {
    }

    public Tercero(Long id, String tipoId, String numeroId, Integer digitoVerificacion, String nombres, String apellidos, String direccion, List<Telefono> telefonos, TipoTercero tipo, List<Correo> correos, Integer estado) {
        this.id = id;
        this.tipoId = tipoId;
        this.numeroId = numeroId;
        this.digitoVerificacion = digitoVerificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.tipo = tipo;
        this.correos = correos;
        this.estado = estado;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public Integer getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(Integer digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public TipoTercero getTipo() {
        return tipo;
    }

    public void setTipo(TipoTercero tipo) {
        this.tipo = tipo;
    }

    public List<Correo> getCorreos() {
        return correos;
    }

    public void setCorreos(List<Correo> correos) {
        this.correos = correos;
    }

    public String getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }    

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos sobreescritos">
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 17 * hash + (this.tipoId != null ? this.tipoId.hashCode() : 0);
        hash = 17 * hash + (this.numeroId != null ? this.numeroId.hashCode() : 0);
        hash = 17 * hash + (this.digitoVerificacion != null ? this.digitoVerificacion.hashCode() : 0);
        hash = 17 * hash + (this.nombres != null ? this.nombres.hashCode() : 0);
        hash = 17 * hash + (this.apellidos != null ? this.apellidos.hashCode() : 0);
        hash = 17 * hash + (this.direccion != null ? this.direccion.hashCode() : 0);
        hash = 17 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 17 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
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
        final Tercero other = (Tercero) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if ((this.tipoId == null) ? (other.tipoId != null) : !this.tipoId.equals(other.tipoId)) {
            return false;
        }
        if ((this.numeroId == null) ? (other.numeroId != null) : !this.numeroId.equals(other.numeroId)) {
            return false;
        }
        if (this.digitoVerificacion != other.digitoVerificacion && (this.digitoVerificacion == null || !this.digitoVerificacion.equals(other.digitoVerificacion))) {
            return false;
        }
        if ((this.nombres == null) ? (other.nombres != null) : !this.nombres.equals(other.nombres)) {
            return false;
        }
        if ((this.apellidos == null) ? (other.apellidos != null) : !this.apellidos.equals(other.apellidos)) {
            return false;
        }
        if ((this.direccion == null) ? (other.direccion != null) : !this.direccion.equals(other.direccion)) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        if (this.tipo != other.tipo && (this.tipo == null || !this.tipo.equals(other.tipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tercero{" + "id=" + id + ", tipoId=" + tipoId + ", numeroId=" + numeroId + ", digitoVerificacion=" + digitoVerificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    //</editor-fold>

}