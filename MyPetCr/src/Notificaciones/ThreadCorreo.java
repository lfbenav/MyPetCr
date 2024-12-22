package Notificaciones;

/**
 *
 * @author lfben
 */
public class ThreadCorreo extends Thread{
    
    String destinatario;
    String asunto;
    String mensaje;

    public ThreadCorreo(String destinatario, String asunto, String mensaje) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }
    
    @Override
    public void run(){
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {}
        
        new MandarCorreo(destinatario, asunto, mensaje);
        
    }

    
}
