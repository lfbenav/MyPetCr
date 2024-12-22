package Usuarios;

/**
 *
 * @author lfben
 */
public abstract class Usuario{
    
    public int id;
    public String correo;
    public String nombre;
    public String celular;
    public int tipo;
    
    public static int CLIENTE = 1;
    public static int VETERINARIO = 2;
    public static int ADMINISTRADOR = 3;
    public static int GERENTE = 4;

    public Usuario(int id, String correo, String nombre, String celular) {
        this.correo = correo;
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }    
}
