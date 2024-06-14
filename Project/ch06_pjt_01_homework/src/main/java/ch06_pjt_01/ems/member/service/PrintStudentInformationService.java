package ch06_pjt_01.ems.member.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ch06_pjt_01.ems.member.Student;

public class PrintStudentInformationService {
	StudentAllSelectService allSelectService;
	public PrintStudentInformationService() { }
	public PrintStudentInformationService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	//아래에 메서드 추가
	public void printStudentInfo() {
		List<Student> allStudent = allSelectService.allSelect();//allSelectService 호출

	    System.out.println("STUDENT LIST START -------------");
	    for (int i=0; i<allStudent.size(); i++) {
	       Student student = allStudent.get(i);
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

