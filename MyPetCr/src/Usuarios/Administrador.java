package Usuarios;

/**
 *
 * @author lfben
 */
public class Administrador extends Usuario{
    
    public int sucursal;
    
    public Administrador(int id, String correo, int sucursal, String nombre, String celular) {
        super(id, correo, nombre, celular);
        this.tipo = Usuario.ADMINISTRADOR;
        this.sucursal = sucursal;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Administrador{" + this.correo + " sucursal=" + sucursal + '}';
    }
   
}
