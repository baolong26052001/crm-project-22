package crm_project_22.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project_22.service.TaskService;

@WebServlet(name = "TaskController", urlPatterns = {"/task", "/task-add"})
public class TaskController extends HttpServlet {
	private TaskService taskService = new TaskService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/task": 
			req.setAttribute("listTask", taskService.getAllCongViec());
			req.getRequestDispatcher("task.jsp").forward(req, resp);
			
			break;
		
		case "/task-add":
			req.getRequestDispatcher("task-add.jsp").forward(req, resp);
			break;
		
		default:
			break;
		}
		

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/task": 
			req.getRequestDispatcher("task.jsp").forward(req, resp);
			break;
			
		case "/task-add":
			req.getRequestDispatcher("task-add.jsp").forward(req, resp);
			break;
			
		default:
			break;
		}

	}
}
