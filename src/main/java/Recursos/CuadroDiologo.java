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
 * Utilidad para mostrar cuadros de diálogo estándar en la aplicación. Centraliza los mensajes informativos, de error y las confirmaciones.
 *
 * @author MrRobot121
 * @author Hugo JB
 * @version 1.0
 */
public class CuadroDiologo {

    /**
     * Muestra un cuadro de mensaje simple.
     *
     * @param frame Ventana padre sobre la que se centra el diálogo
     * @param titulo Título del cuadro de diálogo
     * @param mensaje Texto del mensaje a mostrar
     * @param tipoMensaje Tipo de mensaje (por ejemplo,      {@link JOptionPane#INFORMATION_MESSAGE},
     *                     {@link JOptionPane#ERROR_MESSAGE},
     *                     {@link JOptionPane#WARNING_MESSAGE},
     *                     {@link JOptionPane#QUESTION_MESSAGE} o {@link JOptionPane#PLAIN_MESSAGE})
     */
    public static void mostrarAviso(JFrame frame, String titulo, String mensaje, int tipoMensaje) {
        JOptionPane.showMessageDialog(
                frame,
                mensaje,
                titulo,
                tipoMensaje
        );
    }

    /**
     * Muestra un cuadro de confirmación con opciones Sí / No.
     *
     * @param frame Ventana padre sobre la que se centra el diálogo
     * @param pregunta Texto de la pregunta que se mostrará al usuario
     * @param confirmacion Título del cuadro de diálogo de confirmación
     * @return {@code true} si el usuario confirma (Sí), {@code false} si responde No o cierra el diálogo
     */
    public static boolean confirmarEliminacion(Frame frame, String pregunta, String confirmacion) {
        Object[] opciones = {
            ResurceBundle.t("button.yes"), // "Sí"
            ResurceBundle.t("button.no") // "No"
        };

        int opcion = JOptionPane.showOptionDialog(
                frame,
                pregunta, // "¿Estás seguro de que quieres eliminar este producto?"
                confirmacion, // "Confirmar eliminación"
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[1] // "No" por defecto
        );

        return opcion == JOptionPane.YES_OPTION;
    }
}
