package Recursos;

import java.awt.Frame;
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
public  static boolean confirmarEliminacion(Frame frame) {
    Object[] opciones = {
        ResurceBundle.t("button.yes"),    // "Sí"
        ResurceBundle.t("button.no")      // "No"
    };
    
    int opcion = JOptionPane.showOptionDialog(
        frame,
        ResurceBundle.t("dialog.confirmDelete.message"),  // "¿Estás seguro de que quieres eliminar este producto?"
        ResurceBundle.t("dialog.confirmDelete.title"),    // "Confirmar eliminación"
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opciones,
        opciones[1]  // "No" por defecto
    );
    
    return opcion == JOptionPane.YES_OPTION;
}
}
