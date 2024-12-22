package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lfben
 */
public class SQLConnection {
    private static final String connectionString =
                "jdbc:sqlserver://WisferJr\\SQLEXPRESS:1433;"
                + "database=MyPetCr;"
                + "user=sa;"
                + "password=48966;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

    private SQLConnection() {
    }
    
    public static Connection getConnection(){
        try {
            Connection connection;
            connection = DriverManager.getConnection(connectionString);
            return connection;
        } catch (SQLException ex) {}
        return null;
    }
}
