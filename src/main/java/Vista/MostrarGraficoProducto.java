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
package Vista;

import Dao.Daos.DaoCategoria;
import Dao.Daos.DaoProducto;
import Dao.Daos.DaoUser;
import Dao.Modelo.Categoria;
import Dao.Modelo.Producto;
import Dao.Modelo.Usuarios;
import Recursos.CuadroDiologo;
import Recursos.ElementosPersonalizados.BotonBonito;
import Recursos.ResurceBundle;
import java.awt.Color;
import java.awt.Frame;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 * Ventana de visualización de gráfico de productos por cantidad.
 * Muestra un gráfico de barras con todos los productos del usuario
 * (nombre vs cantidad actual) en un diálogo emergente.
 *
 *
 */
public class MostrarGraficoProducto extends JDialog {

    private Usuarios usuarios;
    private String idioma;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MostrarGraficoProducto.class.getName());
    private final JFrame parent;

    /**
     * Crea el diálogo con gráfico de productos del usuario.
     *
     * @param parent  Ventana padre (Principal).
     * @param idioma  Código de idioma actual.
     * @param usuario Usuario propietario de los productos.
     */
    public MostrarGraficoProducto(JFrame parent, String idioma, Usuarios usuario) {
        super(parent, true); // modal
        this.usuarios = usuario;
        this.idioma = idioma;
        this.parent=parent;
        ResurceBundle.setLocale(idioma);
        
        if (usuario == null) {
            CuadroDiologo.mostrarAviso( parent,
                    ResurceBundle.t("label.error"),
                    ResurceBundle.t("error.noUser"),
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        initComponents();
    }

    /**
     * Inicializa componentes: obtiene productos, construye dataset y crea gráfico.
     */
    private void initComponents() {
        // Obtener productos del usuario actual
        List<Producto> productos = DaoProducto.buscarPorUsuario(usuarios.getId());
        
        if (productos == null || productos.isEmpty()) {
            CuadroDiologo.mostrarAviso(
                    parent,
                    ResurceBundle.t("label.error"),
                    ResurceBundle.t("label.noData"),
                    JOptionPane.ERROR_MESSAGE
            );
            this.dispose();
            return;
        }

        // Crear dataset para el gráfico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        // Llenar dataset con nombre de producto y cantidad
        for (Producto p : productos) {
            dataset.addValue(
                    p.getCantidad(),
                    ResurceBundle.t("table.product.quantity"),  // Serie (leyenda)
                    p.getNombre()                                // Categoría (eje X)
            );
        }

        // Crear gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                ResurceBundle.t("label.productInventory"),      // Título
                ResurceBundle.t("table.product.name"),          // Eje X
                ResurceBundle.t("table.product.quantity"),      // Eje Y
                dataset,                                         // Datos
                PlotOrientation.VERTICAL,                       // Orientación
                true,                                            // Leyenda
                true,                                            // Tooltips
                false                                            // URLs
        );

        // Personalizar apariencia del gráfico
        chart.setBackgroundPaint(new Color(30, 30, 35));
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(45, 45, 55));
        plot.setRangeGridlinePaint(new Color(80, 80, 95));
        
        // Colores de las barras
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(50, 184, 198)); // Teal
        renderer.setSeriesOutlinePaint(0, new Color(33, 128, 141));

        // Crear panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
        chartPanel.setBackground(new Color(30, 30, 35));

        // Configurar diálogo
        setTitle(ResurceBundle.t("label.productInventory"));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(850, 600);
        setLocationRelativeTo(getOwner()); // Centra respecto a Principal
        setResizable(true);
        
        // Añadir gráfico al diálogo
        add(chartPanel, java.awt.BorderLayout.CENTER);
        
        // Panel inferior con botón cerrar
        javax.swing.JPanel panelBottom = new javax.swing.JPanel();
        panelBottom.setBackground(new Color(30, 30, 35));
        
        BotonBonito btnCerrar = new BotonBonito(ResurceBundle.t("button.close"));
        btnCerrar.addActionListener(e -> this.dispose());
        
        panelBottom.add(btnCerrar);
        add(panelBottom, java.awt.BorderLayout.SOUTH);
    }

    /**
     * PEJECUTA ESTO SOLO SI QUIERES PROBAR GRAFICOS SILVIA /ALEX
     */
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {

        // 1) Usuario de prueba COMPLETO
        Usuarios user = new Usuarios();
        user.setNombreUser("testuser");
        user.setNombre("NombreTest");
        user.setApellido("ApellidoTest");     
        user.setEmail("test@local");
        user.setContrasena("hashPrueba");     

        DaoUser daoUser = new DaoUser();
        daoUser.insert(user);               

        // 2) Categoría de prueba
        Categoria cat = new Categoria();
        cat.setNombre("Pruebas");
        DaoCategoria daoCat = new DaoCategoria();
        daoCat.insert(cat);

        // 3) Productos de prueba
        Producto p1 = new Producto();
        p1.setNombre("Manzanas");
        p1.setCantidad(5);
        p1.setCantidadMinDeseada(2);
        p1.setIdUser(user);
        p1.setIdCategoria(cat);

        Producto p2 = new Producto();
        p2.setNombre("Leche");
        p2.setCantidad(1);
        p2.setCantidadMinDeseada(3);
        p2.setIdUser(user);
        p2.setIdCategoria(cat);

        DaoProducto daoProd = new DaoProducto();
        daoProd.insert(p1);
        daoProd.insert(p2);

        // 4) Padre dummy + gráfico
        JFrame frame = new JFrame("Padre dummy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        MostrarGraficoProducto dialog = new MostrarGraficoProducto(
                frame,
                "es",
                user
        );
        dialog.setVisible(true);
    });
}



}

