package Dao.Util;

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


import Dao.Modelo.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * @author MrRobot121
 * @author Hugo JB
 * @version 1.0 ---------------------------------
 * @see
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Dao.Modelo.Usuarios;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();

            // Propiedades directas (sin archivo properties)
            config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Inventario_Hogar?useSSL=false&serverTimezone=UTC");
            config.setProperty("hibernate.connection.username", "root");
            config.setProperty("hibernate.connection.password", "root");
            config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            config.setProperty("hibernate.show_sql", "true");
            config.setProperty("hibernate.format_sql", "true");
            config.setProperty("hibernate.hbm2ddl.auto", "validate");
//config.setProperty("hibernate.jdbc.show_warnings", "false");

//SILENCIAR LOGS
 /*           config.setProperty("hibernate.jdbc.show_warnings", "false");
config.setProperty("hibernate.generate_statistics", "false");
config.setProperty("org.hibernate.engine.jdbc.internal.JdbcConnectionAccessImpl", "false");
config.setProperty("hibernate.jmx.enabled", "false");  // ← MÁS LIMPIO
*/
            // Entidades
            config.addAnnotatedClass(Usuarios.class);
            config.addAnnotatedClass(Producto.class);
            config.addAnnotatedClass(Categoria.class);
            config.addAnnotatedClass(RegistroInicio.class);
            config.addAnnotatedClass(RegistroRecuperacion.class);

            config.addAnnotatedClass(ListaCompra.class);

            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
