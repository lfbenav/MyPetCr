package SQL;

import Usuarios.*;
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
public class UsuariosAccess {
    
    public static Usuario iniciarSesion(String correo, String contrasena){
        ArrayList<Usuario> list = new ArrayList<Usuario>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE IniciarSesion ?,?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setString(1, correo);
            statement.setString(2, contrasena);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int tipo = resultSet.getInt(5);
                int id = resultSet.getInt(1);
                String correoRes = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String celular = resultSet.getString(4);
                                
                if(tipo==Usuario.CLIENTE){
                    list.add(new Cliente(id, correoRes, nombre, celular));
                }
                else if(tipo==Usuario.VETERINARIO){
                    list.add(new Veterinario(id, correoRes, -1, nombre, celular));
                }
                else if(tipo==Usuario.ADMINISTRADOR){
                    list.add(new Administrador(id, correoRes, -1, nombre, celular));
                }
                else if(tipo==Usuario.GERENTE){
                    list.add(new Gerente(id, correoRes, -1, nombre, celular));
                }
            }
            
            connection.close();
            
            if(list.isEmpty()){
                return null;
            }else{
                return list.get(0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Usuario adminPorCorreo(String correo){
        ArrayList<Usuario> list = new ArrayList<Usuario>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarAdministradorPorCorreo ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setString(1, correo);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idRes = resultSet.getInt(1);
                String correoRes = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String celular = resultSet.getString(4);
                int sucursal = resultSet.getInt(7);
                list.add(new Administrador(idRes, correoRes, sucursal, nombre, celular));
            }
            
            connection.close();
            
            if(list.isEmpty()){
                return null;
            }else{
                return list.get(0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Usuario gerentePorCorreo(String correo){
        ArrayList<Usuario> list = new ArrayList<Usuario>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarGerentePorCorreo ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setString(1, correo);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idRes = resultSet.getInt(1);
                String correoRes = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String celular = resultSet.getString(4);
                int sucursal = resultSet.getInt(7);
                list.add(new Gerente(idRes, correoRes, sucursal, nombre, celular));
            }
            
            connection.close();
            
            if(list.isEmpty()){
                return null;
            }else{
                return list.get(0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Usuario veterinarioPorCorreo(String correo){
        ArrayList<Usuario> list = new ArrayList<Usuario>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarVeterinarioPorCorreo ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setString(1, correo);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idRes = resultSet.getInt(1);
                String correoRes = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String celular = resultSet.getString(4);
                int sucursal = resultSet.getInt(7);
                list.add(new Veterinario(idRes, correoRes, sucursal, nombre, celular));
            }
            
            connection.close();
            
            if(list.isEmpty()){
                return null;
            }else{
                return list.get(0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Usuario clientePorCorreo(String correo){
        ArrayList<Usuario> list = new ArrayList<Usuario>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarClientePorCorreo ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setString(1, correo);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                int idRes = resultSet.getInt(1);
                String correoRes = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String celular = resultSet.getString(4);
                list.add(new Cliente(idRes, correoRes, nombre, celular));
            }
            
            connection.close();
            
            if(list.isEmpty()){
                return null;
            }else{
                return list.get(0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Sucursal> getSucursales(){
        ArrayList<Sucursal> list = new ArrayList<Sucursal>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el statement
            Statement statement = connection.createStatement();
            String selectSql = "EXECUTE SeleccionarSucursales";

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(selectSql);  

            //Obtener los resultados del statement
            while (resultSet.next()) {
                list.add(
                    new Sucursal(resultSet.getString(2),resultSet.getInt(1))
                );
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }
    }

    public static boolean insertCliente(String correo, String nombre, String contrasena, String celular){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE [dbo].[RegistrarCliente] ?,?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setString(1, correo);
            statement.setString(2, nombre);
            statement.setString(3, contrasena);
            statement.setString(4, celular);
            
            //Ejecutar el statement
            statement.execute();
                        
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean insertVeterinario(String correo, String nombre, String contrasena, int idSucursal, String celular){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE [dbo].[RegistrarVeterinario] ?,?,?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setString(1, correo);
            statement.setString(2, nombre);
            statement.setString(3, contrasena);
            statement.setInt(4, idSucursal);
            statement.setString(5, celular);
            
            //Ejecutar el statement
            statement.execute();
                        
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean insertAdministrador(String correo, String nombre, String contrasena, int idSucursal, String celular){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE [dbo].[RegistrarAdministrador] ?,?,?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setString(1, correo);
            statement.setString(2, nombre);
            statement.setString(3, contrasena);
            statement.setInt(4, idSucursal);
            statement.setString(5, celular);
            
            //Ejecutar el statement
            statement.execute();
                        
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean updateUsuario(int id, String correo, String nombre, String celular){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String updateSql = "EXECUTE EditarUsuario ?,?,?,?";
            PreparedStatement statement = connection.prepareStatement(updateSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, id);
            statement.setString(2, correo);
            statement.setString(3, nombre);
            statement.setString(4, celular);
            
            //Ejecutar el statement
            statement.executeUpdate();
            
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> list = new ArrayList<Cliente>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el statement
            Statement statement = connection.createStatement();
            String selectSql = "EXECUTE SeleccionarClientes";

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(selectSql); 

            //Obtener los resultados del statement
            while (resultSet.next()) {
                list.add(
                        new Cliente(
                            resultSet.getInt(1)
                            ,resultSet.getString(2)
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

    public static ArrayList<Veterinario> getVeterinarios(){
        ArrayList<Veterinario> list = new ArrayList<Veterinario>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el statement
            Statement statement = connection.createStatement();
            String selectSql = "EXECUTE SeleccionarVeterinarios";

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(selectSql); 

            //Obtener los resultados del statement
            while (resultSet.next()) {
                list.add(
                        new Veterinario(
                            resultSet.getInt(1)
                            ,resultSet.getString(2)
                            ,resultSet.getInt(7)
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

    public static ArrayList<Administrador> getAdministradores(){
        ArrayList<Administrador> list = new ArrayList<Administrador>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el statement
            Statement statement = connection.createStatement();
            String selectSql = "EXECUTE SeleccionarAdministradores";

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(selectSql); 

            //Obtener los resultados del statement
            while (resultSet.next()) {
                list.add(
                        new Administrador(
                            resultSet.getInt(1)
                            ,resultSet.getString(2)
                            ,resultSet.getInt(7)
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

    public static boolean deleteAdministrador(int id){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String deleteSql = "EXECUTE BorrarAdministrador ?";
            PreparedStatement statement = connection.prepareStatement(deleteSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, id);
            
            //Ejecutar el statement
            statement.executeUpdate();
            
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
