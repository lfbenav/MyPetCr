package Productos;

import SQL.ProductosAccess;
import eCommerce.CompraScreen;
import eCommerce.eCommerceScreen;
import Usuarios.Usuario;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author lfben
 */
public class DescripcionProductoScreen extends javax.swing.JFrame {

    public Producto producto;
    public eCommerceScreen referencia;
    
    public DescripcionProductoScreen(Producto producto, eCommerceScreen referencia) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.producto = producto;
        this.referencia = referencia;
        this.setSize(this.referencia.getSize());
        this.setLocation(this.referencia.getLocation());
        cargarInfo();
        cargarResenas();
    }
    
    private void cargarInfo(){
        
        this.producto = ProductosAccess.getProductoPorId(this.producto.codigo);
        if(this.producto==null){
            System.out.println("Error al cargar el producto");
            return;
        }
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/imagenes/" + producto.imagen));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(230, 230,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        lblImagen.setIcon(imageIcon);
        
        txaNombre.setText(producto.nombre);
        lblPrecio.setText(producto.precio + " colones");
        lblStock.setText(producto.stock + " unidades disponibles");
        txaDescripcion.setText(producto.descripcion);
        lblEnviar.setIcon(getIcon(getClass().getResource("/iconosMenu/enviar.png")));
        
        if(producto.stock <= 0){
            btnAgregarCarrito.setEnabled(false);
            btnAgregarCarrito.setFocusable(false);
            btnCompra.setEnabled(false);
            btnCompra.setFocusable(false);
        }
        if(referencia.getUsuario() != null){
            if(referencia.getUsuario().tipo != Usuario.CLIENTE){
                btnAgregarCarrito.setEnabled(false);
                btnAgregarCarrito.setFocusable(false);
                btnCompra.setEnabled(false);
                btnCompra.setFocusable(false);
                txaResena.setEnabled(false);
                txaResena.setFocusable(false);
                cmbCalificacion.setEnabled(false);
                cmbCalificacion.setFocusable(false);
            }
        }
    }
    
    private void cargarResenas(){
        DefaultListModel lista = new DefaultListModel();
        jList1.setModel(lista);
        
        ArrayList<String> comentarios = ProductosAccess.getResenas(this.producto.codigo);
        for(String s : comentarios){
            lista.addElement(s);
        }
        
    }
    
    private static ImageIcon getIcon(URL url){
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(url)) {
            @Override
            public int getIconWidth() {
                return 54;
            }
            @Override
            public int getIconHeight() {
                return 54;
            }
            @Override
            public synchronized void paintIcon(Component c, Graphics g,
                                               int x, int y) {
                g.drawImage(getImage(), x, y, 54, 54, null);
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txaNombre = new javax.swing.JTextArea();
        txaDescripcion = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        btnCompra = new javax.swing.JLabel();
        btnAgregarCarrito = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaResena = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        cmbCalificacion = new javax.swing.JComboBox<>();
        lblEnviar = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jPanel3.setBackground(new java.awt.Color(77, 115, 129));

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 72, 91), 2));
        lblImagen.setMaximumSize(new java.awt.Dimension(230, 230));
        lblImagen.setMinimumSize(new java.awt.Dimension(230, 230));
        lblImagen.setPreferredSize(new java.awt.Dimension(230, 230));

        jPanel4.setBackground(new java.awt.Color(77, 115, 129));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 72, 91), 2));

        txaNombre.setEditable(false);
        txaNombre.setBackground(new java.awt.Color(219, 227, 229));
        txaNombre.setColumns(20);
        txaNombre.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        txaNombre.setLineWrap(true);
        txaNombre.setRows(3);
        txaNombre.setWrapStyleWord(true);
        txaNombre.setBorder(null);
        txaNombre.setFocusable(false);

        txaDescripcion.setEditable(false);
        txaDescripcion.setBackground(new java.awt.Color(237, 241, 242));
        txaDescripcion.setColumns(20);
        txaDescripcion.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txaDescripcion.setLineWrap(true);
        txaDescripcion.setRows(5);
        txaDescripcion.setWrapStyleWord(true);
        txaDescripcion.setBorder(null);
        txaDescripcion.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txaNombre)
            .addComponent(txaDescripcion)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(237, 241, 242));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));

        btnCompra.setBackground(new java.awt.Color(224, 123, 79));
        btnCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCompra.setText("PROCEDER A LA COMPRA");
        btnCompra.setOpaque(true);
        btnCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCompraMouseClicked(evt);
            }
        });

        btnAgregarCarrito.setBackground(new java.awt.Color(224, 123, 79));
        btnAgregarCarrito.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarCarrito.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCarrito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregarCarrito.setText("AGREGAR AL CARRITO");
        btnAgregarCarrito.setOpaque(true);
        btnAgregarCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarCarritoMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Precio:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Stock:");

        lblStock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStock.setForeground(new java.awt.Color(224, 123, 79));
        lblStock.setText("jLabel3");

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(224, 123, 79));
        lblPrecio.setText("jLabel2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblPrecio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblStock))
                    .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(77, 115, 129));

        txaResena.setColumns(20);
        txaResena.setLineWrap(true);
        txaResena.setRows(3);
        txaResena.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txaResena);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Deja una reseña");

        cmbCalificacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbCalificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5 estrellas", "4 estrellas", "3 estrellas", "2 estrellas", "1 estrella" }));

        lblEnviar.setBackground(new java.awt.Color(77, 115, 129));
        lblEnviar.setForeground(new java.awt.Color(77, 115, 129));
        lblEnviar.setMaximumSize(new java.awt.Dimension(54, 54));
        lblEnviar.setMinimumSize(new java.awt.Dimension(54, 54));
        lblEnviar.setOpaque(true);
        lblEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEnviarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(cmbCalificacion)
                    .addComponent(lblEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(237, 241, 242));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 115, 129), 2));

        jScrollPane2.setBorder(null);

        jList1.setBorder(null);
        jList1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jList1);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Reseñas de otros usuarios");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(77, 115, 129));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarCarritoMouseClicked
        if(!btnAgregarCarrito.isEnabled()){
            return;
        }
        referencia.agregarAlCarrito(producto);
        this.dispose();
    }//GEN-LAST:event_btnAgregarCarritoMouseClicked

    private void btnCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompraMouseClicked
        if(!btnCompra.isEnabled()){
            return;
        }
        ArrayList<Producto> compras = new ArrayList<Producto>();
        compras.add(producto);
        
        CompraScreen nuevaVentana = new CompraScreen(compras, referencia);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                referencia.regresarAqui();
            }
        });
        nuevaVentana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCompraMouseClicked

    private void lblEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnviarMouseClicked
        String resena = txaResena.getText();
        if(resena.equals("")){
            return;
        }
        
        String calificacion = cmbCalificacion.getSelectedItem().toString();
        int calificacionNumero = Integer.parseInt(calificacion.substring(0,1));
        
        String correo;
        if(referencia.getUsuario()==null){
            correo = "Anonimo";
        }else{
            correo = referencia.getUsuario().nombre;
        }
        
        ProductosAccess.insertResena(this.producto.codigo, correo, calificacionNumero, resena);
        
        txaResena.setText("");
        cargarResenas();
    }//GEN-LAST:event_lblEnviarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregarCarrito;
    private javax.swing.JLabel btnCompra;
    private javax.swing.JComboBox<String> cmbCalificacion;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEnviar;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblStock;
    private javax.swing.JTextArea txaDescripcion;
    private javax.swing.JTextArea txaNombre;
    private javax.swing.JTextArea txaResena;
    // End of variables declaration//GEN-END:variables
}
