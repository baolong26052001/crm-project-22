package crm_project_22.service;

import java.util.List;

import crm_project_22.entity.NguoiDung;
import crm_project_22.repository.NguoiDungRepository;
import crm_project_22.repository.UserRepository;

public class UserService {
	private UserRepository userRepository = new UserRepository();
	
	public List<NguoiDung> getAllNguoiDung() {
		return userRepository.getAllNguoiDung();
	}
	public boolean deleteUser(int id) {
		int count = userRepository.deleteById(id);
		return count > 0;
	}
	public boolean AddUser(String fullname, String email, String password, String phone, String address) {
		boolean isSuccess = userRepository.addUser(fullname, email, password, phone, address);
		return isSuccess;
	}
}
