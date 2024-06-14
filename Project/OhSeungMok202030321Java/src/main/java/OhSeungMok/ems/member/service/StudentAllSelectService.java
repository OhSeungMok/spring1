package OhSeungMok.ems.member.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import OhSeungMok.ems.member.Student;
import OhSeungMok.ems.member.dao.StudentDao;

public class StudentAllSelectService { //Student 안에 학생의 모든 정보를 return
	@Resource
	@Qualifier("qualifierDao")
	private StudentDao studentDao; //db연결을 위해서 인스턴스 선언
	//기본 생성자
	public StudentAllSelectService() { } 
	
	
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
}
