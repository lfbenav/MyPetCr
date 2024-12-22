package eCommerce;

import Productos.Producto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author lfben
 */
public class ProductoListItem extends javax.swing.JPanel {

    public boolean selected;
    public Producto producto;
    
    public ProductoListItem() {
        initComponents();
    }
   
    public void setProducto(Object obj){
        if (obj instanceof Producto producto){
            this.producto = producto;
            lblNombre.setText(producto.nombre);
            lblPrecio.setText(producto.precio + " colones");
            lblImagen.setIcon(producto.icono);
        }else{
            lblNombre.setText(obj.toString() + " Error");
        }
    }
    
    @Override
    public void setForeground(Color color){
        super.setForeground(color);
        if(lblNombre != null)
            lblNombre.setForeground(color);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    @Override
    protected void paintComponent(Graphics grphcs){
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(isSelected()){
            g2.fillRect(0, 0, 3, this.getHeight());
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();

        lblNombre.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblNombre.setText("Nombre del producto");
        lblNombre.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblImagen.setMaximumSize(new java.awt.Dimension(100, 100));
        lblImagen.setMinimumSize(new java.awt.Dimension(100, 100));

        lblPrecio.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(153, 153, 153));
        lblPrecio.setText("1000");
        lblPrecio.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    // End of variables declaration//GEN-END:variables
}
