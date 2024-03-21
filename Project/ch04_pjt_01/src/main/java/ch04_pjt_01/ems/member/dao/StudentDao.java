package ch04_pjt_01.ems.member.dao;

import java.util.HashMap;
import java.util.Map;

import ch04_pjt_01.ems.member.Student; //패키지가 다르기 때문에 Student도 import해야됨.

public class StudentDao {
	// Hashmap 클래스로 학생들을 관리할거임
	private Map<String, Student> studentDB = new HashMap<String, Student>();  //Student 객체를 value로 저장하겠다.
	//기본 생성자
	public StudentDao() { }
	
	public void insert(Student student) { //입력
	      studentDB.put(student.getsNum(), student);
	}

	public Student select(String sNum) { //검색
	      return studentDB.get(sNum);
	}
    public void update(Student student) { //수정
	      studentDB.put(student.getsNum(), student);
	}

	public void delete(String sNum) { //삭제
	      studentDB.remove(sNum);
	}

	public Map<String, Student> getStudentDB() {
	      return studentDB;
	}
	
}
