package Recursos;

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
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author MrRobot121
 * @author Hugo JB
 * @version 1.0 ---------------------------------
 * @see
 */
public class ResurceBundle {

    public static final String spanish = "es";
    public static final String english = "en";

    private static ResourceBundle bundle;

    public static void setLocale(String idioma) {
        if (idioma == null || idioma.isEmpty()) {
            idioma = Locale.getDefault().getLanguage();  // Detecta sistema automáticamente
        }

        switch (idioma) {
            case "es":
                idioma = spanish;
                break;
            case "en":
                idioma = english;
                break;
            default:
                idioma = spanish;
                break;
        }
        bundle = ResourceBundle.getBundle("messages", new Locale(idioma));//SOLO TRABAJO CON UNA INSTANCIA DE ESTO Y CUENDO LE PIDA ALGO LO HAGO DESDE AQUI
    }

    /**
     *
     *
     * @param key
     * @return
     */
    public static String t(String key) {
        return bundle.getString(key);
    }

    public static String getIdiomaActual() {
        if (bundle == null) {
            return spanish;  // Default si no hay bundle
        }

        // Extrae el idioma del Locale del bundle actual
        return bundle.getLocale().getLanguage();
    }
}
