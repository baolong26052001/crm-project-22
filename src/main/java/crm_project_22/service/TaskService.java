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
}
