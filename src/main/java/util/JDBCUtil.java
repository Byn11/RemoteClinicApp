package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	//以下、ローカル環境
	//jdbc:h2:tcp://localhost/~/example
	//以下、クラウド環境
	//jdbc:h2:tcp://my-h2-service.default.svc.cluster.local:9092/test
	private static String driverName = "org.h2.Driver";

    //private static String url = "jdbc:h2:tcp://my-h2-service.default.svc.cluster.local:9092/test";
    private static String url = "jdbc:h2:tcp://localhost/~/example";
    //private static String url = "jdbc:h2:tcp://my-h2-service.default.svc.cluster.local:9092/test";

    private static String user = "sa";
    private static String password = "";

    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}