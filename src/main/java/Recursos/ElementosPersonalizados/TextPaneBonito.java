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
import javax.swing.JTextPane;

public class TextPaneBonito extends JTextPane {

    public TextPaneBonito() {
        super();

        // Fondo oscuro suave y texto claro
        setBackground(new Color(40, 40, 48));
        setForeground(new Color(230, 230, 235));

        // Misma fuente que el resto
        setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Borde con padding
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(88, 86, 214)),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));

        setCaretColor(Color.WHITE);
    }
}

