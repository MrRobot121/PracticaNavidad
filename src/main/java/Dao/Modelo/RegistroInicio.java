/*
---------------------------------
               /
              /
             /
          __/
             \
              \
           ____\
                \
                 \
              ____/
             /
            /
         __/
        /
       /
 */
/**
 *@author MrRobot121
 *@version 1.0 
 *@see  
 */
package Dao.Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "registro_inicio")
@NamedQueries({
    @NamedQuery(name = "RegistroInicio.findAll", query = "SELECT r FROM RegistroInicio r"),
    @NamedQuery(name = "RegistroInicio.findById", query = "SELECT r FROM RegistroInicio r WHERE r.id = :id"),
    @NamedQuery(name = "RegistroInicio.findByInicioSesion", query = "SELECT r FROM RegistroInicio r WHERE r.inicioSesion = :inicioSesion")})
public class RegistroInicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "inicio_sesion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicioSesion;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUser;

    public RegistroInicio() {
    }

    public RegistroInicio(Integer id) {
        this.id = id;
    }

    public RegistroInicio(Integer id, Date inicioSesion) {
        this.id = id;
        this.inicioSesion = inicioSesion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicioSesion() {
        return inicioSesion;
    }

    public void setInicioSesion(Date inicioSesion) {
        this.inicioSesion = inicioSesion;
    }

    public Usuarios getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuarios idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroInicio)) {
            return false;
        }
        RegistroInicio other = (RegistroInicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dao.Modelo.RegistroInicio[ id=" + id + " ]";
    }

}
