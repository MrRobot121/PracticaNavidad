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
package Recursos;

import java.util.Date;

public class Fechas {
public  static String formatearFecha(Date fecha) {
    if (fecha == null) {
        return "";
    }
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(fecha);
}

}
