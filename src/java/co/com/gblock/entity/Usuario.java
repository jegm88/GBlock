/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gblock.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonny
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuario.login", query = "SELECT u FROM Usuario u WHERE u.nick = :nick AND u.password = :password AND u.estado <> 0"),
    @NamedQuery(name = "Usuario.consultarPorNick", query = "SELECT u FROM Usuario u WHERE u.nick = :nick AND u.estado <> 0"),
    @NamedQuery(name = "Usuario.listarHabilitados", query = "SELECT u FROM Usuario u WHERE u.estado <> 0")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 1, max = 50)
    private String nick;
    @Size(min = 1, max = 50)
    private String password;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tercero", referencedColumnName = "id")
    private Tercero tercero;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil", referencedColumnName = "id")
    private Perfil perfil;
    private Integer estado;

    public Usuario() {
    }

    public Usuario(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public Usuario(String nick, String password, Tercero tercero, Perfil perfil, Integer estado) {
        this.nick = nick;
        this.password = password;
        this.tercero = tercero;
        this.perfil = perfil;
        this.estado = estado;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Tercero getTercero() {
        return tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodos sobreescritos">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 59 * hash + (this.nick != null ? this.nick.hashCode() : 0);
        hash = 59 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 59 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 59 * hash + (this.tercero != null ? this.tercero.hashCode() : 0);
        hash = 59 * hash + (this.perfil != null ? this.perfil.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nick == null) ? (other.nick != null) : !this.nick.equals(other.nick)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        if (this.tercero != other.tercero && (this.tercero == null || !this.tercero.equals(other.tercero))) {
            return false;
        }
        if (this.perfil != other.perfil && (this.perfil == null || !this.perfil.equals(other.perfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nick=" + nick + ", password=" + password + ", estado=" + estado + ", tercero=" + tercero + ", perfil=" + perfil + '}';
    }
    //</editor-fold>    
}