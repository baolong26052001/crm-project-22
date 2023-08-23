package crm_project_22.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project_22.config.MysqlConfig;
import crm_project_22.entity.LoaiThanhVien;
import crm_project_22.service.RoleService;
import crm_project_22.service.LoginService;

@WebServlet(name = "RoleController", urlPatterns = {"/role-table", "/role-add"})
public class RoleController extends HttpServlet {
	
	private RoleService roleService = new RoleService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
			case "/role-table": 
				req.setAttribute("listRole", roleService.getAllLoaiThanhVien());
				req.getRequestDispatcher("role-table.jsp").forward(req, resp);
				break;
			
			case "/role-add": 				
				req.getRequestDispatcher("role-add.jsp").forward(req, resp);
				break;
				
			default:
				break;
			
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
			
			
			case "/role-add":		
				String rolename = req.getParameter("rolename");
				String description = req.getParameter("description");
				boolean isSuccess = roleService.AddRole(rolename, description);
				
				req.setAttribute("isSuccess", isSuccess);
				req.getRequestDispatcher("role-add.jsp").forward(req, resp);
				break;
				
			default:
				break;
			
			
		}
		
		
	}
}
