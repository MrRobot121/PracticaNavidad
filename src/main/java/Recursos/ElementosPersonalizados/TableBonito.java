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
import javax.swing.JTable;

public class TableBonito extends JTable {

    public TableBonito() {
// Fondo algo más claro que el fondo general
        setBackground(new Color(45, 45, 55));
        setForeground(new Color(235, 235, 240));

        // Selección muy clara
        setSelectionBackground(new Color(120, 130, 255));
        setSelectionForeground(Color.WHITE);

        setFont(new Font("Segoe UI", Font.PLAIN, 13));
        setRowHeight(26);

        // Bordes visibles
        setShowHorizontalLines(true);
        setShowVerticalLines(true);
        setGridColor(new Color(80, 80, 95));

        // Cabecera clara con texto oscuro
        getTableHeader().setBackground(new Color(220, 220, 230));
        getTableHeader().setForeground(new Color(40, 40, 50));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
    }
    }


