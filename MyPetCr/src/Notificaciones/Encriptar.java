package Notificaciones;
import java.util.Base64;

/**
 *
 * @author lfben
 */
public class Encriptar {
    
    public static String EncriptarString(String str){
    
        String encriptado = Base64.getEncoder().encodeToString((str).getBytes());
        return encriptado;
    }
    
}
