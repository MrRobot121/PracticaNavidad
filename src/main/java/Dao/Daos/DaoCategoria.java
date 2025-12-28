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
package Dao.Daos;

import Dao.Modelo.Categoria;
import Dao.Util.HibernateUtil;
import java.util.List;
/**
 * DAO para operaciones CRUD de entidades {@link Categoria} usando Hibernate.
 * Implementa el patrón Data Access Object con gestión automática de sesiones
 * y transacciones.
 * 
 * @author HugoJB
 */
public class DaoCategoria implements DaoInterface<Categoria> {

    /**
     * Inserta una nueva categoría en la base de datos.
     * Maneja transacción con rollback automático en caso de error.
     *
     * @param dato Categoría a insertar.
     * @throws RuntimeException si falla la persistencia.
     */
    @Override
    public void insert(Categoria dato) {
        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            try {
                session.persist(dato);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    /**
     * Obtiene una categoría por su ID primario.
     *
     * @param id Identificador único de la categoría.
     * @return Categoría encontrada o null si no existe.
     */
    @Override
    public Categoria fetchOne(int id) {
        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Categoria c WHERE c.id = :id",
                    Categoria.class
            )
            .setParameter("id", id)
            .uniqueResult();
        }
    }

    /**
     * Recupera todas las categorías de la base de datos.
     *
     * @return Lista completa de categorías.
     */
    @Override
    public List<Categoria> fetchAll() {
        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Categoria c",
                    Categoria.class
            )
            .getResultList();
        }
    }

    /**
     * Actualiza una categoría existente en la base de datos.
     * Maneja transacción con rollback automático en caso de error.
     *
     * @param dato Categoría con datos actualizados.
     * @throws RuntimeException si falla la actualización.
     */
    @Override
    public void update(Categoria dato) {
        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            try {
                session.merge(dato);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    /**
     * Elimina una categoría por su ID primario.
     * Solo elimina si la categoría existe.
     *
     * @param id Identificador de la categoría a eliminar.
     * @throws RuntimeException si falla la eliminación.
     */
    @Override
    public void delete(int id) {
        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();
            try {
                Categoria categoria = session.createQuery(
                        "FROM Categoria c WHERE c.id = :id",
                        Categoria.class
                )
                .setParameter("id", id)
                .uniqueResult();
                
                if (categoria != null) {
                    session.remove(categoria);
                }
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    /**
     * Busca todas las categorías únicas usadas por un usuario específico.
     * Obtiene categorías DISTINCT de los productos del usuario.
     *
     * @param userId ID del usuario propietario.
     * @return Lista de categorías del usuario.
     */
    public static List<Categoria> buscarCategoriasDeUsuario(int userId) {
        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT DISTINCT p.idCategoria " +
                    "FROM Producto p " +
                    "WHERE p.idUser.id = :userId",
                    Categoria.class
            )
            .setParameter("userId", userId)
            .getResultList();
        }
    }

    /**
     * Busca una categoría por su nombre exacto.
     *
     * @param nombre Nombre de la categoría a buscar.
     * @return Categoría encontrada o null si no existe.
     */
    public static Categoria getCategoriaForNombre(String nombre) {
        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Buscar si existe
            Categoria categoria = session.createQuery(
                    "FROM Categoria c WHERE c.nombre = :nombre",
                    Categoria.class
            )
            .setParameter("nombre", nombre)
            .uniqueResult();
            return categoria;  
        }        
    }
}

