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

    DUEÑO(0,"Dueño","Dueño de la licencia",false),
    CLIENTE(1, "Cliente", "A quien se le venden los productos",true),
    PROVEEDOR(2, "Proveedor", "Quien vende los productos",true),
    USUARIO(3, "Usuario", "Usuario del sistema",false);

    Integer id;
    String nombre;
    String descripcion;
    Boolean escogible;

    private TipoTercero(Integer id, String nombre, String descripcion, Boolean escogible) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.escogible = escogible;
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

    public Boolean getEscogible() {
        return escogible;
    }

    public void setEscogible(Boolean escogible) {
        this.escogible = escogible;
    }
   
    @Override
    public String toString() {
        return nombre;
    }   
}
