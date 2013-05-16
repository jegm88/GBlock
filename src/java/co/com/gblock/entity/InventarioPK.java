/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhonny
 */
@Embeddable
public class InventarioPK implements Serializable {

    @NotNull
    private Integer bodega;
    @NotNull
    private Long articulo;

    public InventarioPK() {
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Integer getBodega() {
        return bodega;
    }

    public void setBodega(Integer bodega) {
        this.bodega = bodega;
    }

    public Long getArticulo() {
        return articulo;
    }

    public void setArticulo(Long articulo) {
        this.articulo = articulo;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos Sobreescritos">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.bodega != null ? this.bodega.hashCode() : 0);
        hash = 59 * hash + (this.articulo != null ? this.articulo.hashCode() : 0);
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
        final InventarioPK other = (InventarioPK) obj;
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
        return "InventarioPK{" + "bodega=" + bodega + ", articulo=" + articulo + '}';
    }
    //</editor-fold>
}