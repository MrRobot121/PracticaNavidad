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
import javax.swing.*;
import java.awt.*;

public class PanelBonito extends JPanel {

    public PanelBonito() {
        // Fondo oscuro a juego con el JFrame
        setBackground(new Color(30, 30, 35));

        // Color por defecto para bordes o separaciones
        setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        // Si quieres que use siempre el mismo Layout (por ejemplo, BoxLayout)
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}

