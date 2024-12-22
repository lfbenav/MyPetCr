package Notificaciones;

import Citas.Cita;
import SQL.CitasAccess;
import java.sql.Date;

/**
 *
 * @author lfben
 */
public class Notificar {
    
    
    public static void EnviarCorreo(String destinatario, String asunto, String mensaje){
        new ThreadCorreo(destinatario, asunto, mensaje).start();
    }
    
    public static void NotificarAccesoNoAutorizado(String correo){
        EnviarCorreo(
            correo, 
            "Intento de acceso a su cuenta MyPetCr", 
            "Alguien acaba de ingresar con una contraseña incorrecta y su usuario.");
    }
    
    public static void NotificarCancelaciónCita(int idCita){
        Cita cita = CitasAccess.getCita(idCita);
        if(cita!=null){

            EnviarCorreo(
                    cita.nombreCliente, 
                    "Cancelación de cita de MyPetCr", 
                    "Se canceló una cita. Por favor confirme su perfil para más información.");
            EnviarCorreo(
                    cita.nombreVeterinario,
                    "Cancelación de cita de MyPetCr", 
                    "Se canceló una cita. Por favor confirme su perfil para más información.");
            
        }
    }
    
    public static void NotificarCreaciónCita(int idCita){
        Cita cita = CitasAccess.getCita(idCita);
        if(cita!=null){

            EnviarCorreo(
                    cita.nombreCliente,
                    "Creación de una nueva cita de MyPetCr.", 
                    "Se ha creado una nueva cita. Por favor confirme su perfil para más información.");
            EnviarCorreo(
                    cita.nombreVeterinario, 
                    "Creación de una nueva cita de MyPetCr.", 
                    "Se ha creado una nueva cita. Por favor confirme su perfil para más información.");
            
        }
    }
    
}
