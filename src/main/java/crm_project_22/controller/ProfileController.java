package crm_project_22.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProfileController", urlPatterns = {"/profile","/profile-edit"})
public class ProfileController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
			case "/profile": 
				
				req.getRequestDispatcher("profile.jsp").forward(req, resp);
				break;
			
			case "/profile-edit": 				
				req.getRequestDispatcher("profile-edit.jsp").forward(req, resp);
				break;
				
			default:
				break;
			
			
		}
		

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
			case "/profile": 
				
				req.getRequestDispatcher("profile.jsp").forward(req, resp);
				break;
			
			case "/profile-edit": 				
				req.getRequestDispatcher("profile-edit.jsp").forward(req, resp);
				break;
				
			default:
				break;
			
			
		}

	}
}
