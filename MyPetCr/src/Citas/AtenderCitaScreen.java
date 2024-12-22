package Citas;

import Opciones.ExpedienteMascotaScreen;
import SQL.CitasAccess;
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
public class AtenderCitaScreen extends javax.swing.JFrame {

    public Veterinario veterinario;
    public Mascota mascota;
    public ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
    public Cita cita;
    public VerCitasProgramadasScreen referencia = null;
    
    public AtenderCitaScreen(Veterinario veterinario, Mascota mascota, VerCitasProgramadasScreen referencia, Cita cita) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setLocation(referencia.getLocation());
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.cita = cita;
        this.referencia = referencia;
        lblNombreMascota.setText(mascota.nombre);
        cargarLista();
    }
    
    public AtenderCitaScreen(Veterinario veterinario, Mascota mascota, JFrame referencia) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setLocation(referencia.getLocation());
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.cita = CitasAccess.programarCitaEmergente(this.mascota.idUsuario, this.veterinario.id);    
        lblNombreMascota.setText(mascota.nombre);
        cargarLista();
    }
    
    public void cargarLista(){
    
        DefaultListModel lista = new DefaultListModel();
        listaTratamientos.setModel(lista);
                
        for(Medicamento m : medicamentos){
            if(m.costo == 0){
                lista.addElement(m.nombre);
            }
            else{
                lista.addElement(m.nombre + " - " + m.costo + " colones.");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTratamientos = new javax.swing.JList<>();
        btnConfirmar = new javax.swing.JButton();
        lblNombreMascota = new javax.swing.JLabel();
        btnVerExpediente = new javax.swing.JButton();
        btnBorrarLinea = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txaTratamiento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txaCosto = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnAgregarObservacion = new javax.swing.JButton();
        txaObservacion = new javax.swing.JTextField();

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
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
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

        jPanel4.setBackground(new java.awt.Color(237, 241, 242));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Actividades de la cita");

        jScrollPane2.setOpaque(false);

        listaTratamientos.setBackground(new java.awt.Color(237, 241, 242));
        listaTratamientos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        listaTratamientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaTratamientosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaTratamientos);

        btnConfirmar.setBackground(new java.awt.Color(224, 123, 79));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Terminar cita");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblNombreMascota.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreMascota.setForeground(new java.awt.Color(224, 123, 79));
        lblNombreMascota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreMascota.setText("Nombre mascota");
        lblNombreMascota.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnVerExpediente.setBackground(new java.awt.Color(224, 123, 79));
        btnVerExpediente.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerExpediente.setForeground(new java.awt.Color(255, 255, 255));
        btnVerExpediente.setText("Ver expediente");
        btnVerExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerExpedienteActionPerformed(evt);
            }
        });

        btnBorrarLinea.setBackground(new java.awt.Color(224, 123, 79));
        btnBorrarLinea.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnBorrarLinea.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarLinea.setText("Borrar linea");
        btnBorrarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarLineaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNombreMascota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreMascota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnVerExpediente)
                    .addComponent(btnBorrarLinea))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(237, 241, 242));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Insertar Tratamiento / Medicamiento");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnAgregar.setBackground(new java.awt.Color(224, 123, 79));
        btnAgregar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txaTratamiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txaTratamiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txaTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txaTratamientoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Costo (colones)");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txaCosto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txaCosto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txaCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txaCostoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txaCosto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txaTratamiento)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txaTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txaCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(237, 241, 242));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Insertar Observación / Diagnóstico");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnAgregarObservacion.setBackground(new java.awt.Color(224, 123, 79));
        btnAgregarObservacion.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnAgregarObservacion.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarObservacion.setText("Agregar");
        btnAgregarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarObservacionActionPerformed(evt);
            }
        });

        txaObservacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txaObservacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txaObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txaObservacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addComponent(txaObservacion)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAgregarObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarObservacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void listaTratamientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTratamientosMouseClicked

    }//GEN-LAST:event_listaTratamientosMouseClicked

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

        if(cita == null){
            this.dispose();
            return;
        }

        int idEncabezado = MascotasAccess.crearEncabezadoExpediente(mascota.id, veterinario.id, cita.idCita);

        for(Medicamento m : medicamentos){
            MascotasAccess.crearLineaExpediente(idEncabezado, m.nombre, m.costo);
        }
                
        if(referencia != null){
            referencia.cargarListaCitas();
        }
        this.dispose();

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = txaTratamiento.getText().toString();
        String strCosto = txaCosto.getText().toString();
        
        if(nombre.equals("") || strCosto.equals("")){
            return;
        }
        if(!esInt(strCosto)){
            return;
        }
        int costo = Integer.parseInt(strCosto);
        
        txaTratamiento.setText("");
        txaCosto.setText("");
        
        medicamentos.add(new Medicamento(nombre, costo));
        cargarLista();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txaTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txaTratamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txaTratamientoActionPerformed

    private void txaCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txaCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txaCostoActionPerformed

    private void btnBorrarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarLineaActionPerformed

        String seleccion = listaTratamientos.getSelectedValue();
        
        if(seleccion==null){
            return;
        }
        
        for(Medicamento m : medicamentos){
            if(m.costo==0){
                if((m.nombre).equals(seleccion)){
                    medicamentos.remove(m);
                    cargarLista();
                    break;   
                }
            }
            else if((m.nombre + " - " + m.costo + " colones.").equals(seleccion)){
                medicamentos.remove(m);
                cargarLista();
                break;   
            }
        }

    }//GEN-LAST:event_btnBorrarLineaActionPerformed

    private void btnVerExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerExpedienteActionPerformed

        new ExpedienteMascotaScreen(mascota, this).setVisible(true);

    }//GEN-LAST:event_btnVerExpedienteActionPerformed

    private void btnAgregarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarObservacionActionPerformed
        String nota = txaObservacion.getText().toString();
        
        if(nota.equals("")){
            return;
        }

        txaObservacion.setText("");
        
        medicamentos.add(new Medicamento(nota, 0));
        cargarLista();



    }//GEN-LAST:event_btnAgregarObservacionActionPerformed

    private void txaObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txaObservacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txaObservacionActionPerformed

    public boolean esInt(String str){
        try {
            Float.parseFloat(str);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarObservacion;
    private javax.swing.JButton btnBorrarLinea;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVerExpediente;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNombreMascota;
    private javax.swing.JList<String> listaTratamientos;
    private javax.swing.JTextField txaCosto;
    private javax.swing.JTextField txaObservacion;
    private javax.swing.JTextField txaTratamiento;
    // End of variables declaration//GEN-END:variables
}
