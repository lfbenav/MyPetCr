package Opciones;

import Citas.CrearCitaScreen;
import Citas.VerTodasCobradasScreen;
import Citas.VerTodasPorCobrarScreen;
import Citas.VerTodasProgramadasScreen;
import SQL.UsuariosAccess;
import Usuarios.Cliente;
import Usuarios.Usuario;
import eCommerce.eCommerceScreen;
import javax.swing.JOptionPane;

/**
 *
 * @author lfben
 */
public class MenuGerenteScreen extends MenuUsuario {

    eCommerceScreen referencia;
    
    public MenuGerenteScreen(eCommerceScreen referencia) {
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
        btnRegistrarUsuario = new javax.swing.JButton();
        btnVerClientes = new javax.swing.JButton();
        btnVerVeterinarios = new javax.swing.JButton();
        btnVerProductos = new javax.swing.JButton();
        btnVerCitasProgramadas = new javax.swing.JButton();
        btnProgramarCita = new javax.swing.JButton();
        btnVerMascotas = new javax.swing.JButton();
        btnCitasPorCobrar = new javax.swing.JButton();
        btnRegistrarVeterinario = new javax.swing.JButton();
        btnRegistrarAdmin = new javax.swing.JButton();
        btnVerAdmins = new javax.swing.JButton();
        btnVerCitasViejas = new javax.swing.JButton();

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
        jLabel8.setText("Tipo de usuario: Gerente");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnRegistrarUsuario.setBackground(new java.awt.Color(224, 123, 79));
        btnRegistrarUsuario.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnRegistrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarUsuario.setText("Registrar un nuevo cliente");
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });

        btnVerClientes.setBackground(new java.awt.Color(224, 123, 79));
        btnVerClientes.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnVerClientes.setText("Ver clientes registrados");
        btnVerClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerClientesActionPerformed(evt);
            }
        });

        btnVerVeterinarios.setBackground(new java.awt.Color(224, 123, 79));
        btnVerVeterinarios.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerVeterinarios.setForeground(new java.awt.Color(255, 255, 255));
        btnVerVeterinarios.setText("Ver veterinarios registrados");
        btnVerVeterinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerVeterinariosActionPerformed(evt);
            }
        });

        btnVerProductos.setBackground(new java.awt.Color(224, 123, 79));
        btnVerProductos.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnVerProductos.setText("Ver productos registrados");
        btnVerProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProductosActionPerformed(evt);
            }
        });

        btnVerCitasProgramadas.setBackground(new java.awt.Color(224, 123, 79));
        btnVerCitasProgramadas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerCitasProgramadas.setForeground(new java.awt.Color(255, 255, 255));
        btnVerCitasProgramadas.setText("Ver citas programadas");
        btnVerCitasProgramadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerCitasProgramadasActionPerformed(evt);
            }
        });

        btnProgramarCita.setBackground(new java.awt.Color(224, 123, 79));
        btnProgramarCita.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnProgramarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnProgramarCita.setText("Programar una cita");
        btnProgramarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramarCitaActionPerformed(evt);
            }
        });

        btnVerMascotas.setBackground(new java.awt.Color(224, 123, 79));
        btnVerMascotas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerMascotas.setForeground(new java.awt.Color(255, 255, 255));
        btnVerMascotas.setText("Ver mascotas registradas");
        btnVerMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMascotasActionPerformed(evt);
            }
        });

        btnCitasPorCobrar.setBackground(new java.awt.Color(224, 123, 79));
        btnCitasPorCobrar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnCitasPorCobrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCitasPorCobrar.setText("Ver citas por cobrar");
        btnCitasPorCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasPorCobrarActionPerformed(evt);
            }
        });

        btnRegistrarVeterinario.setBackground(new java.awt.Color(224, 123, 79));
        btnRegistrarVeterinario.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnRegistrarVeterinario.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarVeterinario.setText("Registrar un nuevo veterinario");
        btnRegistrarVeterinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVeterinarioActionPerformed(evt);
            }
        });

        btnRegistrarAdmin.setBackground(new java.awt.Color(224, 123, 79));
        btnRegistrarAdmin.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnRegistrarAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarAdmin.setText("Registrar un nuevo administrador");
        btnRegistrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAdminActionPerformed(evt);
            }
        });

        btnVerAdmins.setBackground(new java.awt.Color(224, 123, 79));
        btnVerAdmins.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerAdmins.setForeground(new java.awt.Color(255, 255, 255));
        btnVerAdmins.setText("Ver administradores registrados");
        btnVerAdmins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAdminsActionPerformed(evt);
            }
        });

        btnVerCitasViejas.setBackground(new java.awt.Color(224, 123, 79));
        btnVerCitasViejas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnVerCitasViejas.setForeground(new java.awt.Color(255, 255, 255));
        btnVerCitasViejas.setText("Ver historial de citas");
        btnVerCitasViejas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerCitasViejasActionPerformed(evt);
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
                    .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerVeterinarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerCitasProgramadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProgramarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerMascotas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCitasPorCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarVeterinario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerAdmins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerCitasViejas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(btnRegistrarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerMascotas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarVeterinario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerVeterinarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCitasPorCobrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerCitasProgramadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProgramarCita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerAdmins)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerCitasViejas)
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

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        RegistroScreen nuevaVentana = new RegistroScreen(estaVentana, Usuario.CLIENTE);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed

    private void btnVerClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerClientesActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerClientesScreen nuevaVentana = new VerClientesScreen(estaVentana, Usuario.GERENTE);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_btnVerClientesActionPerformed

    private void btnVerVeterinariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerVeterinariosActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerVeterinariosScreen nuevaVentana = new VerVeterinariosScreen(estaVentana);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true); 
    }//GEN-LAST:event_btnVerVeterinariosActionPerformed

    private void btnVerProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProductosActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerProductosScreen nuevaVentana = new VerProductosScreen(estaVentana);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_btnVerProductosActionPerformed

    private void btnVerCitasProgramadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCitasProgramadasActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerTodasProgramadasScreen nuevaVentana = new VerTodasProgramadasScreen(this);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_btnVerCitasProgramadasActionPerformed

    private void btnProgramarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramarCitaActionPerformed

        String correo = JOptionPane.showInputDialog("Escriba el correo del cliente");
        Cliente usuario = (Cliente)UsuariosAccess.clientePorCorreo(correo);
        if(usuario == null){
            JOptionPane.showMessageDialog(null, "Correo inválido.");
        }else{
            new CrearCitaScreen(this, usuario).setVisible(true);
        }

    }//GEN-LAST:event_btnProgramarCitaActionPerformed

    private void btnVerMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMascotasActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerMascotasScreen nuevaVentana = new VerMascotasScreen(this);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_btnVerMascotasActionPerformed

    private void btnCitasPorCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasPorCobrarActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerTodasPorCobrarScreen nuevaVentana = new VerTodasPorCobrarScreen(this);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_btnCitasPorCobrarActionPerformed

    private void btnRegistrarVeterinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVeterinarioActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        RegistroScreen nuevaVentana = new RegistroScreen(estaVentana, Usuario.VETERINARIO);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_btnRegistrarVeterinarioActionPerformed

    private void btnRegistrarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAdminActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        RegistroScreen nuevaVentana = new RegistroScreen(estaVentana, Usuario.ADMINISTRADOR);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_btnRegistrarAdminActionPerformed

    private void btnVerAdminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAdminsActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerAdministradoresScreen nuevaVentana = new VerAdministradoresScreen(estaVentana);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true); 
    }//GEN-LAST:event_btnVerAdminsActionPerformed

    private void btnVerCitasViejasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCitasViejasActionPerformed
        MenuGerenteScreen estaVentana = this;
        estaVentana.setVisible(false);
        
        VerTodasCobradasScreen nuevaVentana = new VerTodasCobradasScreen(this);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.setVisible(true);
            }
        });
        
        nuevaVentana.setVisible(true);



    }//GEN-LAST:event_btnVerCitasViejasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCitasPorCobrar;
    private javax.swing.JButton btnProgramarCita;
    private javax.swing.JButton btnRegistrarAdmin;
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JButton btnRegistrarVeterinario;
    private javax.swing.JButton btnVerAdmins;
    private javax.swing.JButton btnVerCitasProgramadas;
    private javax.swing.JButton btnVerCitasViejas;
    private javax.swing.JButton btnVerClientes;
    private javax.swing.JButton btnVerMascotas;
    private javax.swing.JButton btnVerProductos;
    private javax.swing.JButton btnVerVeterinarios;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
