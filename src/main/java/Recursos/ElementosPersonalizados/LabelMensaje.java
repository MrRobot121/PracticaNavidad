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
import javax.swing.JLabel;

public class LabelMensaje extends JLabel {

    private static final int WIDTH = 400;
@Override
    public void setText(String texto) {
        String html =
            "<html><body style='width:" + WIDTH +
            "px; color: rgb(220,220,230);'>" +
            texto +
            "</body></html>";
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        super.setText(html);
    }
}

