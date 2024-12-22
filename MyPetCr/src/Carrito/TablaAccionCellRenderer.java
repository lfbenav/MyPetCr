package Carrito;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author lfben
 */
public class TablaAccionCellRenderer extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1){
        Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
        
        PanelAccion accion = new PanelAccion();
        accion.setBackground(com.getBackground());
        return accion;
    }
    
}
