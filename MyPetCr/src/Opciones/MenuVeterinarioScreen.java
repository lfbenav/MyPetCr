package Opciones;

import Citas.CrearCitaScreen;
import Citas.VerCitasProgramadasScreen;
import SQL.UsuariosAccess;
import Usuarios.Cliente;
import Usuarios.Usuario;
import Usuarios.Veterinario;
import eCommerce.eCommerceScreen;
import javax.swing.JOptionPane;

/**
 *
 * @author lfben
 */
public class MenuVeterinarioScreen extends MenuUsuario {

    eCommerceScreen referencia;
    
    public MenuVeterinarioScreen(eCommerceScreen referencia) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.referencia = referencia;
        this.setSize(this.referencia.getSize());
        this.setLocation(this.referencia.getLocation());
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
        jLabel8 = new javax.swing.JLabel();
        btnVerClientes = new javax.swing.JButton();
        btnVerCitasProgramadas = new javax.swing.JButton();
        btnCrearCita = new javax.swing.JButton();
        btnMascotasRegistradas = new javax.swing.JButton();

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
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
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
        jLabel7.setText("Opciones");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Tipo de usuario: Veterinario");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnVerClientes.setBackground(new java.awt.Color(224, 123, 79));
        btnVerClientes.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnVerClientes.setText("Ver clientes registrados");
        btnVerClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerClientesActionPerformed(evt);
            }
        });

        btnVerCitasProgramadas.setBackground(new java.awt.Color(224, 123, 79));
        btnVerCitasProgramadas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerCitasProgramadas.setForeground(new java.awt.Color(255, 255, 255));
        btnVerCitasProgramadas.setText("Ver mis citas programadas");
        btnVerCitasProgramadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerCitasProgramadasActionPerformed(evt);
            }
        });

        btnCrearCita.setBackground(new java.awt.Color(224, 123, 79));
        btnCrearCita.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnCrearCita.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCita.setText("Programar una cita");
        btnCrearCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCitaActionPerformed(evt);
            }
        });

        btnMascotasRegistradas.setBackground(new java.awt.Color(224, 123, 79));
        btnMascotasRegistradas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnMascotasRegistradas.setForeground(new java.awt.Color(255, 255, 255));
        btnMascotasRegistradas.setText("Ver mascotas registradas");
        btnMascotasRegistradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMascotasRegistradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(btnVerClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerCitasProgramadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMascotasRegistradas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMascotasRegistradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerCitasProgramadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearCita)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnVerClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerClientesActionPerformed
        MenuVeterinarioScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerClientesScreen nuevaVentana = new VerClientesScreen(estaVentana, Usuario.VETERINARIO);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_btnVerClientesActionPerformed

    private void btnVerCitasProgramadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCitasProgramadasActionPerformed
        
        //mandar a la lista de citas programadas y permitir seleccionar y atenderla
        
        MenuVeterinarioScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerCitasProgramadasScreen nuevaVentana = new VerCitasProgramadasScreen(this, (Veterinario) referencia.getUsuario());
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
        
    }//GEN-LAST:event_btnVerCitasProgramadasActionPerformed

    private void btnCrearCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCitaActionPerformed

        String correo = JOptionPane.showInputDialog("Escriba el correo del cliente");
        Cliente usuario = (Cliente)UsuariosAccess.clientePorCorreo(correo);
        if(usuario == null){
            JOptionPane.showMessageDialog(null, "Correo inválido.");
        }else{
            new CrearCitaScreen(this, (Veterinario)referencia.getUsuario(), usuario).setVisible(true);
        }

    }//GEN-LAST:event_btnCrearCitaActionPerformed

    private void btnMascotasRegistradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMascotasRegistradasActionPerformed

        MenuVeterinarioScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerMascotasScreen nuevaVentana = new VerMascotasScreen(this, (Veterinario) referencia.getUsuario());
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
                
    }//GEN-LAST:event_btnMascotasRegistradasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCita;
    private javax.swing.JButton btnMascotasRegistradas;
    private javax.swing.JButton btnVerCitasProgramadas;
    private javax.swing.JButton btnVerClientes;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
