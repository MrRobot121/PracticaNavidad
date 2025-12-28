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
import Recursos.ElementosPersonalizados.TextPaneBonito;
import Vista.InicioSesion;
import Vista.NuevoProducto;
import Vista.Principal;
import java.awt.Frame;
import javax.swing.JTextPane;

/**
 * POR AHORA METO METODOS COMUNES QUE SE REPITEN VARIAS VECES
 *
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

    public static void goPrincipal(Frame fr, Usuarios user, String idioma) {
        fr.dispose();
        Principal pr = new Principal(user, idioma);
        pr.setVisible(true);
        pr.setLocationRelativeTo(null);
    }

    public static void goNuevoProducto(Frame fr, Usuarios user, String idioma) {
        // TODO add your handling code here:
        fr.dispose();
        NuevoProducto nv = new NuevoProducto(user, idioma);
        nv.setVisible(true);
        nv.setLocationRelativeTo(null);  // Centra en pantalla
    }

    public static void goInicioSesion(Frame fr, String idioma) {
        // TODO add your handling code here:
        fr.dispose();
        InicioSesion nv = new InicioSesion(idioma);
        nv.setVisible(true);
        nv.setLocationRelativeTo(null);  // Centra en pantalla
    }
    /**
 * Configura Enter en un TextPaneBonito para ejecutar una acción
 * @param campo Campo de texto
 * @param accion Método a ejecutar al pulsar Enter (lambda)
 */
public  static void configurarEnter(JTextPane campo, Runnable accion) {
    campo.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                accion.run();
            }
        }
    });
}

}
