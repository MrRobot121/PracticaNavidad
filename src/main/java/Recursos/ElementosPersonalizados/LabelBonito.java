package Recursos.ElementosPersonalizados;

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


import javax.swing.*;
import java.awt.*;

public class LabelBonito extends JLabel {

    public LabelBonito(String texto) {
        super(texto);

        // Misma gama de colores que el botón
        setForeground(new Color(52, 152, 219));      // texto azul
        // Si quieres fondo también:
        // setOpaque(true);
        // setBackground(Color.WHITE);

        // Fuente 14 pt
        setFont(new Font("SansSerif", Font.BOLD, 14));
    }
}
