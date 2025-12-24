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
 *@author HugoJB
 *@author MrRobot121
 *@version 1.0 
 *@see  
 */

package Recursos.ElementosPersonalizados;


import javax.swing.*;
import java.awt.*;

public class LabelTitulo extends JLabel {

    public LabelTitulo(String texto) {
        super(texto);

        setForeground(new Color(52, 152, 219));
        setFont(new Font("SansSerif", Font.BOLD, 22));

        // Centrar texto dentro del label
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER); // opcional

        // Si quieres que ocupe bien el espacio:
        // setOpaque(true);
        // setBackground(Color.WHITE);
    }
}

