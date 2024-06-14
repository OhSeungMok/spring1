package ch06_pjt_01.ems.member.service;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentModifyService {
	private StudentDao studentDao; //db연결을 위해서 인스턴스 선언
	public StudentModifyService() {}
	public StudentModifyService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	//아래에 메서드 추가
	public Boolean verify(String sNum) { //boolean == Boolean
		Student student = studentDao.select(sNum);
		return student != null ? true : false ;
	}
}
