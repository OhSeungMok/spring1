package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentRegisterService {
	private StudentDao studentDao; //db연결을 위해서 인스턴스 선언
	public StudentRegisterService() {}
	//bean 객체에서 만든 studentDao를 받음
	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public void register(Student student) {
		
	}
}
