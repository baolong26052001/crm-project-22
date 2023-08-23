package crm_project_22.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project_22.service.GroupworkService;

@WebServlet(name = "GroupworkController", urlPatterns = {"/groupwork","/groupwork-details","/groupwork-add"})
public class GroupworkController extends HttpServlet {
	
	private GroupworkService groupworkService = new GroupworkService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		
		case "/groupwork":
			req.setAttribute("listGroupwork", groupworkService.getAllDuAn());
			req.getRequestDispatcher("groupwork.jsp").forward(req, resp);
			break;
			
		case "/groupwork-details":
			req.getRequestDispatcher("groupwork-details.jsp").forward(req, resp);
			break;
			
		case "/groupwork-add":
			req.getRequestDispatcher("groupwork-add.jsp").forward(req, resp);
			break;
			
		default:
			break;
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/groupwork": 
			req.getRequestDispatcher("groupwork.jsp").forward(req, resp);
			break;
			
		case "/groupwork-details":
			req.getRequestDispatcher("groupwork-details.jsp").forward(req, resp);
			break;
		
		case "/groupwork-add":
			req.getRequestDispatcher("groupwork-add.jsp").forward(req, resp);
			break;
			
		default:
			break;
		}
	}
	
}