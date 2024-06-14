package OhSeungMok.ems.member.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import OhSeungMok.ems.member.Student;
import OhSeungMok.ems.member.dao.StudentDao;

public class StudentDeleteService {
	@Resource
	@Qualifier("qualifierDao")
	
	private StudentDao studentDao; //db연결을 위해서 인스턴스 선언
	public StudentDeleteService() {}
	public StudentDeleteService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	//아래에 메서드 추가
	public void delete(String sNum) {
		if(verify(sNum)) {
			studentDao.delete(sNum);
		}	
		else
			System.out.println("삭제하고자 하는 학생이 없음.");
	}
	public Boolean verify(String sNum) { //boolean == Boolean
		Student student = studentDao.select(sNum);
		return student != null ? true : false ;
	}
	
	public void deleteByName(String sName) {
		if(verifyName(sName)) {
			studentDao.delete(sName);
		}	
		else
			System.out.println("삭제하고자 하는 학생이 없음.");
	}
	
	public Boolean verifyName(String sName) { //boolean == Boolean
		Student student = studentDao.selectByName(sName);
		return student != null ? true : false ;
	}
}
