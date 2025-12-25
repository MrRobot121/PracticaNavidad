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
package Recursos.ElementosPersonalizados;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class TextAreaBonito extends JTextArea {

    public TextAreaBonito(int rows, int columns) {
        super(rows, columns);

        // Fondo oscuro y texto claro
        setBackground(new Color(40, 40, 48));
        setForeground(new Color(230, 230, 235));

        // Misma fuente que el resto
        setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Que haga salto de línea automático
        setLineWrap(true);
        setWrapStyleWord(true);

        // Borde con padding
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(88, 86, 214)),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));

        setCaretColor(Color.WHITE);
    }
}

