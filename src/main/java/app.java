
import java.util.Locale;
import java.util.ResourceBundle;

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
 * @author MrRobot121
 * @author Hugo JB
 * @version 1.0 ---------------------------------
 * @see
 */
public class app {
    public static void main(String[] args) {
        ResourceBundle rs=ResourceBundle.getBundle("messages",new Locale("es"));
        System.out.println("ghhgg"+rs.getString("prueba"));
    }
}
