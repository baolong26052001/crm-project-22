package crm_project_22.service;

import java.sql.Timestamp;
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
	public boolean deleteGroupwork(int id) {
		int count = groupworkRepository.deleteById(id);
		return count > 0;
	}
	public boolean addGroupwork(String ten, String ngaybatdau, String ngayketthuc) {
		boolean isSuccess = groupworkRepository.AddGroupwork(ten, ngaybatdau, ngayketthuc);
		return isSuccess;
	}
}
