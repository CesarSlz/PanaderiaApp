package com.barbaro.panaderiaapp.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	public static final String URL_FORMAT = "jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT-5";
	
	public static Connection getConnection() {
		
		String serverHost = "localhost";
		String serverPort = "3306";
		String databaseName = "panaderia";
		String databaseUser = "root";
		String databasePass = "Finde1997.";
		
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = String.format(URL_FORMAT, serverHost, serverPort, databaseName);
			conn = DriverManager.getConnection(url, databaseUser, databasePass);
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo algo al realizar la conexion");
		}
		
		return conn;
	}
	
	public static Connection getConnection(InputStream fileStream) {
		return null;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("No se cerro correctamente");
		}
	}
}
