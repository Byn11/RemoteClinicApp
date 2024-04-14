package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public DBUtil() {
		loadDriver();
	}
	private void loadDriver() {
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBC loading failed");
		}
	}
	public Connection getConnection() throws SQLException{
		//以下、ローカル環境
		//jdbc:h2:tcp://localhost/~/example
		//以下、クラウド環境


		//jdbc:h2:tcp://my-h2-service.default.svc.cluster.local:9092/test
		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/example","sa","");

		return con;
	}
	public void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}