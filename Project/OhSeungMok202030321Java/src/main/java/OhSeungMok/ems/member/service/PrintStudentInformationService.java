package OhSeungMok.ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import OhSeungMok.ems.member.Student;

public class PrintStudentInformationService {
	StudentAllSelectService allSelectService;
	public PrintStudentInformationService() { }
	public PrintStudentInformationService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	//아래에 메서드 추가
	public void printStudentInfo() {
		Map<String, Student> allStudent = allSelectService.allSelect();//allSelectService 호출
	    Set<String> keys = allStudent.keySet(); //키값을 뽑아서 keys에 넣음
	    Iterator<String> iterator = keys.iterator(); //Iterator 반복자 
	    System.out.println("STUDENT LIST START -------------");
	    while (iterator.hasNext()) {
	       String key = iterator.next();
	       Student student = allStudent.get(key);
	       System.out.print("sNum:" + student.getsNum() + "\t");
	       System.out.print("|sId:" + student.getsId() + "\t");
	       System.out.print("|sPw:" + student.getsPw() + "\t");
	       System.out.print("|sName:" + student.getsName() + "\t");
	       System.out.print("|sAge:" + student.getsAge() + "\t");
	       System.out.print("|sGender:" + student.getsGender() + "\t");
	       System.out.println("|sMajor:" + student.getsMajor() + "\t");
	    }
	    System.out.println("END ----------------------------");
	}
}

