package Opciones;

import Citas.AtenderCitaScreen;
import SQL.MascotasAccess;
import Usuarios.Mascota;
import Usuarios.Veterinario;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

/**
 *
 * @author lfben
 */
public class VerMascotasScreen extends javax.swing.JFrame {

    public Veterinario encargado = null;
    ArrayList<Mascota> mascotas;
    public Mascota mascotaSeleccionada = null;
    
    public VerMascotasScreen(JFrame referencia) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setSize(referencia.getSize());
        this.setLocation(referencia.getLocation());
        btnAgregarExpediente.setEnabled(false);
        cargarListaMascotas();
    }
    
    public VerMascotasScreen(JFrame referencia, Veterinario veterinario) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setSize(referencia.getSize());
        this.setLocation(referencia.getLocation());
        this.encargado = veterinario;
        cargarListaMascotas();
    }

    
    private void cargarListaMascotas(){
        DefaultListModel lista = new DefaultListModel();
        listaMascotas.setModel(lista);
        
        this.mascotas = MascotasAccess.getTodasLasMascotas();
        
        for(Mascota m : mascotas){
            lista.addElement(" ("+ m.id + ") "+ m.nombre + ", de " + m.nombreUsuario);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMascotas = new javax.swing.JList<>();
        btnVerExpediente = new javax.swing.JButton();
        btnAgregarExpediente = new javax.swing.JButton();

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
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
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
        jLabel7.setText("Mascotas");

        jScrollPane2.setOpaque(false);

        listaMascotas.setBackground(new java.awt.Color(237, 241, 242));
        listaMascotas.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        listaMascotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMascotasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaMascotas);

        btnVerExpediente.setBackground(new java.awt.Color(224, 123, 79));
        btnVerExpediente.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerExpediente.setForeground(new java.awt.Color(255, 255, 255));
        btnVerExpediente.setText("Revisar Expediente");
        btnVerExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerExpedienteActionPerformed(evt);
            }
        });

        btnAgregarExpediente.setBackground(new java.awt.Color(224, 123, 79));
        btnAgregarExpediente.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnAgregarExpediente.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarExpediente.setText("Revisión de emegencia");
        btnAgregarExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarExpedienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnVerExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerExpediente)
                    .addComponent(btnAgregarExpediente))
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

    private void listaMascotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMascotasMouseClicked
        String seleccion = listaMascotas.getSelectedValue();
        for(Mascota m : this.mascotas){
            if((" ("+ m.id + ") "+ m.nombre + ", de " + m.nombreUsuario).equals(seleccion)){
                mascotaSeleccionada = m;
            }
        }

    }//GEN-LAST:event_listaMascotasMouseClicked

    private void btnVerExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerExpedienteActionPerformed

        if(mascotaSeleccionada == null){
            return;
        }

        JFrame estaVentana = this;
        estaVentana.setVisible(false);

        ExpedienteMascotaScreen nuevaVentana = new ExpedienteMascotaScreen(mascotaSeleccionada, estaVentana);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });

        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_btnVerExpedienteActionPerformed

    private void btnAgregarExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarExpedienteActionPerformed

        if(mascotaSeleccionada == null){
            return;
        }
        if(encargado == null){
            return;
        }

        new AtenderCitaScreen(encargado, mascotaSeleccionada, this).setVisible(true);

    }//GEN-LAST:event_btnAgregarExpedienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarExpediente;
    private javax.swing.JButton btnVerExpediente;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaMascotas;
    // End of variables declaration//GEN-END:variables
}
