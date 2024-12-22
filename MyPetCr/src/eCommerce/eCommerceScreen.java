package eCommerce;

import Usuarios.Usuario;
import Opciones.MenuAdminScreen;
import Carrito.CarritoScreen;
import Citas.CrearCitaScreen;
import Opciones.HistorialCompraScreen;
import Opciones.MenuGerenteScreen;
import Opciones.MenuVeterinarioScreen;
import Opciones.PerfilUsuarioScreen;
import Productos.DescripcionProductoScreen;
import Productos.Producto;
import SQL.ProductosAccess;
import Usuarios.Cliente;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author lfben
 */
public class eCommerceScreen extends javax.swing.JFrame implements MouseListener{

    private Usuario usuario = null;
    private ArrayList<Producto> carrito = new ArrayList<>();
    private ThreadInactividad thread;
    
    public eCommerceScreen(Usuario usuario, ArrayList<Producto> carrito) {

        this.carrito = carrito;
        this.usuario = usuario;
        
        initComponents();
        cargarListaProductos();
        cargarOpciones();    
        
        thread = new ThreadInactividad(this, 15);
        thread.start();
        
        addMouseListener(this);
    }
    
    private void cargarListaProductos(){
        
        ArrayList<Producto> productos = ProductosAccess.getProductos();
        for(Producto p : productos){
            listaProductos.addProducto(p);
        }  
        
        listaProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if (!e.getValueIsAdjusting()) {
                    Producto producto = listaProductos.getSelectedValue();
                    goToProducto(producto);
                }
            }
        });
    }
    
    public void regresarAqui(){
        thread.apagar();
        eCommerceScreen ventanaNueva = new eCommerceScreen(this.usuario, this.carrito);
        ventanaNueva.setVisible(true);
        ventanaNueva.setSize(this.getSize());
        ventanaNueva.setLocation(this.getLocation());
        cerrarEstaVentana();
    }
    
    public void cerrarEstaVentana(){
        thread.apagar();
        this.dispose();
    }
    
    private void cargarOpciones(){
        
        if(this.usuario == null){
            lblLogin.setIcon(getIcon(getClass().getResource("/iconosMenu/login.png")));
            lblCarrito.setIcon(getIcon(getClass().getResource("/iconosMenu/carrito.png")));
        }else{
            lblLogin.setIcon(getIcon(getClass().getResource("/iconosMenu/logout.png")));
            
            if(this.usuario.tipo == Usuario.CLIENTE){
                lblPerfil.setIcon(getIcon(getClass().getResource("/iconosMenu/perfil.png")));
                lblHistorial.setIcon(getIcon(getClass().getResource("/iconosMenu/historial.png")));
                lblCarrito.setIcon(getIcon(getClass().getResource("/iconosMenu/carrito.png")));
                lblCita.setIcon(getIcon(getClass().getResource("/iconosMenu/solicitarCita.png")));
            }
            if(this.usuario.tipo == Usuario.VETERINARIO || this.usuario.tipo == Usuario.ADMINISTRADOR || this.usuario.tipo == Usuario.GERENTE){
                lblPerfil.setVisible(false);
                lblModificar.setIcon(getIcon(getClass().getResource("/iconosMenu/modificar.png")));
            }
        }
    }
    
    private void goToProducto(Producto producto){
        thread.apagar();
        
        if(usuario==null){
            ProductosAccess.auditoriaProducto(1, producto);
        }else if(usuario.tipo == Usuario.CLIENTE){
            ProductosAccess.auditoriaProducto(usuario.id, producto);
        }
        
        eCommerceScreen estaVentana = this;
        estaVentana.setVisible(false);
        DescripcionProductoScreen nuevaVentana = new DescripcionProductoScreen(producto, this);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.regresarAqui();
            }
        });
        nuevaVentana.setVisible(true);
    }
    
    private void goToCarrito(){
        thread.apagar();
        eCommerceScreen estaVentana = this;
        estaVentana.setVisible(false);
        CarritoScreen nuevaVentana = new CarritoScreen(this, this.carrito);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.regresarAqui();
            }
        });
        nuevaVentana.setVisible(true);
    }
    
    private void goToMenuAdmin(){
        thread.apagar();
        eCommerceScreen estaVentana = this;
        estaVentana.setVisible(false);
        MenuAdminScreen nuevaVentana = new MenuAdminScreen(this);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.regresarAqui();
            }
        });
        nuevaVentana.setVisible(true);
    }
    
    private void goToMenuVeterinario(){
        thread.apagar();
        eCommerceScreen estaVentana = this;
        estaVentana.setVisible(false);
        MenuVeterinarioScreen nuevaVentana = new MenuVeterinarioScreen(this);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.regresarAqui();
            }
        });
        nuevaVentana.setVisible(true);
    }
    
    private void goToMenuGerente(){
        thread.apagar();
        eCommerceScreen estaVentana = this;
        estaVentana.setVisible(false);
        MenuGerenteScreen nuevaVentana = new MenuGerenteScreen(this);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.regresarAqui();
            }
        });
        nuevaVentana.setVisible(true);
    }
    
    private void goToHistorial(){
        thread.apagar();
        eCommerceScreen estaVentana = this;
        estaVentana.setVisible(false);

        HistorialCompraScreen nuevaVentana = new HistorialCompraScreen(estaVentana, (Cliente)this.usuario);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.regresarAqui();
            }
        });
        nuevaVentana.setVisible(true);
    }
    
    public void realizarCompra(boolean exito, int precio){
        
        if(exito){
            System.out.println("Compra exitosa. Debe pagar: " + precio);
        }else{
            System.out.println("Compra fallida.");
        }
        limpiarCarrito();
        this.regresarAqui();
    }
    
    public void agregarAlCarrito(Producto producto){
        carrito.add(producto);
        this.regresarAqui();
    }
    
    public void sacarDelCarrito(Producto producto){
        carrito.remove(producto);
    }
    
    public void limpiarCarrito(){
        carrito = new ArrayList<Producto>();
    }
    
    public void asignarUsuario(Usuario usuario){
        thread.apagar();
        eCommerceScreen ventanaNueva;
        if(usuario.getTipo()!=Usuario.CLIENTE){
            ventanaNueva = new eCommerceScreen(usuario, new ArrayList<Producto>());
        }else{
            ventanaNueva = new eCommerceScreen(usuario, this.carrito);
        }
        ventanaNueva.setVisible(true);
        ventanaNueva.setSize(this.getSize());
        ventanaNueva.setLocation(this.getLocation());
        cerrarEstaVentana();
    }
    
    public void quitarUsuario(){
        thread.apagar();
        eCommerceScreen ventanaNueva = new eCommerceScreen(null, this.carrito);
        ventanaNueva.setVisible(true);
        ventanaNueva.setSize(this.getSize());
        ventanaNueva.setLocation(this.getLocation());
        cerrarEstaVentana();
    }
    
    private static ImageIcon getIcon(URL url){
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(url)) {
            @Override
            public int getIconWidth() {
                return 30;
            }
            @Override
            public int getIconHeight() {
                return 30;
            }
            @Override
            public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
                g.drawImage(getImage(), x, y, 30, 30, null);
            }
        };
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProductos = new eCommerce.ProductoList<>();
        jPanel3 = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        lblCarrito = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        lblHistorial = new javax.swing.JLabel();
        lblModificar = new javax.swing.JLabel();
        lblCita = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 199, 167));

        jPanel1.setBackground(new java.awt.Color(26, 72, 91));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MyPetsCr");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 199, 167));

        jScrollPane2.setBackground(new java.awt.Color(26, 72, 91));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 72, 91), 3));

        listaProductos.setBackground(new java.awt.Color(219, 227, 229));
        listaProductos.setBorder(null);
        jScrollPane2.setViewportView(listaProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(77, 115, 129));

        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });

        lblCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCarritoMouseClicked(evt);
            }
        });

        lblPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPerfilMouseClicked(evt);
            }
        });

        lblHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistorialMouseClicked(evt);
            }
        });

        lblModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificarMouseClicked(evt);
            }
        });

        lblCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCitaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCita, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblCita, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 580, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        if(this.usuario == null){
            //System.out.println("login");
            //new LoginScreen(this).setVisible(true);
            goToLogin();
        }else{
            //System.out.println("logout");
            quitarUsuario();
        }
    }//GEN-LAST:event_lblLoginMouseClicked

    private void lblPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPerfilMouseClicked
        if(this.usuario == null){
        }else{
            if(this.usuario.tipo == Usuario.CLIENTE){
                //new PerfilUsuarioScreen(this, (Cliente)this.usuario).setVisible(true);
                //thread.pausar();
                goToPerfil();
            }
        }
    }//GEN-LAST:event_lblPerfilMouseClicked

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked
        if(this.usuario == null){
        }else{
            if(this.usuario.tipo == Usuario.ADMINISTRADOR){
                goToMenuAdmin();
            }
            else if(this.usuario.tipo == Usuario.VETERINARIO){
                goToMenuVeterinario();
            }
            else if(this.usuario.tipo == Usuario.GERENTE){
                goToMenuGerente();
            }
        }
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCarritoMouseClicked
        if(this.usuario == null){
            //System.out.println("carrito");
            goToCarrito();
        }else{
            if(this.usuario.tipo == Usuario.CLIENTE){
                //System.out.println("carrito");
                goToCarrito();
            }
        }
    }//GEN-LAST:event_lblCarritoMouseClicked

    private void lblHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistorialMouseClicked
        if(this.usuario == null){
        }else{
            if(this.usuario.tipo == Usuario.CLIENTE){
                                
                goToHistorial();
                     
            }
        }
    }//GEN-LAST:event_lblHistorialMouseClicked

    private void lblCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCitaMouseClicked
        if(this.usuario == null){
        }else{
            if(this.usuario.tipo == Usuario.CLIENTE){
                                
                //new CrearCitaScreen(this, (Cliente)this.usuario).setVisible(true);
                //thread.pausar();
                goToCita();
            }
        }
    }//GEN-LAST:event_lblCitaMouseClicked

    
    private void goToCita(){
        eCommerceScreen estaVentana = this;
        thread.pausar();

        CrearCitaScreen nuevaVentana = new CrearCitaScreen(estaVentana, (Cliente)this.usuario);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.thread.reanudar();
            }
        });
        nuevaVentana.setVisible(true);
    }
    
    private void goToPerfil(){
        eCommerceScreen estaVentana = this;
        thread.pausar();

        PerfilUsuarioScreen nuevaVentana = new PerfilUsuarioScreen(estaVentana, (Cliente)this.usuario);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.thread.reanudar();
            }
        });
        nuevaVentana.setVisible(true);
    }
    
    private void goToLogin(){
        eCommerceScreen estaVentana = this;
        thread.pausar();

        LoginScreen nuevaVentana = new LoginScreen(estaVentana);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                estaVentana.thread.reanudar();
            }
        });
        nuevaVentana.setVisible(true);
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCarrito;
    private javax.swing.JLabel lblCita;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JLabel lblPerfil;
    private eCommerce.ProductoList<String> listaProductos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        thread.reestablecerTiempo();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        thread.reestablecerTiempo();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        thread.reestablecerTiempo();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        thread.reestablecerTiempo();
    }
}
