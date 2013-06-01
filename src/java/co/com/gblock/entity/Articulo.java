/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonny
 */
@Entity
@Table(name = "articulos")
@NamedQueries({
    @NamedQuery(name = "Articulo.buscarPorNombre", query = "SELECT o FROM Articulo o WHERE o.nombre = :nombre AND o.estado <> 0"),
    @NamedQuery(name = "Articulo.listarHabilitados", query = "SELECT o FROM Articulo o WHERE o.estado <> 0"),
    @NamedQuery(name = "Articulo.listarArticulo", query = "SELECT o FROM Articulo o WHERE o.categoria.nombre = :categoria AND  o.estado<> 0")
})
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    private String descripcion;
    @Size(max = 50)
    private String marca;
    @Size(max = 50)
    private String modelo;
    @NotNull
    @Column(name = "valor_unit")
    private Double valorUnit;
    @NotNull
    @Column(name = "iva_ptj")
    private Float ivaPtj;
    @NotNull
    @Column(name = "iva")
    private Double iva;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne
    private CategoriaArticulo categoria;
    private String observaciones;
    @NotNull
    private Integer estado;

    public Articulo() {
    }

    public Articulo(String nombre, String descripcion, String marca, String modelo, Double valorUnit, Float ivaPtj, Double iva, CategoriaArticulo categoria, String observaciones, Integer estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.valorUnit = valorUnit;
        this.ivaPtj = ivaPtj;
        this.iva = iva;
        this.categoria = categoria;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Float getIvaPtj() {
        return ivaPtj;
    }

    public void setIvaPtj(Float ivaPtj) {
        this.ivaPtj = ivaPtj;
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

    public CategoriaArticulo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaArticulo categoria) {
        this.categoria = categoria;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos Sobreescritos">
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 67 * hash + (this.descripcion != null ? this.descripcion.hashCode() : 0);
        hash = 67 * hash + (this.marca != null ? this.marca.hashCode() : 0);
        hash = 67 * hash + (this.modelo != null ? this.modelo.hashCode() : 0);
        hash = 67 * hash + (this.valorUnit != null ? this.valorUnit.hashCode() : 0);
        hash = 67 * hash + (this.ivaPtj != null ? this.ivaPtj.hashCode() : 0);
        hash = 67 * hash + (this.iva != null ? this.iva.hashCode() : 0);
        hash = 67 * hash + (this.observaciones != null ? this.observaciones.hashCode() : 0);
        hash = 67 * hash + this.estado;
        hash = 67 * hash + (this.categoria != null ? this.categoria.hashCode() : 0);
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
        final Articulo other = (Articulo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        if ((this.descripcion == null) ? (other.descripcion != null) : !this.descripcion.equals(other.descripcion)) {
            return false;
        }
        if ((this.marca == null) ? (other.marca != null) : !this.marca.equals(other.marca)) {
            return false;
        }
        if ((this.modelo == null) ? (other.modelo != null) : !this.modelo.equals(other.modelo)) {
            return false;
        }
        if (this.valorUnit != other.valorUnit && (this.valorUnit == null || !this.valorUnit.equals(other.valorUnit))) {
            return false;
        }
        if (this.ivaPtj != other.ivaPtj && (this.ivaPtj == null || !this.ivaPtj.equals(other.ivaPtj))) {
            return false;
        }
        if (this.iva != other.iva && (this.iva == null || !this.iva.equals(other.iva))) {
            return false;
        }
        if ((this.observaciones == null) ? (other.observaciones != null) : !this.observaciones.equals(other.observaciones)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (this.categoria != other.categoria && (this.categoria == null || !this.categoria.equals(other.categoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", marca=" + marca + ", modelo=" + modelo + ", valorUnit=" + valorUnit + ", ivaPtj=" + ivaPtj + ", iva=" + iva + ", observaciones=" + observaciones + ", estado=" + estado + ", categoria=" + categoria + '}';
    }
    //</editor-fold>
}
