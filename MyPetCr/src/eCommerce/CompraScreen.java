package eCommerce;

import Productos.Producto;
import SQL.ComprasAccess;
import SQL.UsuariosAccess;
import eCommerce.eCommerceScreen;
import Usuarios.Cliente;
import Usuarios.Sucursal;
import java.util.ArrayList;

/**
 *
 * @author lfben
 */
public class CompraScreen extends javax.swing.JFrame {

    public ArrayList<Producto> compras;
    public int total = 0;
    public int totalConEnvío = 0;
    public int idSucursal = 0;
    public eCommerceScreen referencia;
    
    public static int RETIRO = 0;
    public static int ENVIO = 1;
    
    public static int TARJETA = 0;
    public static int SINPE = 1;
    
    public int metodoRetiro = ENVIO;
    public int metodoPago = TARJETA;
    
    private int idEncabezado = -1;
    
    public CompraScreen(ArrayList<Producto> compras, eCommerceScreen referencia) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.compras = compras;
        this.referencia = referencia;
        this.setSize(this.referencia.getSize());
        this.setLocation(this.referencia.getLocation());
        cargarInfo();
    }
    
    public void cargarInfo(){
        System.out.println("\nProductos que se compraran:");
        for(Producto p : compras){
            System.out.println("\t"+p.nombre);
            total += p.precio;
        }
        totalConEnvío = total + 4500;
        cambiarPrecio(true);
        
        if(referencia.getUsuario() != null){
            lblLogueado.setVisible(false);
        }
    }
    
    public void cambiarPrecio(boolean envio){
        if(envio){
            lblPrecioTotal.setText(totalConEnvío + " colones");
        }else{
            lblPrecioTotal.setText(total + " colones");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblLogueado = new javax.swing.JLabel();
        lblLogueado1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblPrecioTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbRetiro = new javax.swing.JComboBox<>();
        txaDireccion = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbMetodo = new javax.swing.JComboBox<>();
        txaNumero = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txaFecha = new javax.swing.JTextField();
        lblPin = new javax.swing.JLabel();
        txaPin = new javax.swing.JTextField();
        btnPagar = new javax.swing.JLabel();
        lblSucursalesDisponibles = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(77, 115, 129));

        lblLogueado.setForeground(new java.awt.Color(255, 255, 255));
        lblLogueado.setText("No logueado");

        lblLogueado1.setForeground(new java.awt.Color(255, 255, 255));
        lblLogueado1.setText("    ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogueado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogueado1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogueado)
                    .addComponent(lblLogueado1)))
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
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
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
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 72, 91), 3));

        lblPrecioTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrecioTotal.setForeground(new java.awt.Color(224, 123, 79));
        lblPrecioTotal.setText("000 colones");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Total:");

        cmbRetiro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbRetiro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Envío", "Retiro" }));
        cmbRetiro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        cmbRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRetiroActionPerformed(evt);
            }
        });

        txaDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txaDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txaDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txaDireccionActionPerformed(evt);
            }
        });

        lblDireccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDireccion.setText("Dirección");

        jPanel4.setBackground(new java.awt.Color(219, 227, 229));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Checkout");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        cmbMetodo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta", "Sinpe" }));
        cmbMetodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        cmbMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMetodoActionPerformed(evt);
            }
        });

        txaNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txaNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txaNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txaNumeroActionPerformed(evt);
            }
        });

        lblNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNumero.setText("Número");

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFecha.setText("Fecha de vencimiento");

        txaFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txaFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txaFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txaFechaActionPerformed(evt);
            }
        });

        lblPin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPin.setText("Pin");

        txaPin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txaPin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));
        txaPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txaPinActionPerformed(evt);
            }
        });

        btnPagar.setBackground(new java.awt.Color(224, 123, 79));
        btnPagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPagar.setText("REALIZAR COMPRA");
        btnPagar.setOpaque(true);
        btnPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPagarMouseClicked(evt);
            }
        });

        lblSucursalesDisponibles.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSucursalesDisponibles.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSucursalesDisponibles.setText("El envío cuesta 4500 colones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                            .addComponent(txaDireccion)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txaPin, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txaFecha)
                            .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txaNumero)))
                    .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSucursalesDisponibles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPrecioTotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPin, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txaPin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lblSucursalesDisponibles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
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

    private void txaDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txaDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txaDireccionActionPerformed

    private void cmbRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRetiroActionPerformed
        if(cmbRetiro.getSelectedItem().toString().equals("Retiro")){
            metodoRetiro = RETIRO;
            cambiarPrecio(false);
            lblDireccion.setText("Sucursal");
            
            ArrayList<Sucursal> sucursales = retornarSucursales();
            String str = "Sucursales disponibles: ";
            for(Sucursal s : sucursales){
                str += s.nombre + " ";
            }
            lblSucursalesDisponibles.setText(str);
            
        }else{
            metodoRetiro = ENVIO;
            cambiarPrecio(true);
            lblDireccion.setText("Dirección");
            lblSucursalesDisponibles.setText("El envío cuesta 4500 colones");
        }
    }//GEN-LAST:event_cmbRetiroActionPerformed

    private void cmbMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMetodoActionPerformed
        if(cmbMetodo.getSelectedItem().toString().equals("Tarjeta")){
            metodoPago = TARJETA;
            lblNumero.setText("Número");
            lblFecha.setText("Fecha");
            lblPin.setText("Pin");
            txaFecha.setVisible(true);
            txaPin.setVisible(true);
        }else{
            metodoPago = SINPE;
            lblNumero.setText("Comprobante");
            lblFecha.setText("");
            lblPin.setText("");
            txaFecha.setVisible(false);
            txaPin.setVisible(false);
        }
    }//GEN-LAST:event_cmbMetodoActionPerformed

    private void txaNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txaNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txaNumeroActionPerformed

    private void txaFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txaFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txaFechaActionPerformed

    private void txaPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txaPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txaPinActionPerformed

    private ArrayList<Sucursal> retornarSucursales(){
        ArrayList<Sucursal> sucursales = UsuariosAccess.getSucursales();
        return sucursales;
    }
    
    private boolean validarSucursal(String sucursal){
        ArrayList<Sucursal> sucursales = UsuariosAccess.getSucursales();
        for(Sucursal s : sucursales){
            if(s.nombre.toLowerCase().equals(sucursal.toLowerCase())){
                this.idSucursal = s.id;
                return true;
            }
        }
        return false;
    }
    
    private void btnPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPagarMouseClicked
        if(metodoPago == TARJETA){
            if(txaNumero.getText().equals("") || txaFecha.getText().equals("") || txaPin.getText().equals("")){
                System.out.println("llene todos los campos del pago con tarjeta");
                return;
            }
        }else if (metodoPago == SINPE){
            if(txaNumero.getText().equals("")){
                System.out.println("llene todos los campos del pago con sinpe");
                return;
            }
        }
        
        if(metodoRetiro == RETIRO){
            if(txaDireccion.getText().equals("")){
                System.out.println("llene todos los campos del retiro en sucursal");
                return;
            }
            if(!validarSucursal(txaDireccion.getText().toString())){
                System.out.println("ingresar una sucursal valida");
                return;
            }
        }else if (metodoRetiro == ENVIO){
            if(txaDireccion.getText().equals("")){
                System.out.println("llene todos los campos del envio a la direccion");
                return;
            }
        }

        //validar datos
        Cliente comprador;
        if(referencia.getUsuario() == null){
            comprador = new Cliente(1,"Anonimo","Anonimo","0");
        }else{
            comprador = (Cliente) referencia.getUsuario();
        }
        
        boolean resultado = registrarCompra(comprador);
        int pagar = calcularPrecio(idEncabezado);
        
        
        
        referencia.realizarCompra(resultado, pagar);
        this.dispose();
    }//GEN-LAST:event_btnPagarMouseClicked

    private int calcularPrecio(int id){
        int res = ComprasAccess.precioCompra(id);
        return res;
    }
    
    private boolean registrarCompra(Cliente comprador){
        int tipoPago = -1;
        String comprobante = "-1";
        
        if(metodoPago == TARJETA){
            tipoPago = 1;
            String input = txaNumero.getText();
            if (input.length() > 4) {
                comprobante = "************"+input.substring(input.length() - 4);
            }else{
                comprobante = "************"+input;
            }
        }else if (metodoPago == SINPE){
            tipoPago = 2;
            comprobante = txaNumero.getText();
        }
        
        //Crear encabezado
        int idCompra = -1;
        if(metodoRetiro == RETIRO){
            idCompra = ComprasAccess.crearEncabezadoRetiro(comprador.id, tipoPago, comprobante, total, idSucursal);
        }else if (metodoRetiro == ENVIO){
            idCompra = ComprasAccess.crearEncabezadoEnvio(comprador.id, tipoPago, comprobante, totalConEnvío, txaDireccion.getText());
        }
        
        idEncabezado = idCompra;
        
        //Insertar lineas
        for(Producto p : compras){
            int res = ComprasAccess.crearLineaCompra(idCompra, Integer.parseInt(p.codigo));
            if (res!=10){
                compras.remove(p);
                System.out.println("No se pudo comprar " + p.nombre);
            }
        }
        
        int validada = ComprasAccess.validarCompra(idCompra);
        if(validada!=0){
            System.out.println("No se realiza la compra, productos sin stock");
            return false;
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnPagar;
    private javax.swing.JComboBox<String> cmbMetodo;
    private javax.swing.JComboBox<String> cmbRetiro;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLogueado;
    private javax.swing.JLabel lblLogueado1;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPin;
    private javax.swing.JLabel lblPrecioTotal;
    private javax.swing.JLabel lblSucursalesDisponibles;
    private javax.swing.JTextField txaDireccion;
    private javax.swing.JTextField txaFecha;
    private javax.swing.JTextField txaNumero;
    private javax.swing.JTextField txaPin;
    // End of variables declaration//GEN-END:variables
}
