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
package Dao.Daos;

import Dao.Modelo.Producto;
import Dao.Util.HibernateUtil;
import org.hibernate.Session;
import java.util.Date;

import java.util.List;

public class DaoProducto implements DaoInterface<Producto>{
    /**
     * Inserta un nuevo registro en la base de datos.
     *
     * @param dato objeto que contiene los datos a insertar
     */
    @Override
    public void insert(Producto dato) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(dato);
            session.getTransaction().commit();
        }
    }

    /**
     * Obtiene un único registro a partir de su identificador.
     *
     * @param id identificador único del registro
     * @return objeto encontrado o null si no existe
     */
    @Override
    public Producto fetchOne(int id) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Producto.class, id);
        }
    }

    /**
     * Recupera todos los registros de la tabla asociada.
     *
     * @return lista con todos los objetos encontrados (puede estar vacía)
     */
    @Override
    public List<Producto> fetchAll() {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("FROM Producto", Producto.class)
                    .getResultList();
        }
    }

    /**
     * Actualiza un registro existente en la base de datos.
     *
     * @param dato objeto con los nuevos valores a actualizar
     */
    @Override
    public void update(Producto dato) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            // merge por si el objeto viene detached
            session.merge(dato);
            session.getTransaction().commit();
        }
    }

    /**
     * Elimina un registro de la base de datos según su identificador.
     *
     * @param id identificador del registro a eliminar
     */
    @Override
    public  void delete(int id) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Producto p = session.get(Producto.class, id);
            if (p != null) {
                session.remove(p);
            }
            session.getTransaction().commit();
        }
    }

    // ================== MÉTODOS EXTRA PARA TUS BÚSQUEDAS ==================

    /**
     * Devuelve todos los productos asociados a un usuario concreto.
     *
     * @param userId id del usuario propietario de los productos
     * @return lista de productos del usuario
     */
    public static List<Producto> buscarPorUsuario(int userId) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Producto p WHERE p.usuarios.id = :userId",
                    Producto.class
            )
            .setParameter("userId", userId)
            .getResultList();
        }
    }

    /**
     * Busca productos por nombre (prefijo) asociados a un usuario concreto.
     *
     * @param texto  prefijo del nombre del producto a buscar
     * @param userId id del usuario propietario de los productos
     * @return lista de productos que coinciden con el criterio
     */
    public static List<Producto> buscarPorNombreYUsuario(String texto, int userId) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Producto p " +
                    "WHERE p.usuarios.id = :userId " +
                    "AND LOWER(p.nombre) LIKE :nombre",
                    Producto.class
            )
            .setParameter("userId", userId)
            .setParameter("nombre", texto.toLowerCase() + "%")
            .getResultList();
        }
    }
    
    /**
 * Devuelve hasta 10 productos más antiguos por fecha de caducidad para un usuario.
 * Si hay caducados, devuelve 10 caducados más antiguos.
 * Si no hay caducados, devuelve 10 más próximos a caducar.
 */
public static List<Producto> buscarTop10PorCaducidad(int userId) {
    try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {

        // Traemos todos los productos del usuario con fecha de caducidad, ordenados
        List<Producto> todos = session.createQuery(
                "FROM Producto p " +
                "WHERE p.usuarios.id = :userId AND p.fechaCaducidad IS NOT NULL " +
                "ORDER BY p.fechaCaducidad ASC",
                Producto.class
        )
        .setParameter("userId", userId)
        .getResultList();

        if (todos.isEmpty()) {
            return todos; // no hay productos con fecha
        }


        // Caducados (fecha < hoy)
        List<Producto> caducados = new java.util.ArrayList<>();
 Date hoy = new Date();

for (Producto p : todos) {
    Date fecha = p.getFechaCaducidad();
    if (fecha.before(hoy)) {     // fecha < hoy
        caducados.add(p);
    }
}

        if (!caducados.isEmpty()) {
            return caducados.size() > 10 ? caducados.subList(0, 10) : caducados;
        }

        // Si no hay caducados, devolvemos los 10 más próximos (los primeros de la lista ordenada)
        return todos.size() > 10 ? todos.subList(0, 10) : todos;
    }
}
public static List<Producto> buscarPorCategoriaYUsuario(int idCategoria, int userId) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery(
                "FROM Producto p " +
                "WHERE p.idUser.id = :userId AND p.idCategoria.id = :idCategoria",
                Producto.class
        )
        .setParameter("userId", userId)
        .setParameter("idCategoria", idCategoria)
        .getResultList();
    }
}
/**
 * DEVUELVE LOS ELEMENTOS QUE ESTEN TENGAN LISTA COMPRA TRUE Y que EL ID USER SEA userDI
 * @param userId
 * @return 
 */
public static List<Producto> buscarProductosListaCompra(int userId) {
    try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery(
                "FROM Producto p " +
                "WHERE p.idUser.id = :userId " +
                "AND p.listaCompra = true " +
                "AND p.cantidad < p.cantidadMinDeseada " +
                "ORDER BY p.nombre",
                Producto.class
        )
        .setParameter("userId", userId)
        .getResultList();
    }
}


}
