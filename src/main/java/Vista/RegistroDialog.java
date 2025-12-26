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
package Vista;

import Dao.Daos.DaoUser;
import Dao.Modelo.Usuarios;
import Recursos.ElementosPersonalizados.BotonBonito;
import Recursos.ElementosPersonalizados.LabelBonito;
import Recursos.ElementosPersonalizados.LabelMensaje;
import Recursos.ElementosPersonalizados.LabelTitulo;
import Recursos.ElementosPersonalizados.PanelBonito;
import Recursos.ElementosPersonalizados.TextPaneBonito;
import Recursos.GestorContraseñas;
import Recursos.ResurceBundle;
import java.awt.*;
import javax.swing.*;

public class RegistroDialog extends JDialog {
    
  private TextPaneBonito nombreUserField, emailField, nombreField, apellidoField;
    private JPasswordField contrasenaField;
    private LabelMensaje mensajeLabel;
    private LabelTitulo tituloLabel;
    private BotonBonito btnRegistrar, btnCancelar;

    private LabelBonito lblUser, lblEmail, lblPass, lblNombre, lblApellido;

    public RegistroDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        actualizarElementosIdioma();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        PanelBonito panel = new PanelBonito();
        panel.setBackground(new Color(30, 30, 35));

        tituloLabel = new LabelTitulo("");
        mensajeLabel = new LabelMensaje( );

        lblUser     = new LabelBonito("");
        lblEmail    = new LabelBonito("");
        lblPass     = new LabelBonito("");
        lblNombre   = new LabelBonito("");
        lblApellido = new LabelBonito("");

        nombreUserField = new TextPaneBonito();
        emailField      = new TextPaneBonito();
        nombreField     = new TextPaneBonito();
        apellidoField   = new TextPaneBonito();

        contrasenaField = new JPasswordField();
        contrasenaField.setBackground(new Color(45, 45, 50));
        contrasenaField.setForeground(Color.WHITE);

        btnRegistrar = new BotonBonito("");
        btnCancelar  = new BotonBonito("");

        btnCancelar.addActionListener(e -> dispose());
        btnRegistrar.addActionListener(e -> registrarUsuario());

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // HORIZONTAL
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(tituloLabel)
                .addComponent(mensajeLabel)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(lblUser)
                        .addComponent(lblEmail)
                        .addComponent(lblPass)
                        .addComponent(lblNombre)
                        .addComponent(lblApellido)
                    )
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nombreUserField, 250, 250, Short.MAX_VALUE)
                        .addComponent(emailField,      250, 250, Short.MAX_VALUE)
                        .addComponent(contrasenaField, 250, 250, Short.MAX_VALUE)
                        .addComponent(nombreField,     250, 250, Short.MAX_VALUE)
                        .addComponent(apellidoField,   250, 250, Short.MAX_VALUE)
                    )
                )
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnCancelar)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnRegistrar)
                    .addGap(0, 0, Short.MAX_VALUE)
                )
        );

        // VERTICAL
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(tituloLabel)
                .addComponent(mensajeLabel)
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(nombreUserField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(emailField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(contrasenaField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(nombreField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(apellidoField))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegistrar))
        );

        setContentPane(panel);
        setPreferredSize(new Dimension(550, 350));
        pack();
    }

    private void actualizarElementosIdioma() {
        tituloLabel.setText(ResurceBundle.t("register.title"));
        mensajeLabel.setText("");

        lblUser.setText(ResurceBundle.t("label.username"));
        lblEmail.setText(ResurceBundle.t("label.email"));
        lblPass.setText(ResurceBundle.t("label.password"));
        lblNombre.setText(ResurceBundle.t("label.name"));
        lblApellido.setText(ResurceBundle.t("label.apellido"));

        btnRegistrar.setText(ResurceBundle.t("button.register"));
        btnCancelar.setText(ResurceBundle.t("button.cancel"));
    }

    private void registrarUsuario() {
        String nombreUser = nombreUserField.getText().trim();
        String email = emailField.getText().trim();
        String contrasenaPlana = new String(contrasenaField.getPassword()).trim();
        String nombre = nombreField.getText().trim();
        String apellido = apellidoField.getText().trim();
        
        if (nombreUser.isEmpty() || email.isEmpty() || contrasenaPlana.isEmpty() || 
            nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, ResurceBundle.t("register.required"), 
                ResurceBundle.t("register.title"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (Dao.Daos.DaoUser.existeUsuarioONombre(nombreUser, email)) {
            JOptionPane.showMessageDialog(this, ResurceBundle.t("register.exists"), 
                ResurceBundle.t("register.title"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!esEmailValido(email)) {
    JOptionPane.showMessageDialog(
        this,
        ResurceBundle.t("error.email.invalid"),
        ResurceBundle.t("register.title"),
        JOptionPane.ERROR_MESSAGE
    );
    return;
}
        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setNombreUser(nombreUser);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setContrasena(GestorContraseñas.hashPassword(contrasenaPlana));
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        
        if (Dao.Daos.DaoUser.guardarUsuario(nuevoUsuario)) {
            JOptionPane.showMessageDialog(this, ResurceBundle.t("register.success"), 
                ResurceBundle.t("register.title"), JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
    private boolean esEmailValido(String email) {
    String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    return email.matches(regex);
}
}


