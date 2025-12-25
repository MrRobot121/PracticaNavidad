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
 * @version 1.0
 * @see
 */
package Recursos.ElementosPersonalizados;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TextFieldOscuro extends JTextField {

    public TextFieldOscuro(int columns) {
        super(columns);

        // Fondo oscuro suave y texto claro
        setBackground(new Color(40, 40, 48));
        setForeground(new Color(230, 230, 235));

        // Misma fuente que los labels/botones
        setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Borde redondeado/suave
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(88, 86, 214)), // morado
                BorderFactory.createEmptyBorder(4, 8, 4, 8) // padding interno
        ));

        // Careto de inserción blanco
        setCaretColor(Color.WHITE);
    }
}
