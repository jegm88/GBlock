/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonny
 */
@Entity
@Table(name = "documentos")
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 50)
    private String codigo;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne
    private TipoDocumento tipo;
    @JoinColumn(name = "bodega", referencedColumnName = "id")
    @ManyToOne
    private Bodega bodega;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha1;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha2;
    @JoinColumn(name = "emisor", referencedColumnName = "id")
    @ManyToOne
    private Tercero emisor;
    @JoinColumn(name = "receptor", referencedColumnName = "id")
    @ManyToOne
    private Tercero receptor;
    @JoinColumn(name = "documento_asociado", referencedColumnName = "id")
    @ManyToOne
    private Documento documentoAsociado;
    @JoinColumn(name = "forma_pago", referencedColumnName = "id")
    @ManyToOne
    private FormaPago formaPago;
    private Double reteiva;
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
    @Column(name = "total_iva")
    private Double totalIva;
    private Double descuento;
    @NotNull
    private Double subtotal;
    @NotNull
    private Double total;
    @NotNull
    @Size(min = 1, max = 50)
    private String vendedor;
    private String observaciones;
    private Integer alerta;
    private Integer estado;
    @OneToMany
    @NotNull
    private List<DetalleDocumento> detallesDocumento;

    public Documento() {
    }

    public Documento(String codigo, TipoDocumento tipo, Bodega bodega, Calendar fecha1, Calendar fecha2, Tercero emisor, Tercero receptor, Documento documentoAsociado, FormaPago formaPago, Double reteiva, Double reteica, Double retefuente, String tipoReteiva, String tipoReteica, String tipoRetefuente, Double totalIva, Double descuento, Double subtotal, Double total, String vendedor, String observaciones, Integer estado) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.bodega = bodega;
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.emisor = emisor;
        this.receptor = receptor;
        this.documentoAsociado = documentoAsociado;
        this.formaPago = formaPago;
        this.reteiva = reteiva;
        this.reteica = reteica;
        this.retefuente = retefuente;
        this.tipoReteiva = tipoReteiva;
        this.tipoReteica = tipoReteica;
        this.tipoRetefuente = tipoRetefuente;
        this.totalIva = totalIva;
        this.descuento = descuento;
        this.subtotal = subtotal;
        this.total = total;
        this.vendedor = vendedor;
        this.observaciones = observaciones;
        this.estado = estado;
    }    
    
    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Calendar getFecha1() {
        return fecha1;
    }

    public void setFecha1(Calendar fecha1) {
        this.fecha1 = fecha1;
    }

    public Calendar getFecha2() {
        return fecha2;
    }

    public void setFecha2(Calendar fecha2) {
        this.fecha2 = fecha2;
    }

    public Double getReteiva() {
        return reteiva;
    }

    public void setReteiva(Double reteiva) {
        this.reteiva = reteiva;
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

    public Double getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Double totalIva) {
        this.totalIva = totalIva;
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

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public Tercero getReceptor() {
        return receptor;
    }

    public void setReceptor(Tercero receptor) {
        this.receptor = receptor;
    }

    public Tercero getEmisor() {
        return emisor;
    }

    public void setEmisor(Tercero emisor) {
        this.emisor = emisor;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Documento getDocumentoAsociado() {
        return documentoAsociado;
    }

    public void setDocumentoAsociado(Documento documentoAsociado) {
        this.documentoAsociado = documentoAsociado;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public List<DetalleDocumento> getDetallesDocumento() {
        return detallesDocumento;
    }

    public void setDetallesDocumento(List<DetalleDocumento> detallesDocumento) {
        this.detallesDocumento = detallesDocumento;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodos Sobreescritos">
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 83 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        hash = 83 * hash + (this.fecha1 != null ? this.fecha1.hashCode() : 0);
        hash = 83 * hash + (this.fecha2 != null ? this.fecha2.hashCode() : 0);
        hash = 83 * hash + (this.reteiva != null ? this.reteiva.hashCode() : 0);
        hash = 83 * hash + (this.reteica != null ? this.reteica.hashCode() : 0);
        hash = 83 * hash + (this.retefuente != null ? this.retefuente.hashCode() : 0);
        hash = 83 * hash + (this.tipoReteiva != null ? this.tipoReteiva.hashCode() : 0);
        hash = 83 * hash + (this.tipoReteica != null ? this.tipoReteica.hashCode() : 0);
        hash = 83 * hash + (this.tipoRetefuente != null ? this.tipoRetefuente.hashCode() : 0);
        hash = 83 * hash + (this.totalIva != null ? this.totalIva.hashCode() : 0);
        hash = 83 * hash + (this.descuento != null ? this.descuento.hashCode() : 0);
        hash = 83 * hash + (this.subtotal != null ? this.subtotal.hashCode() : 0);
        hash = 83 * hash + (this.total != null ? this.total.hashCode() : 0);
        hash = 83 * hash + (this.vendedor != null ? this.vendedor.hashCode() : 0);
        hash = 83 * hash + (this.observaciones != null ? this.observaciones.hashCode() : 0);
        hash = 83 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 83 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 83 * hash + (this.receptor != null ? this.receptor.hashCode() : 0);
        hash = 83 * hash + (this.emisor != null ? this.emisor.hashCode() : 0);
        hash = 83 * hash + (this.formaPago != null ? this.formaPago.hashCode() : 0);
        hash = 83 * hash + (this.documentoAsociado != null ? this.documentoAsociado.hashCode() : 0);
        hash = 83 * hash + (this.bodega != null ? this.bodega.hashCode() : 0);
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
        final Documento other = (Documento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        if (this.fecha1 != other.fecha1 && (this.fecha1 == null || !this.fecha1.equals(other.fecha1))) {
            return false;
        }
        if (this.fecha2 != other.fecha2 && (this.fecha2 == null || !this.fecha2.equals(other.fecha2))) {
            return false;
        }
        if (this.reteiva != other.reteiva && (this.reteiva == null || !this.reteiva.equals(other.reteiva))) {
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
        if (this.totalIva != other.totalIva && (this.totalIva == null || !this.totalIva.equals(other.totalIva))) {
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
        if ((this.vendedor == null) ? (other.vendedor != null) : !this.vendedor.equals(other.vendedor)) {
            return false;
        }
        if ((this.observaciones == null) ? (other.observaciones != null) : !this.observaciones.equals(other.observaciones)) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        if (this.tipo != other.tipo && (this.tipo == null || !this.tipo.equals(other.tipo))) {
            return false;
        }
        if (this.receptor != other.receptor && (this.receptor == null || !this.receptor.equals(other.receptor))) {
            return false;
        }
        if (this.emisor != other.emisor && (this.emisor == null || !this.emisor.equals(other.emisor))) {
            return false;
        }
        if (this.formaPago != other.formaPago && (this.formaPago == null || !this.formaPago.equals(other.formaPago))) {
            return false;
        }
        if (this.documentoAsociado != other.documentoAsociado && (this.documentoAsociado == null || !this.documentoAsociado.equals(other.documentoAsociado))) {
            return false;
        }
        if (this.bodega != other.bodega && (this.bodega == null || !this.bodega.equals(other.bodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Documento{" + "id=" + id + ", codigo=" + codigo + ", fecha1=" + fecha1 + ", fecha2=" + fecha2 + ", reteiva=" + reteiva + ", reteica=" + reteica + ", retefuente=" + retefuente + ", tipoReteiva=" + tipoReteiva + ", tipoReteica=" + tipoReteica + ", tipoRetefuente=" + tipoRetefuente + ", totalIva=" + totalIva + ", descuento=" + descuento + ", subtotal=" + subtotal + ", total=" + total + ", vendedor=" + vendedor + ", observaciones=" + observaciones + ", estado=" + estado + ", tipo=" + tipo + ", receptor=" + receptor + ", emisor=" + emisor + ", formaPago=" + formaPago + ", documentoAsociado=" + documentoAsociado + ", bodega=" + bodega + '}';
    }
    //</editor-fold>
}
