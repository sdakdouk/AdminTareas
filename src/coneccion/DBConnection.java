package coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static final String JDBC_URL = "jdbc:mysql://halifaxtraining.es:3306/ciberkaos002";
	private static Connection instance = null;

	private DBConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

	}

	public static Connection getConnection() throws SQLException  {

		if (instance == null) {
			Properties props = new Properties();
			props.put("user", "uss002");
			props.put("password", "erizodemar2019");
             try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				instance = DriverManager.getConnection(JDBC_URL, props);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return instance;
	}


}
