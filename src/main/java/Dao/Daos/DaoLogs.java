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

import Dao.Modelo.RegistroInicio;
import Dao.Modelo.Usuarios;
import Dao.Util.HibernateUtil;
/**
 * DAO para registro de logs de actividad del sistema.
 * Actualmente implementa solo el registro de inicios de sesión de usuarios.
 * 
 * @author HugoJB
 */
public class DaoLogs {
  /**
     * Registra un nuevo inicio de sesión de usuario en la base de datos.
     * Crea un objeto {@link RegistroInicio} con la fecha/hora actual
     * y lo persiste usando Hibernate con gestión de transacciones.
     *
     * @param user Usuario que ha iniciado sesión.
     * @throws RuntimeException si falla la persistencia del log.
     */
    public static void registrarInicio(Usuarios user) {
        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction tx = session.beginTransaction();
            try {
                RegistroInicio ri = new RegistroInicio();
                ri.setIdUser(user);
                ri.setInicioSesion(new java.util.Date()); // fecha y hora actuales 

                session.persist(ri);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

}
