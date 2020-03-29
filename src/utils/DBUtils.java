package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils {
    private static DataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public static DataSource getDataSource(){return dataSource;}

    public static Connection getCurrentConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null){
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }

    public static void startTransaction() throws SQLException {
        Connection connection = getCurrentConnection();
        if (connection != null){
            connection.setAutoCommit(false);
        }
    }

    public static void rollBack() throws SQLException {
        Connection connection = getCurrentConnection();
        if (connection != null){
            connection.rollback();
        }
    }

    public static void CCR() throws SQLException {
        Connection connection = getCurrentConnection();
        if (connection != null){
            connection.commit();
            connection.close();
            threadLocal.remove();
        }
    }
}


