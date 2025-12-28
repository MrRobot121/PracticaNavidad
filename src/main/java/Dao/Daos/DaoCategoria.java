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

public class DaoCategoria implements  DaoInterface<Categoria>{

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
