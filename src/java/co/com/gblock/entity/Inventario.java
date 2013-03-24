/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhonny
 */
@Entity
@Table(name = "inventarios")
public class Inventario implements Serializable {

    @EmbeddedId
    protected InventarioPK inventarioPK;
    @JoinColumn(name = "bodega", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Bodega bodega;
    @JoinColumn(name = "articulo", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Articulo articulo;
    @NotNull
    private Integer cantidad;
    private Integer stockMax;
    private Integer stockMin;
    private Integer stockAlerta;
    @NotNull
    private Integer estado;

    public Inventario() {
    }

    public Inventario(InventarioPK inventarioPK, Integer cantidad, Integer stockMax, Integer stockMin, Integer stockAlerta, Integer estado, Bodega bodega, Articulo articulo) {
        this.inventarioPK = inventarioPK;
        this.cantidad = cantidad;
        this.stockMax = stockMax;
        this.stockMin = stockMin;
        this.stockAlerta = stockAlerta;
        this.estado = estado;
        this.bodega = bodega;
        this.articulo = articulo;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public InventarioPK getInventarioPK() {
        return inventarioPK;
    }

    public void setInventarioPK(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getStockMax() {
        return stockMax;
    }

    public void setStockMax(Integer stockMax) {
        this.stockMax = stockMax;
    }

    public Integer getStockMin() {
        return stockMin;
    }

    public void setStockMin(Integer stockMin) {
        this.stockMin = stockMin;
    }

    public Integer getStockAlerta() {
        return stockAlerta;
    }

    public void setStockAlerta(Integer stockAlerta) {
        this.stockAlerta = stockAlerta;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
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
        int hash = 5;
        hash = 29 * hash + (this.inventarioPK != null ? this.inventarioPK.hashCode() : 0);
        hash = 29 * hash + (this.cantidad != null ? this.cantidad.hashCode() : 0);
        hash = 29 * hash + (this.stockMax != null ? this.stockMax.hashCode() : 0);
        hash = 29 * hash + (this.stockMin != null ? this.stockMin.hashCode() : 0);
        hash = 29 * hash + (this.stockAlerta != null ? this.stockAlerta.hashCode() : 0);
        hash = 29 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 29 * hash + (this.bodega != null ? this.bodega.hashCode() : 0);
        hash = 29 * hash + (this.articulo != null ? this.articulo.hashCode() : 0);
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
        final Inventario other = (Inventario) obj;
        if (this.inventarioPK != other.inventarioPK && (this.inventarioPK == null || !this.inventarioPK.equals(other.inventarioPK))) {
            return false;
        }
        if (this.cantidad != other.cantidad && (this.cantidad == null || !this.cantidad.equals(other.cantidad))) {
            return false;
        }
        if (this.stockMax != other.stockMax && (this.stockMax == null || !this.stockMax.equals(other.stockMax))) {
            return false;
        }
        if (this.stockMin != other.stockMin && (this.stockMin == null || !this.stockMin.equals(other.stockMin))) {
            return false;
        }
        if (this.stockAlerta != other.stockAlerta && (this.stockAlerta == null || !this.stockAlerta.equals(other.stockAlerta))) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        if (this.bodega != other.bodega && (this.bodega == null || !this.bodega.equals(other.bodega))) {
            return false;
        }
        if (this.articulo != other.articulo && (this.articulo == null || !this.articulo.equals(other.articulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventario{" + "inventarioPK=" + inventarioPK + ", cantidad=" + cantidad + ", stockMax=" + stockMax + ", stockMin=" + stockMin + ", stockAlerta=" + stockAlerta + ", estado=" + estado + ", bodega=" + bodega + ", articulo=" + articulo + '}';
    }
    //</editor-fold>
}
