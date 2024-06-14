package OhSeungMok.ems.member.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import OhSeungMok.ems.member.Student;

import OhSeungMok.ems.member.dao.StudentDao;

public class StudentModifyService {
	@Resource
	@Qualifier("qualifierDao")
	
	private StudentDao studentDao; //db연결을 위해서 인스턴스 선언
	public StudentModifyService() {}
	public StudentModifyService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	//아래에 메서드 추가
	public void modify(Student student) {
		if(verify(student.getsNum())) {
			studentDao.update(student);
		}
		else
			System.out.println("수정하고자 하는 학생이 없음.");
	}
	public Boolean verify(String sNum) { //boolean == Boolean
		Student student = studentDao.select(sNum);
		return student != null ? true : false ;
	}
}
