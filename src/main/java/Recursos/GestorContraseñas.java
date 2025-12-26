package Recursos;

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

import com.password4j.*;

/**
 * @author MrRobot121
 * @author Hugo JB
 * @version 1.0 ---------------------------------
 * @see
 */
public class GestorContraseñas {
        /**
     * Genera hash BCrypt de una contraseña
     */
    public static String hashPassword(String password) {
        Hash hash = Password.hash(password).withBcrypt();
        return hash.getResult();
    }

    /**
     * Verifica contraseña contra hash
     */
    public static boolean checkPassword(String password, String hash) {
        return Password.check(password, hash).withBcrypt();
    }
}
