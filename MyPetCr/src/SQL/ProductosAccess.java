package SQL;

import Productos.Producto;
import Usuarios.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lfben
 */
public class ProductosAccess {
        
    public static ArrayList<Producto> getProductos(){
        ArrayList<Producto> list = new ArrayList<Producto>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el statement
            Statement statement = connection.createStatement();
            String selectSql = "EXECUTE [dbo].[SeleccionarProductos]";

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(selectSql); 

            //Obtener los resultados del statement
            while (resultSet.next()) {
                list.add(
                        new Producto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getString(6)
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
    
    public static boolean insertProducto(Producto producto){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE [dbo].[CrearNuevoProducto] ?,?,?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setString(1, producto.nombre);
            statement.setString(2, producto.descripcion);
            statement.setInt(3, producto.precio);
            statement.setInt(4, producto.stock);
            statement.setString(5, producto.imagen);
            
            //Ejecutar el statement
            statement.execute();
                        
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateProducto(Producto producto){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String updateSql = "EXECUTE [dbo].[EditarProducto] ?,?,?,?,?,?";
            PreparedStatement statement = connection.prepareStatement(updateSql); 
            
            //Pasarle los datos al statement
            statement.setString(1, producto.codigo);
            statement.setString(2, producto.nombre);
            statement.setString(3, producto.descripcion);
            statement.setInt(4, producto.precio);
            statement.setInt(5, producto.stock);
            statement.setString(6, producto.imagen);
            
            //Ejecutar el statement
            statement.executeUpdate();
            
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteProducto(String id){
        String str = "";
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String deleteSql = "EXECUTE [dbo].[BorrarProducto] ?";
            PreparedStatement statement = connection.prepareStatement(deleteSql); 
            
            //Pasarle los datos al statement
            statement.setString(1, id);
            
            //Ejecutar el statement
            statement.executeUpdate();
            
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static Producto getProductoPorId(String id){
        ArrayList<Producto> list = new ArrayList<Producto>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarProductoPorId ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, Integer.parseInt(id));

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();

            //Obtener los resultados del statement
            while (resultSet.next()) {
                String codigo = resultSet.getString(1);
                String nombre = resultSet.getString(2);
                String descripcion = resultSet.getString(3);
                int precio = resultSet.getInt(4);
                int stock = resultSet.getInt(5);
                String nombreImagen = resultSet.getString(6);
                list.add(new Producto(codigo, nombre, descripcion, precio, stock, nombreImagen));
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
    
    public static ArrayList<String> getResenas(String id){
        ArrayList<String> list = new ArrayList<String>();

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarResenasPorIdProyecto ?";
            PreparedStatement statement = connection.prepareStatement(querySql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, Integer.parseInt(id));

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery(); 

            //Obtener los resultados del statement
            while (resultSet.next()) {
                list.add(
                    resultSet.getString(1) + " (" + resultSet.getInt(2) + " estrellas): " + resultSet.getString(3)
                );
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return list;
        }
    }
    
    public static boolean insertResena(String codigo, String nombre, int estrellas, String comentario){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE RegistrarResena ?,?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, Integer.parseInt(codigo));
            statement.setString(2, nombre);
            statement.setInt(3, estrellas);
            statement.setString(4, comentario);
            
            //Ejecutar el statement
            statement.execute();
                        
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
 
    public static boolean auditoriaProducto(int idCliente, Producto producto){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE LoguearAuditoriaSeleccionProducto ?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idCliente);
            statement.setInt(2, Integer.parseInt(producto.codigo));
            
            //Ejecutar el statement
            statement.execute();
                        
            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
