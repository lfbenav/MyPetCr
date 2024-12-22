package Opciones;

import Notificaciones.Encriptar;
import SQL.UsuariosAccess;
import Usuarios.Sucursal;
import Usuarios.Usuario;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author lfben
 */
public class RegistroScreen extends javax.swing.JFrame {

    int tipoUsuario;
    
    public RegistroScreen(MenuUsuario referencia, int tipoUsuario) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setSize(referencia.getSize());
        this.setLocation(referencia.getLocation());
        this.tipoUsuario = tipoUsuario;
        
        cargarInfo();
    }
    
    private void cargarInfo(){
        
        if(tipoUsuario == Usuario.CLIENTE){
            lblTipoUsuario.setText("Tipo de usuario: Cliente");
            lblSucursal.setVisible(false);
            cmbSucursales.setVisible(false);
        }
        if(tipoUsuario == Usuario.ADMINISTRADOR){
            lblTipoUsuario.setText("Tipo de usuario: Administrador");
            cargarSucursales();
        }
        if(tipoUsuario == Usuario.VETERINARIO){
            lblTipoUsuario.setText("Tipo de usuario: Veterinario");
            cargarSucursales();
        }
        
    }
    
    private void cargarSucursales(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbSucursales.setModel(modelo);
        
        ArrayList<Sucursal> sucursales = UsuariosAccess.getSucursales();
        
        for(Sucursal s : sucursales){
            modelo.addElement(s);
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txfCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txfContrasena = new javax.swing.JTextField();
        btnLogin = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        lblSucursal = new javax.swing.JLabel();
        cmbSucursales = new javax.swing.JComboBox<>();
        lblRespuesta = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txfCelular = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(77, 115, 129));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(26, 72, 91));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MyPetsCr");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 199, 167));

        jPanel2.setBackground(new java.awt.Color(237, 241, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Registrar Usuario");

        txfCorreo.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txfCorreo.setToolTipText("");
        txfCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txfCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfCorreoMouseClicked(evt);
            }
        });
        txfCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCorreoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Correo electrónico");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Contraseña");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txfContrasena.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txfContrasena.setToolTipText("");
        txfContrasena.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txfContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfContrasenaMouseClicked(evt);
            }
        });
        txfContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfContrasenaActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(224, 123, 79));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLogin.setText("CONTINUAR");
        btnLogin.setOpaque(true);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });

        lblTipoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTipoUsuario.setText("Tipo de usuario: Gerente");
        lblTipoUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Nombre");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txfNombre.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txfNombre.setToolTipText("");
        txfNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txfNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfNombreMouseClicked(evt);
            }
        });
        txfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreActionPerformed(evt);
            }
        });

        lblSucursal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSucursal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSucursal.setText("Sucursal");
        lblSucursal.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        cmbSucursales.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        cmbSucursales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));

        lblRespuesta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRespuesta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRespuesta.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Celular");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txfCelular.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txfCelular.setToolTipText("");
        txfCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txfCelular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfCelularMouseClicked(evt);
            }
        });
        txfCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCelularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(txfCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTipoUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfCelular, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfContrasena, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSucursal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbSucursales, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(8, 8, 8)
                .addComponent(lblTipoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCorreoActionPerformed

    private void txfContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfContrasenaActionPerformed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        
        String correo = txfCorreo.getText();
        String nombre = txfNombre.getText();
        String celular = txfCelular.getText();
        String contrasena = txfContrasena.getText();
        Sucursal sucursal = (Sucursal)cmbSucursales.getSelectedItem();

        if(correo.equals("") || nombre.equals("") || contrasena.equals("") || celular.equals("")){
            System.out.println("Llene todos los campos");
            return;
        }
        
        String contrasenaEncriptada = Encriptar.EncriptarString(contrasena);
        
        boolean exito = false;
        
        if(tipoUsuario == Usuario.CLIENTE){
            exito = UsuariosAccess.insertCliente(correo, nombre, contrasenaEncriptada, celular);
        }
        else if(tipoUsuario == Usuario.ADMINISTRADOR){
            exito = UsuariosAccess.insertAdministrador(correo, nombre, contrasenaEncriptada, sucursal.id, celular);
        }
        else if(tipoUsuario == Usuario.VETERINARIO){
            exito = UsuariosAccess.insertVeterinario(correo, nombre, contrasenaEncriptada, sucursal.id, celular);
        }
        
        if(exito){
            lblRespuesta.setText("Se ha registrado correctamente");
        }else{
            lblRespuesta.setText("Hubo un error en el registro");
        }
        
        txfCorreo.setText("");
        txfNombre.setText("");
        txfContrasena.setText("");
        txfCelular.setText("");
        
    }//GEN-LAST:event_btnLoginMouseClicked

    private void txfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreActionPerformed

    private void txfCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfCorreoMouseClicked
        lblRespuesta.setText("");
    }//GEN-LAST:event_txfCorreoMouseClicked

    private void txfNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfNombreMouseClicked
        lblRespuesta.setText("");
    }//GEN-LAST:event_txfNombreMouseClicked

    private void txfContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfContrasenaMouseClicked
        lblRespuesta.setText("");
    }//GEN-LAST:event_txfContrasenaMouseClicked

    private void txfCelularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfCelularMouseClicked
        lblRespuesta.setText("");
    }//GEN-LAST:event_txfCelularMouseClicked

    private void txfCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnLogin;
    private javax.swing.JComboBox<String> cmbSucursales;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblRespuesta;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JTextField txfCelular;
    private javax.swing.JTextField txfContrasena;
    private javax.swing.JTextField txfCorreo;
    private javax.swing.JTextField txfNombre;
    // End of variables declaration//GEN-END:variables
}
