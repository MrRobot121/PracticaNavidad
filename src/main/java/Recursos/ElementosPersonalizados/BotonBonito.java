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
 * @author MrRobot121
 * @version 1.0
 * @see
 */
package Recursos.ElementosPersonalizados;

import javax.swing.*;
import java.awt.*;

public class BotonBonito extends JButton {

    public BotonBonito(String texto) {
        super(texto);
  // morado estilo iOS
        setBackground(new Color(88, 86, 214));    
        setForeground(Color.WHITE);                

        setFont(new Font("Segoe UI", Font.BOLD, 15));

        // Quitar cosas feas
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(true);
        setOpaque(true);

        // Padding un poco más cómodo
        setBorder(BorderFactory.createEmptyBorder(10, 24, 10, 24));

        // Opcional: cursor de mano al pasar por encima
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}

