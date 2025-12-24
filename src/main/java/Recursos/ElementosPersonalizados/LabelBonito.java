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

        // Texto gris claro para fondos oscuros
        setForeground(new Color(220, 220, 230));
        // Centrar texto
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        // Fuente ligera y legible
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
    }
}
