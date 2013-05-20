/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.services.utilidad;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
public enum TipoTercero {

    DUEÑO(0,"Dueño","Dueño de la licencia"),
    CLIENTE(1, "Cliente", "A quien se le venden los productos"),
    PROVEEDOR(1, "Proveedor", "Quien vende los productos");

    Integer id;
    String nombre;
    String descripcion;

    private TipoTercero(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

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

    @Override
    public String toString() {
        return nombre;
    }   
}
