package ch04_pjt_01.ems.member.service;

import java.util.Map;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentSelectService {
	private StudentDao studentDao; //db연결을 위해서 인스턴스 선언
	
	public StudentSelectService() { }
	
	public StudentSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	//아래에 메서드 추가
	public Student select(String sNum) {
		if (verify(sNum)) {
			return studentDao.select(sNum);
		}
		else {
			System.out.println("검색된 학생이 없음.");
			return null;
		}
	}
	
	public Student selectById (String sId) {
		if (verifyId(sId)) {
			return studentDao.selectById(sId);
		}
		else {
			System.out.println("검색된 학생이 없음.");
			return null;
		}
	}
	
	public Boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false; //6번째 학생이 들어왔을 때 null이 아니여야 함으로 !=
	}
	
	public Boolean verifyId(String sId) {
		Student student = studentDao.selectById(sId);
		return student != null ? true : false;
	}
}
