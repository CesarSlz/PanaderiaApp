package panaderiaapp;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabaseConnection {
	
	public static final String URL_FORMAT = "jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	@Test
	public void testConnection() {
		
		String serverHost = null;
		String serverPort = null;
		String databaseName = null;
		String databaseUser = null;
		String databasePass = null;
		String url = null;
		
		Connection conn = null;
		
		serverHost = "localhost";
		serverPort = "3306";
		databaseName = "panaderia";
		databaseUser = "root";
		databasePass = "Finde1997.";
		
		// Registrar driver en mi aplicacion
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			url = String.format(URL_FORMAT, serverHost, serverPort, databaseName);
			
			conn = DriverManager.getConnection(url, databaseUser, databasePass);
			assertNotNull("La conexion no se establecio", conn);
			
		}catch(SQLException e) {
			e.printStackTrace();
			fail("Error al cargar el driver de mysql");
		} finally {
			if(conn != null) {
				try {
					conn.close();
					assertTrue("La conexion no se cerro", conn.isClosed());
				}catch(SQLException e) {
					e.printStackTrace();
					fail("Fallo al cerrar la conexion");
				}
				
			}
		}
		
	}
}
