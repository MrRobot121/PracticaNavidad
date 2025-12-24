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

        // Acento morado a juego con el botón
        setForeground(new Color(88, 86, 214));

        // Título grande y claro
        setFont(new Font("Segoe UI", Font.BOLD, 24));

        // Centrar texto
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);

        // destaque sobre fondo oscuro
        setOpaque(true);
         setBackground(new Color(30, 30, 35));
    }
}


