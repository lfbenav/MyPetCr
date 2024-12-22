package SQL;

import Usuarios.Mascota;
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
public class MascotasAccess {
    
    public static ArrayList<Mascota> getMascotas(int idUsuario){
        ArrayList<Mascota> list = new ArrayList<Mascota>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarMascotasId ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idUsuario);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(); 

            //Obtener los resultados del statement
            while (resultSet.next()) {
                list.add(
                        new Mascota(
                                resultSet.getInt(1)
                                ,resultSet.getInt(2)
                                ,resultSet.getString(3)
                                ,resultSet.getString(4)
                        )
                );
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }
    }
    
    public static ArrayList<Mascota> getTodasLasMascotas(){
        ArrayList<Mascota> list = new ArrayList<Mascota>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            Statement statement = connection.createStatement();
            String selectSql = "EXECUTE SeleccionarMascotas";

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(selectSql);  

            //Obtener los resultados del statement
            while (resultSet.next()) {
                list.add(
                        new Mascota(
                                resultSet.getInt(1)
                                ,resultSet.getInt(2)
                                ,resultSet.getString(3)
                                ,resultSet.getString(4)
                                ,resultSet.getString(8)
                        )
                );
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }
    }
    
    public static boolean insertMascota(int idUsuario, String nombre, String tipo){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE RegistrarMascota ?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idUsuario);
            statement.setString(2, nombre);
            statement.setString(3, tipo);
            
            //Ejecutar el statement
            statement.execute();
                        
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static ArrayList<String> getExpedienteMascota(int id){
        ArrayList<String> list = new ArrayList<String>();
        int encabezadoActual = -1;
        boolean nuevo = true;

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarExpedienteId ?";
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
                        "Id: " + resultSet.getInt(1) + "     Fecha: " + resultSet.getString(4)
                    );
                    list.add(
                        "Veterinario: " + resultSet.getString(12)
                    );
                    //Meter item
                    if(resultSet.getInt(9) == 0){
                        list.add(
                            resultSet.getString(8)
                        );                    
                    }else{
                        list.add(
                            "\t            " + resultSet.getString(8) + " - " + resultSet.getInt(9) + " colones"
                        );
                    }  
                }else{
                    //Meter item
                    if(resultSet.getInt(9) == 0){
                        list.add(
                            resultSet.getString(8)
                        );                    
                    }else{
                        list.add(
                            "\t            " + resultSet.getString(8) + " - " + resultSet.getInt(9) + " colones"
                        );
                    }  
                }
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }
    }

    public static int crearEncabezadoExpediente(int idMascota, int idVeterinario, int idCita){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE ColocarEncabezadoExpediente ?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idMascota);
            statement.setInt(2, idVeterinario);
            statement.setInt(3, idCita);
            
            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();
            
            int id = -1;
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
                        
            connection.close();
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public static void crearLineaExpediente(int idEncabezado, String tratamiento, int costo){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE ColocarLineaExpediente ?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idEncabezado);
            statement.setString(2, tratamiento);
            statement.setInt(3, costo);

            //Ejecutar el statement
            statement.execute();
                                    
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Mascota getMascotaPorNombre(String nombreMascota, int idUsuario){
        ArrayList<Mascota> list = new ArrayList<Mascota>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarMascotasNombreMascota ?,?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setString(1, nombreMascota);
            statement.setInt(2, idUsuario);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(); 

            //Obtener los resultados del statement
            while (resultSet.next()) {
                list.add(
                        new Mascota(
                                resultSet.getInt(1)
                                ,resultSet.getInt(2)
                                ,resultSet.getString(3)
                                ,resultSet.getString(4)
                        )
                );
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
