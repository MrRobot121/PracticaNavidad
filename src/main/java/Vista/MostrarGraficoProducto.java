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
package Vista;

import Dao.Daos.DaoProducto;
import Dao.Modelo.Producto;
import Recursos.CuadroDiologo;
import Recursos.ResurceBundle;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.data.category.DefaultCategoryDataset;

public class MostrarGraficoProducto  extends  JFrame{
    public static void main(String[] args) {
        System.out.println("fv");
    }
String idioma;
    public MostrarGraficoProducto(String idioma) throws HeadlessException {
                ResurceBundle.setLocale(idioma);

             getContentPane().setBackground(new Color(30, 30, 35));  
                     initComponents();

    }

    private void initComponents() {
  DaoProducto dp=new DaoProducto();
 List<Producto>ls =dp.fetchAll();
 if(ls==null||ls.isEmpty()){
 //SALIR DE KA PESTAÑÑA 
     CuadroDiologo.mostrarAviso(this, ResurceBundle.t("label.error"), "label.noData",JOptionPane.ERROR_MESSAGE );
 }
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
