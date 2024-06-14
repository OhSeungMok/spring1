package OhSeungMok.ems.member.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import OhSeungMok.ems.member.Student;

import OhSeungMok.ems.member.dao.StudentDao;

public class StudentRegisterService { //student를 등록시키는 서비스
	@Resource
	@Qualifier("qualifierDao")
	
	private StudentDao studentDao; //db연결을 위해서 인스턴스 선언
	public StudentRegisterService() {}
	//bean 객체에서 만든 studentDao를 받음
	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao; //this StudentRegisterService 참조 받음
	}
	//아래에 메서드 추가
	public void register(Student student) {
		if(verify(student.getsNum() ))
			studentDao.insert(student); //studentDao에 있는 insert함수 호출
		else
			System.out.println("똑같은 학번을 가진 학생이 이미 등록됨");
	}
	
	public Boolean verify(String sNum) { //해당 학생의 유무를 검증하는 함수
		Student obstudent = studentDao.select(sNum); //studentDao에 있는 select함수 호출
		//System.out.println(obstudent);
		return obstudent == null ? true : false ;
	}
}
