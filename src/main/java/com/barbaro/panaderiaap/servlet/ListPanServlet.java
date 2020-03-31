package com.barbaro.panaderiaap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barbaro.panaderiaap.models.Pan;
import com.barbaro.panaderiaapp.util.DatabaseUtil;

@WebServlet(name="ListPanServlet", urlPatterns = {"/panes"})
public class ListPanServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Identificar fuente de datos (Base de datos, archivo, REST API)
		
		List<Pan> listaPanes = new ArrayList<>();
		
		// Objeto para establecer la conexion con la base de datos
		Connection conn = null;
		
		// Objeto para decirle a la base de datos que hacer (operacion)
		Statement stmnt = null;
		
		// Objeto para manipular los datos que regresa la consulta (operacion)
		ResultSet rs = null;
		
		// Consulta para obtencion de datos
		String query = "SELECT * FROM pan";
		
		// Obtener conexion a la base de datos
		conn = DatabaseUtil.getConnection();
		
		if(conn != null) {
			
			try {
				
				// Crear comando para realizar operaciones en la base de datos
				// SELECT, INSERT, UPDATE, DELETE
				stmnt = conn.createStatement();
				
				// Ejecutar la operecion indicada por el comando
				// Guardar los resultados obtenidos
				rs = stmnt.executeQuery(query);
				
				// Iterar todo el conjunto de resulatdos por fila
				while(rs.next()) {
					
					// Crear instacia del modelo
					Pan pan = new Pan();
					
					// Obtener valores de las celdas por su tipo de dato a 
					// traves de su indice
					int id = rs.getInt(1);
					String nombre = rs.getString(2);
					String descripcion = rs.getString(3);
					float precio = rs.getFloat(4);
					String tamanyo = rs.getString(5);
					Date fecha = rs.getDate(6);
					
					// Llenar de datos el POJO
					pan.setId(id);
					pan.setNombre(nombre);
					pan.setDescripcion(descripcion);
					pan.setPrecio(precio);
					pan.setTamanyo(tamanyo);
					pan.setFecha(fecha);
					
					// Agregar un modelo a la lista
					listaPanes.add(pan);
					
				}
				
				stmnt.close();
				rs.close();
				DatabaseUtil.closeConnection(conn);
				
				req.setAttribute("listaPanes", listaPanes);
				RequestDispatcher dispatcher = req.getRequestDispatcher("panes.jsp");
				dispatcher.forward(req, resp);
				
			}catch(SQLException e){
				System.out.println("Fallo al crear statement");
			}catch(Exception e) {
				e.printStackTrace();
			}

		} else {
			resp.setContentType("text/html");
			resp.getWriter().println("<h2>No se conecto a la base de datos</h2");
		}
		
		
	}

}
