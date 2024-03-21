package ch04_pjt_01.ems.member.service;

public class PrintStudentInformationService {
	StudentAllSelectService allSelectService;
	public PrintStudentInformationService() { }
	public PrintStudentInformationService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	//아래에 메서드 추가
}

