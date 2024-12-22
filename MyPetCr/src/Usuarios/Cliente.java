package Usuarios;

/**
 *
 * @author lfben
 */
public class Cliente extends Usuario{
    
    public Cliente(int id, String correo, String nombre, String celular) {
        super(id, correo, nombre, celular);
        this.tipo = Usuario.CLIENTE;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + this.correo +'}';
    }
    
}
