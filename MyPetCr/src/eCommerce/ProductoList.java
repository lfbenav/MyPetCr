package eCommerce;

import Productos.Producto;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

/**
 *
 * @author lfben
 */
public class ProductoList<E> extends JList<Producto>{
    
    private final DefaultListModel model;
    private ProductoList lista;
    
    public ProductoList(){
        model = new DefaultListModel();
        setModel(model);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista = this;
    }
    
    @Override
    public ListCellRenderer<? super Producto> getCellRenderer(){
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus){
                ProductoListItem item = new ProductoListItem();
                item.setProducto(o);
                item.setForeground(lista.getForeground());
                item.setSelected(selected);
                if (index % 2 == 0) item.setBackground(new Color(219,227,229));
                else item.setBackground(new Color(237,241,242));
                return item;
            }        
        };
    }
    
    public void addProducto(Producto producto){
        model.addElement(producto);
    }
    
}
