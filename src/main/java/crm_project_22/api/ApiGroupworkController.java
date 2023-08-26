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

@WebServlet(name = "apiGroupworkController", urlPatterns = {"/api/groupwork/delete"})
public class ApiGroupworkController extends HttpServlet{
	private Gson gson = new Gson();
	private GroupworkService groupworkService = new GroupworkService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean isSuccess = groupworkService.deleteGroupwork(id);
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
