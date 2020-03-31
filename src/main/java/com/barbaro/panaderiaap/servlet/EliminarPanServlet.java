package com.barbaro.panaderiaap.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barbaro.panaderiaapp.util.DatabaseManager;
import com.barbaro.panaderiaapp.util.DatabaseUtil;

@WebServlet(name="EliminarPanServlet", urlPatterns = {"/pan/eliminar"})
public class EliminarPanServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String txtId = req.getParameter("txtId");
		Connection conn = null;
		DatabaseManager dbManager = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			dbManager = new DatabaseManager(conn);
			
			dbManager.deletePan(Integer.parseInt(txtId));
			
			DatabaseUtil.closeConnection(conn);
			
			resp.sendRedirect(getServletContext().getContextPath() + "/panes");
		}catch(Exception e) {
			
		}finally {
			
		}
		
		
	}

}
