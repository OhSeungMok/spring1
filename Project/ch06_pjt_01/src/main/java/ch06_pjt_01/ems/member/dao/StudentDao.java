package ch06_pjt_01.ems.member.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import ch06_pjt_01.ems.member.Student;

public class StudentDao {
	// Hashmap 클래스로 학생들을 관리할거임
	private Map<String, Student> studentDB = new HashMap<String, Student>();  //Student 객체를 value로 저장하겠다.
	//기본 생성자
	public StudentDao() {
		System.out.println("StudentDao 기본 생성자 호출됨");
	}
	
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
	
	public Student selectById(String sId) { //id검색
		  Set<String> keys = studentDB.keySet();
	      Iterator<String> iterator = keys.iterator();

	      while (iterator.hasNext()) {
	         String key = iterator.next();
	         Student info = studentDB.get(key);
	         if (info.getsId().equals(sId)) {
	        	 return info;
	         }  
	      }
	      
	      return null;
	}	
}
