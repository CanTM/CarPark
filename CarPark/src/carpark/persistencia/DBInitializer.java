/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark.persistencia;

import java.sql.Connection;
import javax.sql.DataSource;
import org.apache.derby.jdbc.ClientConnectionPoolDataSource;

/**
 *
 * @author CanTM
 */
public class DBInitializer {

    public static String DB_NAME = "CarPark";
    public static String USER_NAME = "usuario";
    public static String PASSWORD = "senha";
    private static DataSource dataSource;

    private static DataSource createDataSource() throws Exception {
        if (dataSource == null) {
            ClientConnectionPoolDataSource ds = new ClientConnectionPoolDataSource();
            ds.setDatabaseName(DB_NAME);
            ds.setUser(USER_NAME);
            ds.setPassword(PASSWORD);
            dataSource = (DataSource) ds;
        }
        return dataSource;
    }

    public static Connection conectarBd() throws Exception {
        return createDataSource().getConnection();
    }
}
