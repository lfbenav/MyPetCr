package Citas;

import SQL.CitasAccess;
import SQL.UsuariosAccess;
import Usuarios.Cliente;
import Usuarios.Sucursal;
import Usuarios.Usuario;
import Usuarios.Veterinario;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lfben
 */
public class CrearCitaScreen extends javax.swing.JFrame {

    public Cliente cliente;
    public Veterinario veterinarioSolicitado = null;
    
    public CrearCitaScreen(JFrame referencia, Cliente cliente) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setLocation(referencia.getLocation());
        this.setSize(referencia.getSize());
        this.cliente = cliente;
        cargarDatos();
    }
    
    public CrearCitaScreen(JFrame referencia, Veterinario veterinario, Cliente usuario) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setLocation(referencia.getLocation());
        this.setSize(referencia.getSize());
        

        this.cliente = usuario;
        this.veterinarioSolicitado = veterinario;
        cargarDatosVeterinario();
    }
    
    private void cargarDatos(){
    
        cargarSucursales();
    
    }
    
    private void cargarDatosVeterinario(){
    
        cmbSucursales.setVisible(false);
        cmbSucursales.setEnabled(false);
        jLabel12.setVisible(false);
           
    }
    
    private void crearCitaVeterinario(){
    
        String fecha = txaFecha.getText().toString();
        String hora = cmbHora.getSelectedItem().toString();
        
        if(fecha.equals("")){
            return;
        }
        if(!esDate(fecha)){
            System.out.println("Ingrese una fecha válida");
            return;
        }
        
        ArrayList<Veterinario> veterinariosDisponibles = CitasAccess.veterinariosDisponibles(java.sql.Date.valueOf(fecha), hora, veterinarioSolicitado.sucursal);
        if(veterinariosDisponibles.isEmpty()){
            JOptionPane.showMessageDialog(null, "No tienes campo en esta fecha y hora");
            return;
        }
        for(Veterinario v : veterinariosDisponibles){
            if(v.id == veterinarioSolicitado.id){
                
                CitasAccess.programarCita(cliente.id, v.id, java.sql.Date.valueOf(fecha), hora);
                JOptionPane.showMessageDialog(null, "Se ha programado una cita. Mira en tu perfil las citas programadas.");
                this.dispose();
                break;
            }
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
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        txaFecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox<>();
        cmbSucursales = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

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

        jPanel7.setBackground(new java.awt.Color(237, 241, 242));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Fecha (YYYY-MM-DD)");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnConfirmar.setBackground(new java.awt.Color(224, 123, 79));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Crear");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        txaFecha.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txaFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txaFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txaFechaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Sucursal");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Solicitar cita");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Hora ");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        cmbHora.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30" }));
        cmbHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));

        cmbSucursales.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        cmbSucursales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txaFecha)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(cmbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbSucursales, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

        if(veterinarioSolicitado != null){
            crearCitaVeterinario();
            return;
        }
        
        String fecha = txaFecha.getText().toString();
        String hora = cmbHora.getSelectedItem().toString();
        Sucursal sucursal = (Sucursal)cmbSucursales.getSelectedItem();
        
        if(fecha.equals("")){
            return;
        }
        if(!esDate(fecha)){
            System.out.println("Ingrese una fecha válida");
            return;
        }
        
        
        boolean validacion = CitasAccess.validarHorario(java.sql.Date.valueOf(fecha), hora, sucursal.id);
        if(!validacion){
            JOptionPane.showMessageDialog(null, "No hay veterinarios disponibles en esta fecha y hora");
            return;
        }
        
        ArrayList<Veterinario> veterinariosDisponibles = CitasAccess.veterinariosDisponibles(java.sql.Date.valueOf(fecha), hora, sucursal.id);
        if(veterinariosDisponibles.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay veterinarios disponibles en esta fecha y hora");
            return;
        }
        
        CitasAccess.programarCita(cliente.id, veterinariosDisponibles.get(0).id, java.sql.Date.valueOf(fecha), hora);
        
        JOptionPane.showMessageDialog(null, "Se ha programado una cita. Mira en tu perfil las citas programadas.");
        this.dispose();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    
    private void txaFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txaFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txaFechaActionPerformed

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered

    }//GEN-LAST:event_jPanel7MouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        if(cliente==null){
            this.dispose();
        }
    }//GEN-LAST:event_formMouseEntered

    public boolean esDate(String str){
        try {
            java.sql.Date.valueOf(str);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbSucursales;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField txaFecha;
    // End of variables declaration//GEN-END:variables
}
