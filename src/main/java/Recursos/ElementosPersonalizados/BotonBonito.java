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

        // Colores
        setBackground(new Color(52, 152, 219));   // azul bonito
        setForeground(Color.WHITE);              // texto blanco

        // Fuente “chula”
        setFont(new Font("SansSerif", Font.BOLD, 16));

        // Quitar cosas feas
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(true);
        setOpaque(true);

        // Un poco de padding para que no quede enano
        setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
    }
}
