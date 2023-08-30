package crm_project_22.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project_22.service.GroupworkService;
import crm_project_22.service.TaskService;
import crm_project_22.service.UserService;

@WebServlet(name = "TaskController", urlPatterns = {"/task", "/task-add"})
public class TaskController extends HttpServlet {
	private TaskService taskService = new TaskService();
	private GroupworkService groupworkService = new GroupworkService();
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/task":
			req.setAttribute("listTask", taskService.getAllCongViec());
			req.getRequestDispatcher("task.jsp").forward(req, resp);
			
			break;
		
		case "/task-add":
			req.setAttribute("listGroupwork", groupworkService.getAllDuAn());
			req.setAttribute("listUser", userService.getAllNguoiDung());
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
			String ten = req.getParameter("ten");
			int id_duan = Integer.parseInt(req.getParameter("id_duan"));
			int id_nguoidung = Integer.parseInt(req.getParameter("id_nguoidung"));
			String ngaybatdau = req.getParameter("ngaybatdau");
			String ngayketthuc = req.getParameter("ngayketthuc");
			int id_trangthai = 2;
			boolean isSuccess = taskService.addTask(ten, id_duan, id_nguoidung, ngaybatdau, ngayketthuc, id_trangthai);
			
			req.setAttribute("isSuccess", isSuccess);
			req.getRequestDispatcher("task-add.jsp").forward(req, resp);
			break;
			
		default:
			break;
		}

	}
}
