package Usuarios;

/**
 *
 * @author lfben
 */
public class Veterinario extends Usuario{
        
    public int sucursal;
    
    public Veterinario(int id, String correo, int sucursal, String nombre, String celular) {
        super(id, correo, nombre, celular);
        this.tipo = Usuario.VETERINARIO;
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
        return "Veterinario{" + this.correo + " sucursal=" + sucursal + '}';
    }
}
