package Recursos;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
public class CuadroDiologo {
    
    /**
     * Muestra un diálogo con mensaje
     * @param frame JFrame padre
     * @param titulo Título del diálogo
     * @param mensaje Mensaje a mostrar
     * @param tipoMensaje Tipo: JOptionPane.INFORMATION_MESSAGE, ERROR_MESSAGE, WARNING_MESSAGE, etc.
     */
public static void mostrarAviso(JFrame frame, String titulo, String mensaje, int tipoMensaje) {
        JOptionPane.showMessageDialog(
                frame,
                mensaje,
                titulo,
                tipoMensaje
        );
    }
}
