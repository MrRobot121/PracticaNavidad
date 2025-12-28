package Dao.Daos;

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
import Dao.Modelo.Usuarios;
import Dao.Util.HibernateUtil;
import Recursos.GestorContraseñas;
import jakarta.persistence.EntityManagerFactory;

import org.hibernate.Session;

import org.hibernate.query.Query;

import java.util.List;

/**
 * @author MrRobot121
 * @version 1.0 ---------------------------------
 *
 */
/**
 * DAO para operaciones CRUD de entidades {@link Usuarios}. Incluye métodos específicos de autenticación y validación de usuarios con gestión segura de contraseñas mediante {@link GestorContraseñas}.
 *
 * @author HugoJB
 * @see DaoInterface
 */
public class DaoUser implements DaoInterface<Usuarios> {

    /**
     *
     * @param identificador User nombre o email acepta los dos
     * @param contrasenaPlana contraseña en texto plano introducida por el usuario
     * @return objeto Usuarios si las credenciales son correctas, null en caso contrario
     */
    public static Usuarios buscarPorCredenciales(String identificador, String contrasenaPlana) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            // Buscar por nombre de usuario O email
            org.hibernate.query.Query<Usuarios> query = session.createQuery(
                    "FROM Usuarios u WHERE u.nombreUser = :id OR u.email = :id",
                    Usuarios.class
            );
            query.setParameter("id", identificador);

            Usuarios usuario = query.uniqueResult();

            //  texto plano vs hash en BD no la guarda ni la trasmite solo compara el hash con la plana
            if (usuario != null && GestorContraseñas.checkPassword(contrasenaPlana, usuario.getContrasena())) {
                return usuario;
            }
            return null;
        }
    }

    /**
     * Busca un usuario por email.
     *
     * @param email email del usuario
     * @return usuario encontrado o null si no existe
     */
    public static Usuarios buscarPorEmail(String email) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Usuarios u WHERE u.email = :email", Usuarios.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    /**
     * Comprueba si existe un usuario con ese nombre de usuario o email.
     *
     * @param nombreUser nombre de usuario
     * @param email email del usuario
     * @return true si existe, false si no
     */
    public static boolean existeUsuarioONombre(String nombreUser, String email) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            Long count = session.createQuery(
                    "SELECT COUNT(u) FROM Usuarios u WHERE u.nombreUser = :user OR u.email = :email",
                    Long.class)
                    .setParameter("user", nombreUser)
                    .setParameter("email", email)
                    .uniqueResult();
            return count != null && count > 0;
        }
    }

    /**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param usuario objeto Usuarios a persistir
     * @return true si se guarda correctamente, false si hay error
     */
    public static boolean guardarUsuario(Usuarios usuario) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(usuario);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Inserta un nuevo registro en la base de datos.
     *
     * @param dato objeto que contiene los datos a insertar
     */
    @Override
    public void insert(Usuarios dato) {
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
    public Usuarios fetchOne(int id) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Usuarios.class, id);
        }
    }

    /**
     * Recupera todos los registros de la tabla asociada.
     *
     * @return lista con todos los objetos encontrados (puede estar vacía)
     */
    @Override
    public List<Usuarios> fetchAll() {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("FROM Usuarios", Usuarios.class)
                    .getResultList();
        }
    }

    /**
     * Actualiza un registro existente en la base de datos.
     *
     * @param dato objeto con los nuevos valores a actualizar
     */
    @Override
    public void update(Usuarios dato) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(dato);   // merge por si el objeto viene detached
            session.getTransaction().commit();
        }
    }

    /**
     * Elimina un registro de la base de datos según su identificador.
     *
     * @param id identificador del registro a eliminar
     */
    @Override
    public void delete(int id) {
        try (org.hibernate.Session session = Dao.Util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Usuarios u = session.get(Usuarios.class, id);
            if (u != null) {
                session.remove(u);
            }
            session.getTransaction().commit();
        }
    }
}
