package crm_project_22.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project_22.service.RoleService;
import crm_project_22.service.UserService;

@WebServlet(name = "UserController", urlPatterns = {"/user-table","/user-add","/user-details"})
public class UserController extends HttpServlet {
	private UserService userService = new UserService();
	private RoleService roleService = new RoleService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/user-table":
			req.setAttribute("listUser", userService.getAllNguoiDung());
			req.getRequestDispatcher("user-table.jsp").forward(req, resp);
			break;
		case "/user-add":
			req.setAttribute("listRole", roleService.getAllLoaiThanhVien());
			req.getRequestDispatcher("user-add.jsp").forward(req, resp);
			break;
		case "/user-details":
			req.getRequestDispatcher("user-details.jsp").forward(req, resp);
			break;
		default:
			break;
		}
		

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/user-table": 
			req.setAttribute("listUser", userService.getAllNguoiDung());
			req.getRequestDispatcher("user-table.jsp").forward(req, resp);
			break;
		case "/user-add":
			String fullname = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			int id_loaithanhvien = Integer.parseInt(req.getParameter("id_loaithanhvien"));
			boolean isSuccess = userService.AddUser(fullname, email, password, phone, address, id_loaithanhvien);
			req.setAttribute("isSuccess", isSuccess);
			req.getRequestDispatcher("user-add.jsp").forward(req, resp);
			break;
		case "/user-details":
			req.getRequestDispatcher("user-details.jsp").forward(req, resp);
			break;
		default:
			break;
		}

	}
}
