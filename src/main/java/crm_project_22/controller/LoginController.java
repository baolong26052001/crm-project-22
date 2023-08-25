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
import crm_project_22.entity.NguoiDung;
import crm_project_22.service.LoginService;



@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String matkhau = req.getParameter("password");
		
		boolean isSuccess = loginService.checkLogin(req, email, matkhau);
		
		
		
		req.setAttribute("isSuccess", isSuccess);
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		
		
	}
}
