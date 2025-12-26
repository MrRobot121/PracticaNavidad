
import Dao.Daos.DaoUser;
import Dao.Modelo.Usuarios;
import Recursos.GestorContraseñas;

import java.util.Locale;
import java.util.ResourceBundle;

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
 * @author MrRobot121
 * @author Hugo JB
 * @version 1.0 ---------------------------------
 * @see
 */
public class app {
    public static void main(String[] args) {
        ResourceBundle rs=ResourceBundle.getBundle("messages",new Locale("es"));
        System.out.println("ghhgg"+rs.getString("prueba"));
//System.out.println("Nuevo hash BCrypt: " + GestorContraseñas.hashPassword("1234"));

//base
        Usuarios usuarioEncontrado = DaoUser.buscarPorCredenciales("Hugo", "1234");

    if (usuarioEncontrado == null) {
        System.out.println("Nada");


      //  return;
    }else {
                System.out.println("✅ USUARIO ENCONTRADO:");
        System.out.println("ID: " + usuarioEncontrado.getId());
        System.out.println("Nombre: " + usuarioEncontrado.getNombre());
        System.out.println("Usuario: " + usuarioEncontrado.getNombreUser());
        System.out.println("Email: " + usuarioEncontrado.getEmail());
    }

    }
}
