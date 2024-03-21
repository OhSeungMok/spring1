package ch04_pjt_01.ems;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.service.StudentRegisterService;
import ch04_pjt_01.ems.utils.InitSampleData;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//샘플데이터
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		
		//getter 메서드 호출
		String[] sNums = initSampleData.getsNums();
	    String[] sIds = initSampleData.getsIds();
	    String[] sPws = initSampleData.getsPws();
	    String[] sNames = initSampleData.getsNames();
	    int[] sAges = initSampleData.getsAges();
	    char[] sGenders = initSampleData.getsGenders();
	    String[] sMajors = initSampleData.getsMajors();
	    
	    // 데이터베이스에 샘플 데이터 등록
	    StudentRegisterService registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
	    for (int i = 0; i < sNums.length; i++) {
	         registerService.register(new Student(sNums[i], sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]));
	    }
   }
}
