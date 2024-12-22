package Carrito;

import eCommerce.CompraScreen;
import Productos.Producto;
import eCommerce.eCommerceScreen;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lfben
 */
public class CarritoScreen extends javax.swing.JFrame {

    public eCommerceScreen referencia;
    public ArrayList<Producto> carrito;
    
    public CarritoScreen(eCommerceScreen referencia, ArrayList<Producto> carrito) {
        initComponents();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.referencia = referencia;
        this.setSize(this.referencia.getSize());
        this.setLocation(this.referencia.getLocation());
        this.carrito = carrito;
        innitBotonBorrar();
        cargarCarrito();
        calcularPrecio();
        
    }
    
    public void cargarCarrito(){
    
        DefaultTableModel model = (DefaultTableModel) tablaCarrito.getModel();
        for(Producto producto : carrito){
            
            String id = producto.codigo;
            String nombre = producto.nombre;
            String precio = producto.precio + "";
            Object[] fila = {id, nombre, precio};
            
            model.addRow(fila);
        }
    }
    
    
    public void calcularPrecio(){
        int suma = 0;
        if(carrito.isEmpty()){
            btnCompra.setEnabled(false);
        }
        for(Producto producto : carrito){
            suma += producto.precio;
        }
        
        lblPrecioTotal.setText(suma+" colones");
    
    }
    
    public void innitBotonBorrar(){
        TablaAccionEvent event = new TablaAccionEvent(){
            
            @Override
            public void onEdit(int row){
                System.out.println("editar fila " + row);
            }

            @Override
            public void onDelete(int row) {
                if(tablaCarrito.isEditing()){
                    tablaCarrito.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) tablaCarrito.getModel();
                
                //System.out.println("\nEntra a borrar");
                //System.out.println("Fila seleccionada "+row);
                
                Producto eliminado = buscarEnCarrito((String)model.getValueAt(row, 0));
                //System.out.println("Id fila "+ model.getValueAt(row, 0));
                //System.out.println("Producto en la fila "+ eliminado);

                carrito.remove(eliminado);
                model.removeRow(row);
                
                //System.out.println("\nElementos restantes");
                //    for(Producto p : carrito){
                //        System.out.println("\t" + p);
                //}
                calcularPrecio();
            }
        };
        tablaCarrito.getColumnModel().getColumn(3).setCellRenderer(new TablaAccionCellRenderer());
        tablaCarrito.getColumnModel().getColumn(3).setCellEditor(new TablaAccionCellEditor(event));
    }
    
    public Producto buscarEnCarrito(String id){
        for(Producto p : carrito){
            if(p.codigo.equals(id)){
                return p;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnCompra = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPrecioTotal = new javax.swing.JLabel();

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
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 72, 91), 3));

        tablaCarrito.setBackground(new java.awt.Color(219, 227, 229));
        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Acción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCarrito.setRowHeight(40);
        jScrollPane1.setViewportView(tablaCarrito);
        if (tablaCarrito.getColumnModel().getColumnCount() > 0) {
            tablaCarrito.getColumnModel().getColumn(3).setResizable(false);
            tablaCarrito.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        jPanel2.setBackground(new java.awt.Color(219, 227, 229));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 72, 91), 3));

        btnCompra.setBackground(new java.awt.Color(224, 123, 79));
        btnCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCompra.setText("PROCEDER");
        btnCompra.setOpaque(true);
        btnCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCompraMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total");

        lblPrecioTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrecioTotal.setForeground(new java.awt.Color(224, 123, 79));
        lblPrecioTotal.setText("000 colones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblPrecioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrecioTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void btnCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompraMouseClicked
        
        if(carrito.isEmpty()){
            return;
        }
        
        CompraScreen nuevaVentana = new CompraScreen(carrito, referencia);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                referencia.regresarAqui();
            }
        });
        nuevaVentana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCompraMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCompra;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPrecioTotal;
    private javax.swing.JTable tablaCarrito;
    // End of variables declaration//GEN-END:variables
}
