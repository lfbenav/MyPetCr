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
            "Alguien acaba de ingresar con una contrase�a incorrecta y su usuario.");
    }
    
    public static void NotificarCancelaci�nCita(int idCita){
        Cita cita = CitasAccess.getCita(idCita);
        if(cita!=null){

            EnviarCorreo(
                    cita.nombreCliente, 
                    "Cancelaci�n de cita de MyPetCr", 
                    "Se cancel� una cita. Por favor confirme su perfil para m�s informaci�n.");
            EnviarCorreo(
                    cita.nombreVeterinario,
                    "Cancelaci�n de cita de MyPetCr", 
                    "Se cancel� una cita. Por favor confirme su perfil para m�s informaci�n.");
            
        }
    }
    
    public static void NotificarCreaci�nCita(int idCita){
        Cita cita = CitasAccess.getCita(idCita);
        if(cita!=null){

            EnviarCorreo(
                    cita.nombreCliente,
                    "Creaci�n de una nueva cita de MyPetCr.", 
                    "Se ha creado una nueva cita. Por favor confirme su perfil para m�s informaci�n.");
            EnviarCorreo(
                    cita.nombreVeterinario, 
                    "Creaci�n de una nueva cita de MyPetCr.", 
                    "Se ha creado una nueva cita. Por favor confirme su perfil para m�s informaci�n.");
            
        }
    }
    
}
