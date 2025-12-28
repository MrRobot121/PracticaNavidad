package Controlador;

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

import Dao.Daos.DaoProducto;
import Dao.Modelo.Producto;
import Dao.Modelo.Usuarios;
import Vista.Principal;
import java.awt.Frame;

/**POR AHORA METO METODOS COMUNES QUE SE REPITEN VARIAS VECES
 * @author MrRobot121
 * @author Hugo JB
 * @version 1.0 ---------------------------------
 * @see
 */
public class Controlador {
      /**
     * ACtualiza la cantidad del producto Y LO GUARDA EN BASE DATOS
     *
     * @param p
     * @param i LE SUMA A LA CANTIDAD SI ES NEGATIVO LOGICAMENTE LE RESTA
     */
    public static void modifiacarCantidad(Producto p, int i) {
        if (p == null) {
            return;
        }

        int nuevaCantidad = p.getCantidad() + i;
        if (nuevaCantidad < 0) {
            nuevaCantidad = 0;
        }

        p.setCantidad(nuevaCantidad);

        // Guardar en BD
        DaoProducto dao = new DaoProducto();
        dao.update(p);


    }
    public static  void goPrincipal(Frame fr,Usuarios user ){
          fr.dispose();
        Principal pr = new Principal(user);
        pr.setVisible(true);
        pr.setLocationRelativeTo(null);
    }
}
