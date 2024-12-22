package Usuarios;

/**
 *
 * @author lfben
 */
public class Gerente extends Usuario{
        
    public int sucursal;
    
    public Gerente(int id, String correo, int sucursal, String nombre, String celular) {
        super(id, correo, nombre, celular);
        this.tipo = Usuario.GERENTE;
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
        return "Gerente{" + this.correo + " sucursal=" + sucursal + '}';
    }
   
}
