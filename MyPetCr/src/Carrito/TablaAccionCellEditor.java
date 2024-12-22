package Carrito;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author lfben
 */
public class TablaAccionCellEditor extends DefaultCellEditor{
    
    private TablaAccionEvent event;
    
    public TablaAccionCellEditor(TablaAccionEvent event){
        super(new JCheckBox());
        this.event = event;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column){
        PanelAccion accion = new PanelAccion();
        accion.initEvent(event, row);
        accion.setBackground(jtable.getSelectionBackground());
        return accion;
    }
    
}
