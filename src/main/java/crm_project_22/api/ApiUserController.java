package crm_project_22.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crm_project_22.payload.response.BaseResponse;
import crm_project_22.service.GroupworkService;
import crm_project_22.service.TaskService;
import crm_project_22.service.UserService;

@WebServlet(name = "apiUserController", urlPatterns = {"/api/user/delete"})
public class ApiUserController extends HttpServlet{
	private Gson gson = new Gson();
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean isSuccess = userService.deleteUser(id);
		BaseResponse response = new BaseResponse();
		response.setStatusCode(200);
		response.setMessage(isSuccess ? "Xoa thanh cong" : "Xoa that bai");
		response.setData(isSuccess);
		
		String json = gson.toJson(response);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
        out.print(json);
        out.flush();
	}
}
