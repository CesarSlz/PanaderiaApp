package com.barbaro.panaderiaapp.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.barbaro.panaderiaap.models.Pan;

public class DatabaseManager {

	private Connection conn;
	
	public DatabaseManager(Connection conn) {
		this.conn = conn;
	}
	
	public int addPan(Pan pan) {
		
		String query = "INSERT INTO pan(nombre, descripcion, tamanyo, precio)"
				+ " VALUES(?, ?, ?, ?)";
		
		PreparedStatement stmnt = null;
		int result = -1;
		
		try {
			stmnt = conn.prepareStatement(query);
			
			stmnt.setString(1, pan.getNombre());
			stmnt.setString(2,pan.getDescripcion());
			stmnt.setString(3, pan.getTamanyo());
			stmnt.setFloat(4, pan.getPrecio());
			
			result = stmnt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmnt != null) {
				try {
					stmnt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
		
	}
	
	public int updatePan(Pan pan) {
		String query = "UPDATE pan SET nombre = ?, descripcion = ?,"
				+ " tamanyo = ?, precio = ? WHERE id = ?";
		
		PreparedStatement stmnt = null;
		int result = -1;
		
		try {
			stmnt = conn.prepareStatement(query);
			
			stmnt.setString(1, pan.getNombre());
			stmnt.setString(2,pan.getDescripcion());
			stmnt.setString(3, pan.getTamanyo());
			stmnt.setFloat(4, pan.getPrecio());
			stmnt.setInt(5, pan.getId());
			
			result = stmnt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmnt != null) {
				try {
					stmnt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public int deletePan(int id) {
		String query = "DELETE FROM pan WHERE id = ?";
		
		PreparedStatement stmnt = null;
		int result = -1;
		
		try {
			stmnt = conn.prepareStatement(query);
			
			stmnt.setInt(1, id);
			
			result = stmnt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmnt != null) {
				try {
					stmnt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public List<Pan> getPanes(){
		List<Pan> listaPanes = new ArrayList<Pan>();
		
		Statement stmnt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM pan";
		try {
			stmnt = conn.createStatement();
			
			rs = stmnt.executeQuery(query);
			
			while(rs.next()) {
				Pan pan = new Pan();
				
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String descripcion = rs.getString(3);
				float precio = rs.getFloat(4);
				String tamanyo = rs.getString(5);
				Date fecha = rs.getDate(6);
				
				pan.setId(id);
				pan.setNombre(nombre);
				pan.setDescripcion(descripcion);
				pan.setPrecio(precio);
				pan.setTamanyo(tamanyo);
				pan.setFecha(fecha);
				
				listaPanes.add(pan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmnt != null) {
				try {
					stmnt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return listaPanes;
	}
	
	public Pan getPanById(int id) {
		String query = "SELECT * FROM pan WHERE id = ?";
		PreparedStatement stmnt = null;
		ResultSet rs = null;
		
		Pan pan = null;
		
		try {
			stmnt = conn.prepareStatement(query);
			stmnt.setInt(1, id);
			rs = stmnt.executeQuery();
			
			if(rs.first()) {
				String nombre = rs.getString(2);
				String descripcion = rs.getString(3);
				float precio = rs.getFloat(4);
				String tamanyo = rs.getString(5);
				Date fecha = rs.getDate(6);
				
				pan = new Pan();
				
				pan.setId(id);
				pan.setNombre(nombre);
				pan.setDescripcion(descripcion);
				pan.setPrecio(precio);
				pan.setTamanyo(tamanyo);
				pan.setFecha(fecha);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo en operacion con la base de datos");
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmnt != null) {
				try {
					stmnt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return pan;
	}
}
