package SQL;

import Productos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lfben
 */
public class ComprasAccess {
    
    public static int crearEncabezadoEnvio(int idUsuario, int metodoPago, String comprobante, int total, String direccion){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE RealizarEncabezadoCompraEnvio ?,?,?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idUsuario);
            statement.setInt(2, metodoPago);
            statement.setString(3, comprobante);
            statement.setInt(4, total);
            statement.setString(5, direccion);
            
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
    
    public static int crearEncabezadoRetiro(int idUsuario, int metodoPago, String comprobante, int total, int sucursal){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE RealizarEncabezadoCompraRetiro ?,?,?,?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idUsuario);
            statement.setInt(2, metodoPago);
            statement.setString(3, comprobante);
            statement.setInt(4, total);
            statement.setInt(5, sucursal);
            
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
    
    public static int crearLineaCompra(int idEncabezado, int idProducto){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE RealizarLineaCompra ?,?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idEncabezado);
            statement.setInt(2, idProducto);

            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();
                        
            int res = 20;
            while (resultSet.next()) {
                res = resultSet.getInt(1);
            }
            
            connection.close();
            return res;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 20;
        }
    }
    
    public static ArrayList<String> getHistorialUsuario(int id){
        ArrayList<String> list = new ArrayList<String>();
        int encabezadoActual = -1;
        boolean nuevo = true;

        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();
            
            //Crear el prepared statement
            String querySql = "EXECUTE SeleccionarHistorialCompraId ?";
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
                    String metodoRecibo;
                    if(resultSet.getInt(7)==0){
                        metodoRecibo = "Recibo en sucursal: " + resultSet.getString(8);
                    }else{
                        metodoRecibo = "Envio a: " + resultSet.getString(8);
                    }
                    list.add(
                        " "
                    );
                    list.add(
                        "Id: " + resultSet.getInt(1) + "     Fecha: " + resultSet.getString(2)
                    );
                    list.add(
                        "Método Pago: " + resultSet.getString(4) + "  " + resultSet.getString(5)
                    );
                    list.add(
                        metodoRecibo
                    );
                    list.add(
                        "Total: " + resultSet.getInt(3)
                    );
                    
                    //Meter item
                    list.add(
                        "\t            " + resultSet.getString(6)
                    );
                }else{
                    //Meter item
                    list.add(
                        "\t            " + resultSet.getString(6)
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

    public static int validarCompra(int idEncabezado){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE ValidarCompra ?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idEncabezado);
            
            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();
            
            int res = -1;
            while (resultSet.next()) {
                res = resultSet.getInt(1);
            }
                        
            connection.close();
            return res;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
     
    public static int precioCompra(int idEncabezado){
        try{
            //Crear la conexión
            Connection connection = SQLConnection.getConnection();

            //Crear el prepared statement
            String insertSql = "EXECUTE SeleccionarPrecioCompraIdEncabezado ?";
            PreparedStatement statement = connection.prepareStatement(insertSql); 
            
            //Pasarle los datos al statement
            statement.setInt(1, idEncabezado);
            
            //Ejecutar el statement
            ResultSet resultSet = statement.executeQuery();
            
            int res = 0;
            while (resultSet.next()) {
                res = resultSet.getInt(1);
            }
                        
            connection.close();
            return res;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
