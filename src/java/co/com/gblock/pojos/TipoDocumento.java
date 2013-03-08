/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonny
 */
@Entity
@Table(name = "tipos_documento")
public class TipoDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    private String descripcion;
    @NotNull
    private Long indice;
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "formato_codigo")
    private String formatoCodigo;
    @Column(name = "impacto_inventario")
    private Short impactoInventario;
    @NotNull
    private Short estado;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer id, String nombre, String descripcion, Long indice, String formatoCodigo, Short impactoInventario, Short estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indice = indice;
        this.formatoCodigo = formatoCodigo;
        this.impactoInventario = impactoInventario;
        this.estado = estado;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIndice() {
        return indice;
    }

    public void setIndice(Long indice) {
        this.indice = indice;
    }

    public String getFormatoCodigo() {
        return formatoCodigo;
    }

    public void setFormatoCodigo(String formatoCodigo) {
        this.formatoCodigo = formatoCodigo;
    }

    public Short getImpactoInventario() {
        return impactoInventario;
    }

    public void setImpactoInventario(Short impactoInventario) {
        this.impactoInventario = impactoInventario;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodos Sobreescritos">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 59 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 59 * hash + (this.descripcion != null ? this.descripcion.hashCode() : 0);
        hash = 59 * hash + (this.indice != null ? this.indice.hashCode() : 0);
        hash = 59 * hash + (this.formatoCodigo != null ? this.formatoCodigo.hashCode() : 0);
        hash = 59 * hash + (this.impactoInventario != null ? this.impactoInventario.hashCode() : 0);
        hash = 59 * hash + (this.estado != null ? this.estado.hashCode() : 0);
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
        final TipoDocumento other = (TipoDocumento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        if ((this.descripcion == null) ? (other.descripcion != null) : !this.descripcion.equals(other.descripcion)) {
            return false;
        }
        if (this.indice != other.indice && (this.indice == null || !this.indice.equals(other.indice))) {
            return false;
        }
        if ((this.formatoCodigo == null) ? (other.formatoCodigo != null) : !this.formatoCodigo.equals(other.formatoCodigo)) {
            return false;
        }
        if (this.impactoInventario != other.impactoInventario && (this.impactoInventario == null || !this.impactoInventario.equals(other.impactoInventario))) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoDocumento{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", indice=" + indice + ", formatoCodigo=" + formatoCodigo + ", impactoInventario=" + impactoInventario + ", estado=" + estado + '}';
    }
    //</editor-fold>
}
