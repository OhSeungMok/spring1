package ch06_pjt_01.ems.member.service;

import java.util.Map;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentAllSelectService { //Student 안에 학생의 모든 정보를 return
	private StudentDao studentDao; //db연결을 위해서 인스턴스 선언
	//기본 생성자
	public StudentAllSelectService() { } 
	public StudentAllSelectService(StudentDao studentDao) { //똑같은 메서드 정의 methodOverloading(중복) 
		this.studentDao = studentDao; //this는 studentAllSelectService 참조 
	}
	
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
}
