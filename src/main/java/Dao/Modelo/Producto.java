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
 *@author HugoJB
 *@author MrRobot121
 *@version 1.0 
 *@see  
 */
package Dao.Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Producto.findByFechaCaducidad", query = "SELECT p FROM Producto p WHERE p.fechaCaducidad = :fechaCaducidad"),
    @NamedQuery(name = "Producto.findByCantidadMinDeseada", query = "SELECT p FROM Producto p WHERE p.cantidadMinDeseada = :cantidadMinDeseada"),
    @NamedQuery(name = "Producto.findByListaCompra", query = "SELECT p FROM Producto p WHERE p.listaCompra = :listaCompra")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "fecha_caducidad")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidad;
    @Basic(optional = false)
    @Column(name = "cantidad_min_deseada")
    private int cantidadMinDeseada;
    @Basic(optional = false)
    @Column(name = "lista_compra")
    private boolean listaCompra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<ListaCompra> listaCompraCollection;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUser;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String nombre, int cantidad, int cantidadMinDeseada, boolean listaCompra) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.cantidadMinDeseada = cantidadMinDeseada;
        this.listaCompra = listaCompra;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCantidadMinDeseada() {
        return cantidadMinDeseada;
    }

    public void setCantidadMinDeseada(int cantidadMinDeseada) {
        this.cantidadMinDeseada = cantidadMinDeseada;
    }

    public boolean getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(boolean listaCompra) {
        this.listaCompra = listaCompra;
    }

    public Collection<ListaCompra> getListaCompraCollection() {
        return listaCompraCollection;
    }

    public void setListaCompraCollection(Collection<ListaCompra> listaCompraCollection) {
        this.listaCompraCollection = listaCompraCollection;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dao.Modelo.Producto[ id=" + id + " ]";
    }

}
