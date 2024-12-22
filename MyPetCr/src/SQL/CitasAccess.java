package SQL;

import Citas.Cita;
import Notificaciones.Notificar;
import Usuarios.Usuario;
import Usuarios.Veterinario;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lfben
 */
public class CitasAccess {
    
    public static boolean validarHorario(Date fecha, String hora, int sucursal){
        ArrayList<String> list = new ArrayList<String>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE ValidarHorario ?,?,?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setDate(1, fecha);
            statement.setString(2, hora);
            statement.setInt(3, sucursal);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                list.add(" error ");
            }
   
            connection.close();
            
            return list.isEmpty();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Veterinario> veterinariosDisponibles(Date fecha, String hora, int sucursal){
        ArrayList<Veterinario> list = new ArrayList<Veterinario>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE ObtenerVeterinarioDisponible ?,?,?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setDate(1, fecha);
            statement.setString(2, hora);
            statement.setInt(3, sucursal);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idRes = resultSet.getInt(1);
                String correoRes = resultSet.getString(5);
                String nombre = resultSet.getString(6);
                String celular = resultSet.getString(8);
                list.add(new Veterinario(idRes, correoRes, sucursal, nombre, celular));
            }
            
            connection.close();
            

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return list;
        }
    }
    
    public static boolean programarCita(int idUsuario, int idVeterinario, Date fecha, String hora){
        int idGenerado = -1;
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE ProgramarCita ?,?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idUsuario);
            statement.setInt(2, idVeterinario);
            statement.setDate(3, fecha);
            statement.setString(4, hora);
            
            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                idGenerado = resultSet.getInt(1);
            }
               
            connection.close();
            
            //Notificar
            Notificar.NotificarCreaciónCita(idGenerado);
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static Cita programarCitaEmergente(int idUsuario, int idVeterinario){
        ArrayList<Cita> list = new ArrayList<Cita>();
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE ProgramarCitaEmergente ?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idUsuario);
            statement.setInt(2, idVeterinario);
            
            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idCita = resultSet.getInt(1);
                int idVeterinarioResult = resultSet.getInt(3);
                Date fecha = resultSet.getDate(4);
                String hora = resultSet.getString(5);
                int estado = resultSet.getInt(6);
                String nombre = resultSet.getString(12);
                list.add(new Cita(idCita, idUsuario, idVeterinarioResult, fecha, hora, estado, nombre));
            }
                        
            connection.close();
            if(list.isEmpty()){
                return null;
            }
            return list.get(0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<Cita> getCitasProgramadasCliente(int idUsuario){
        ArrayList<Cita> list = new ArrayList<Cita>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarCitasProgramadasUsuario ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idUsuario);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idCita = resultSet.getInt(1);
                int idVeterinario = resultSet.getInt(3);
                Date fecha = resultSet.getDate(4);
                String hora = resultSet.getString(5);
                int estado = resultSet.getInt(6);
                String nombre = resultSet.getString(13);
                list.add(new Cita(idCita, idUsuario, idVeterinario, fecha, hora, estado, nombre));
            }
            
            connection.close();
            

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return list;
        }
    }
 
    public static boolean cancelarCita(int id){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String deleteSql = "EXECUTE CancelarCita ?";
            PreparedStatement statement = connection.prepareStatement(deleteSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, id);
            
            //Ejecutar el statement
            statement.executeUpdate();
            
            connection.close();
                  
            //Notificar
            Notificar.NotificarCancelaciónCita(id);
                        
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Cita> getCitasProgramadasVeterinario(int idVeterinario){
        ArrayList<Cita> list = new ArrayList<Cita>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarCitasProgramadasVeterinario ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idVeterinario);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idCita = resultSet.getInt(1);
                int idUsuario = resultSet.getInt(2);
                Date fecha = resultSet.getDate(4);
                String hora = resultSet.getString(5);
                int estado = resultSet.getInt(6);
                String nombre = resultSet.getString(13);
                String nombreCliente = resultSet.getString(19);
                list.add(new Cita(idCita, idUsuario, idVeterinario, fecha, hora, estado, nombre, nombreCliente));
            }
            
            connection.close();
            

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return list;
        }
    }

    public static ArrayList<Cita> getCitasProgramadas(){
        ArrayList<Cita> list = new ArrayList<Cita>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarCitas ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, 1);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idCita = resultSet.getInt(1);
                int idUsuario = resultSet.getInt(2);
                int idVeterinario = resultSet.getInt(3);
                Date fecha = resultSet.getDate(4);
                String hora = resultSet.getString(5);
                int estado = resultSet.getInt(6);
                String nombre = resultSet.getString(13);
                String nombreCliente = resultSet.getString(19);
                list.add(new Cita(idCita, idUsuario, idVeterinario, fecha, hora, estado, nombre, nombreCliente));
            }
            
            connection.close();
            

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return list;
        }
    }
    
    public static ArrayList<Cita> getCitasPorCobrar(){
        ArrayList<Cita> list = new ArrayList<Cita>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarCitas ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, 3);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idCita = resultSet.getInt(1);
                int idUsuario = resultSet.getInt(2);
                int idVeterinario = resultSet.getInt(3);
                Date fecha = resultSet.getDate(4);
                String hora = resultSet.getString(5);
                int estado = resultSet.getInt(6);
                String nombre = resultSet.getString(13);
                String nombreCliente = resultSet.getString(19);
                list.add(new Cita(idCita, idUsuario, idVeterinario, fecha, hora, estado, nombre, nombreCliente));
            }
            
            connection.close();
            

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return list;
        }
    }
    
    public static int cobrarCita(int id){
        int total = 0;
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String deleteSql = "EXECUTE CobrarCita ?";
            PreparedStatement statement = connection.prepareStatement(deleteSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, id);
            
            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                total = resultSet.getInt(1);
            }
            
            connection.close();
            return total;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static ArrayList<String> getReciboCita(int id){
        ArrayList<String> list = new ArrayList<String>();
        int encabezadoActual = -1;
        boolean nuevo = true;

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE RetornarReciboCita ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, id);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(); 

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int revisandoEncabezado = resultSet.getInt(1);
                
                if(revisandoEncabezado!=encabezadoActual){
                    encabezadoActual = revisandoEncabezado;
                    nuevo = true;
                    
                }else{
                    nuevo = false;
                    
                }
                
                if(nuevo){
                    //Meter encabezado
                    list.add(
                        " "
                    );
                    list.add(
                        "Id: " + resultSet.getInt(1) + " - " + resultSet.getDate(2) + " a las " + resultSet.getString(3).substring(0,5)
                    );
                    list.add(
                        "Mascota: " + resultSet.getString(5)
                    );
                    list.add(
                        "Cliente: " + resultSet.getString(7)
                    );
                    list.add(
                        "Veterinario: " + resultSet.getString(6)
                    );
                    list.add(
                        "Total: " + resultSet.getInt(4) + " colones."
                    );
                    
                    //Meter item
                    list.add(
                        "\t          " + resultSet.getString(8) + " - " + resultSet.getInt(9) + " colones."
                    );  
                }else{
                    //Meter item
                    list.add(
                        "\t          " + resultSet.getString(8) + " - " + resultSet.getInt(9) + " colones."
                    );  
                }
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }
    }
    
    public static ArrayList<String> getReciboTodasCitas(){
        ArrayList<String> list = new ArrayList<String>();
        int encabezadoActual = -1;
        boolean nuevo = true;

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String selectSql = "EXECUTE RetornarTodosRecibosCita";
            Statement statement = connection.createStatement();

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(selectSql); 

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int revisandoEncabezado = resultSet.getInt(1);
                
                if(revisandoEncabezado!=encabezadoActual){
                    encabezadoActual = revisandoEncabezado;
                    nuevo = true;
                    
                }else{
                    nuevo = false;
                    
                }
                
                if(nuevo){
                    //Meter encabezado
                    list.add(
                        " "
                    );
                    list.add(
                        "Id: " + resultSet.getInt(1) + " - " + resultSet.getDate(2) + " a las " + resultSet.getString(3).substring(0,5)
                    );
                    list.add(
                        "Mascota: " + resultSet.getString(5)
                    );
                    list.add(
                        "Cliente: " + resultSet.getString(7)
                    );
                    list.add(
                        "Veterinario: " + resultSet.getString(6)
                    );
                    list.add(
                        "Total: " + resultSet.getInt(4) + " colones."
                    );
                    
                    //Meter item
                    list.add(
                        "\t          " + resultSet.getString(8) + " - " + resultSet.getInt(9) + " colones."
                    );  
                }else{
                    //Meter item
                    list.add(
                        "\t          " + resultSet.getString(8) + " - " + resultSet.getInt(9) + " colones."
                    );  
                }
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }
    }

    public static Cita getCita(int id){
        ArrayList<Cita> list = new ArrayList<Cita>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarCitaPorSuId ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, id);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idCita = resultSet.getInt(1);
                int idUsuario = resultSet.getInt(2);
                int idVeterinario = resultSet.getInt(3);
                Date fecha = resultSet.getDate(4);
                String hora = resultSet.getString(5);
                int estado = resultSet.getInt(6);
                String correoVeterinario = resultSet.getString(12);
                String correoCliente = resultSet.getString(18);
                list.add(new Cita(idCita, idUsuario, idVeterinario, fecha, hora, estado, correoVeterinario, correoCliente));
                //Guarda el correo en lugar del nombre en el objeto cita.
            }
            
            connection.close();
            
            if(list.isEmpty()){
                return null;
            }
            return list.get(0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
