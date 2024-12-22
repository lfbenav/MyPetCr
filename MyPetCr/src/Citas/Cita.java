package Citas;

import java.sql.Date;

/**
 *
 * @author lfben
 */
public class Cita {
    
    public int idCita;
    public int idUsuario;
    public int idVeterinario;
    public java.sql.Date fecha;
    public String hora;
    public int estado;
    public String nombreVeterinario;
    public String nombreCliente;
    
    public final int PROGRAMADA = 1;
    public final int CANCELADA = 2;
    public final int POR_COBRAR = 3;
    public final int COBRADA = 4;

    public Cita(int idCita, int idUsuario, int idVeterinario, Date fecha, String hora, int estado, String nombreVeterinario) {
        this.idCita = idCita;
        this.idUsuario = idUsuario;
        this.idVeterinario = idVeterinario;
        this.fecha = fecha;
        this.hora = hora.substring(0,5);
        this.estado = estado;
        this.nombreVeterinario = nombreVeterinario;
        this.nombreCliente = "n/a";
    }

    public Cita(int idCita, int idUsuario, int idVeterinario, Date fecha, String hora, int estado, String nombreVeterinario, String nombreCliente) {
        this.idCita = idCita;
        this.idUsuario = idUsuario;
        this.idVeterinario = idVeterinario;
        this.fecha = fecha;
        this.hora = hora.substring(0,5);
        this.estado = estado;
        this.nombreVeterinario = nombreVeterinario;
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return "Cita{" + "idCita=" + idCita + ", idUsuario=" + idUsuario + ", idVeterinario=" + idVeterinario + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + ", nombreVeterinario=" + nombreVeterinario + ", nombreCliente=" + nombreCliente + ", PROGRAMADA=" + PROGRAMADA + ", CANCELADA=" + CANCELADA + ", POR_COBRAR=" + POR_COBRAR + ", COBRADA=" + COBRADA + '}';
    }
    
    
    
    
}
