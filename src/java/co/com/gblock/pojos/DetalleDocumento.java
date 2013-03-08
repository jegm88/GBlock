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
@Table(name = "detalles_documento")
public class DetalleDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer cantidad;
    @NotNull
    private Double valor;
    @NotNull
    @Column(name = "iva_ptj")
    private Float ivaPtj;
    private Double reteica;
    private Double retefuente;
    @Size(max = 50)
    @Column(name = "tipo_reteiva")
    private String tipoReteiva;
    @Size(max = 50)
    @Column(name = "tipo_reteica")
    private String tipoReteica;
    @Size(max = 50)
    @Column(name = "tipo_retefuente")
    private String tipoRetefuente;
    @NotNull
    private Double iva;
    @Column(name = "descuento_ptj")
    private Float descuentoPtj;
    private Double descuento;
    @NotNull
    private Double subtotal;
    @NotNull
    private Double total;
    private String descripcion;
    private Double reteiva;
    @NotNull
    private Short estado;
    @JoinColumn(name = "documento", referencedColumnName = "id")
    @ManyToOne
    private Documento documento;
    @JoinColumn(name = "articulo", referencedColumnName = "id")
    @ManyToOne
    private Articulo articulo;

    public DetalleDocumento() {
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Float getIvaPtj() {
        return ivaPtj;
    }

    public void setIvaPtj(Float ivaPtj) {
        this.ivaPtj = ivaPtj;
    }

    public Double getReteica() {
        return reteica;
    }

    public void setReteica(Double reteica) {
        this.reteica = reteica;
    }

    public Double getRetefuente() {
        return retefuente;
    }

    public void setRetefuente(Double retefuente) {
        this.retefuente = retefuente;
    }

    public String getTipoReteiva() {
        return tipoReteiva;
    }

    public void setTipoReteiva(String tipoReteiva) {
        this.tipoReteiva = tipoReteiva;
    }

    public String getTipoReteica() {
        return tipoReteica;
    }

    public void setTipoReteica(String tipoReteica) {
        this.tipoReteica = tipoReteica;
    }

    public String getTipoRetefuente() {
        return tipoRetefuente;
    }

    public void setTipoRetefuente(String tipoRetefuente) {
        this.tipoRetefuente = tipoRetefuente;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Float getDescuentoPtj() {
        return descuentoPtj;
    }

    public void setDescuentoPtj(Float descuentoPtj) {
        this.descuentoPtj = descuentoPtj;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getReteiva() {
        return reteiva;
    }

    public void setReteiva(Double reteiva) {
        this.reteiva = reteiva;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodos Sobreescritos">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 11 * hash + (this.cantidad != null ? this.cantidad.hashCode() : 0);
        hash = 11 * hash + (this.valor != null ? this.valor.hashCode() : 0);
        hash = 11 * hash + (this.ivaPtj != null ? this.ivaPtj.hashCode() : 0);
        hash = 11 * hash + (this.reteica != null ? this.reteica.hashCode() : 0);
        hash = 11 * hash + (this.retefuente != null ? this.retefuente.hashCode() : 0);
        hash = 11 * hash + (this.tipoReteiva != null ? this.tipoReteiva.hashCode() : 0);
        hash = 11 * hash + (this.tipoReteica != null ? this.tipoReteica.hashCode() : 0);
        hash = 11 * hash + (this.tipoRetefuente != null ? this.tipoRetefuente.hashCode() : 0);
        hash = 11 * hash + (this.iva != null ? this.iva.hashCode() : 0);
        hash = 11 * hash + (this.descuentoPtj != null ? this.descuentoPtj.hashCode() : 0);
        hash = 11 * hash + (this.descuento != null ? this.descuento.hashCode() : 0);
        hash = 11 * hash + (this.subtotal != null ? this.subtotal.hashCode() : 0);
        hash = 11 * hash + (this.total != null ? this.total.hashCode() : 0);
        hash = 11 * hash + (this.descripcion != null ? this.descripcion.hashCode() : 0);
        hash = 11 * hash + (this.reteiva != null ? this.reteiva.hashCode() : 0);
        hash = 11 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 11 * hash + (this.documento != null ? this.documento.hashCode() : 0);
        hash = 11 * hash + (this.articulo != null ? this.articulo.hashCode() : 0);
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
        final DetalleDocumento other = (DetalleDocumento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.cantidad != other.cantidad && (this.cantidad == null || !this.cantidad.equals(other.cantidad))) {
            return false;
        }
        if (this.valor != other.valor && (this.valor == null || !this.valor.equals(other.valor))) {
            return false;
        }
        if (this.ivaPtj != other.ivaPtj && (this.ivaPtj == null || !this.ivaPtj.equals(other.ivaPtj))) {
            return false;
        }
        if (this.reteica != other.reteica && (this.reteica == null || !this.reteica.equals(other.reteica))) {
            return false;
        }
        if (this.retefuente != other.retefuente && (this.retefuente == null || !this.retefuente.equals(other.retefuente))) {
            return false;
        }
        if ((this.tipoReteiva == null) ? (other.tipoReteiva != null) : !this.tipoReteiva.equals(other.tipoReteiva)) {
            return false;
        }
        if ((this.tipoReteica == null) ? (other.tipoReteica != null) : !this.tipoReteica.equals(other.tipoReteica)) {
            return false;
        }
        if ((this.tipoRetefuente == null) ? (other.tipoRetefuente != null) : !this.tipoRetefuente.equals(other.tipoRetefuente)) {
            return false;
        }
        if (this.iva != other.iva && (this.iva == null || !this.iva.equals(other.iva))) {
            return false;
        }
        if (this.descuentoPtj != other.descuentoPtj && (this.descuentoPtj == null || !this.descuentoPtj.equals(other.descuentoPtj))) {
            return false;
        }
        if (this.descuento != other.descuento && (this.descuento == null || !this.descuento.equals(other.descuento))) {
            return false;
        }
        if (this.subtotal != other.subtotal && (this.subtotal == null || !this.subtotal.equals(other.subtotal))) {
            return false;
        }
        if (this.total != other.total && (this.total == null || !this.total.equals(other.total))) {
            return false;
        }
        if ((this.descripcion == null) ? (other.descripcion != null) : !this.descripcion.equals(other.descripcion)) {
            return false;
        }
        if (this.reteiva != other.reteiva && (this.reteiva == null || !this.reteiva.equals(other.reteiva))) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        if (this.documento != other.documento && (this.documento == null || !this.documento.equals(other.documento))) {
            return false;
        }
        if (this.articulo != other.articulo && (this.articulo == null || !this.articulo.equals(other.articulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleDocumento{" + "id=" + id + ", cantidad=" + cantidad + ", valor=" + valor + ", ivaPtj=" + ivaPtj + ", reteica=" + reteica + ", retefuente=" + retefuente + ", tipoReteiva=" + tipoReteiva + ", tipoReteica=" + tipoReteica + ", tipoRetefuente=" + tipoRetefuente + ", iva=" + iva + ", descuentoPtj=" + descuentoPtj + ", descuento=" + descuento + ", subtotal=" + subtotal + ", total=" + total + ", descripcion=" + descripcion + ", reteiva=" + reteiva + ", estado=" + estado + ", documento=" + documento + ", articulo=" + articulo + '}';
    }
    //</editor-fold>
}
