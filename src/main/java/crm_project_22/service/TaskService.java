package crm_project_22.service;

import java.util.List;

import crm_project_22.entity.CongViec;
import crm_project_22.repository.TaskRepository;

public class TaskService {
	private TaskRepository taskRepository = new TaskRepository();
	public List<CongViec> getAllCongViec() {
		return taskRepository.getAllCongViec();
	}
	public boolean deleteTask(int id) {
		int count = taskRepository.deleteById(id);
		return count > 0;
	}
	public boolean addTask(String ten, int id_duan, int id_nguoidung, String ngaybatdau, String ngayketthuc, int id_trangthai) {
		boolean isSuccess = taskRepository.AddTask(ten, id_duan, id_nguoidung, ngaybatdau, ngayketthuc, id_trangthai);
		return isSuccess;
	}
}
