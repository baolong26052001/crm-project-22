package crm_project_22.service;

import java.util.List;

import crm_project_22.entity.DuAn;
import crm_project_22.entity.LoaiThanhVien;
import crm_project_22.repository.GroupworkRepository;
import crm_project_22.repository.LoaiThanhVienRepository;

public class GroupworkService {
	private GroupworkRepository groupworkRepository = new GroupworkRepository();
	public List<DuAn> getAllDuAn() {
		return groupworkRepository.getAllDuAn();
	}
}
