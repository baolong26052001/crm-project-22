package crm_project_22.service;

import java.util.List;

import crm_project_22.entity.NguoiDung;
import crm_project_22.repository.UserRepository;

public class UserService {
	private UserRepository userRepository = new UserRepository();
	public List<NguoiDung> getAllNguoiDung() {
		return userRepository.getAllNguoiDung();
	}
}
