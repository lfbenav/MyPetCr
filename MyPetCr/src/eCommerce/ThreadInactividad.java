package eCommerce;

/**
 *
 * @author lfben
 */
public class ThreadInactividad extends Thread{
    
    
    int tiempo;
    int contador = 0;
    eCommerceScreen ventana;
    boolean running = true;
    boolean paused = false;
    boolean dead = false;

    public ThreadInactividad(eCommerceScreen ventana, int tiempoSegundos) {
        this.ventana = ventana;
        this.tiempo = tiempoSegundos;
    }
    
    @Override
    public void run(){
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {}
        
        while(running){
            //Si la app termina, terminar el thread
            if(dead){
                return;
            }
        
            //Si se pausa, esperese
            while(paused){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {}
            }
            
            //Si la app termina, terminar el thread
            if(dead){
                return;
            }
            
            //Si se ha esperado @tiempo segundos, cierra la app
            if(contador == tiempo){
                cerrarVentana();
            }
            
            //Esperar un segundo y aumentar el contador
            try {
                Thread.sleep(1000);
                contador ++;
            } catch (InterruptedException ex) {}
           
        }
        ventana.cerrarEstaVentana();
        System.out.println("Ha estado inactivo mucho tiempo");
        System.exit(0);
    }
    
    public void reestablecerTiempo(){
        contador = 0;
    }
    public void pausar(){
        paused = true;
    }
    public void reanudar(){
        reestablecerTiempo();
        paused = false;
    }
    public void cerrarVentana(){
        paused = false;
        running = false;
    }
    public void apagar(){
        paused = false;
        dead = true;
    }
    
}
