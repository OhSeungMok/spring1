package ch06_pjt_01.ems;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch06_pjt_01.ems.configuration.MemberConfig;
import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.service.EMSInformationService;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml"); //자바 빈 객체를 갖고오겠다!
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml"); //자바 빈 객체를 갖고오겠다!
//		String appCtxs[] = {"classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml"};
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(appCtxs);GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtxImport.xml"); //자바 빈 객체를 갖고오겠다!
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtxImport.xml"); //자바 빈 객체를 갖고오겠다!
		
		//MemberConfig라는 자바 파일에서 만든 자바 빈객체를 가져와 사용할 거임 
		//AnnotationConfigApplicationContext ctx =new AnnotationConfigApplicationContext(MemberConfig.class); 

		
		
		//샘플데이터
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);		
		
		//getter 메서드 호출
		String[] sNums = initSampleData.getsNums(); //getsNums 호출 
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
	    
	    PrintStudentInformationService psi = ctx.getBean("printStudentInformationService", PrintStudentInformationService.class);
	    psi.printStudentInfo(); //학생리스트를 전부 출력
	    
	    //학생 등록
	    registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
	    registerService.register(new Student("hbs006", "dear", "p0006", "melissa", 26, 'W', "Music")); //insert함수 호출
	    psi.printStudentInfo(); //6번째 학생이 등록이 됐는지 확인
	    
	    //학생 검색
	    psi.printStudentInfo();
	    
	    //특정 학번에 해당하는 학생 한명만 검색하고 출력
	    StudentSelectService studentSelectService = ctx.getBean("studentSelectService", StudentSelectService.class);
	    Student selectedstudent = studentSelectService.select("hbs006"); //0006학생 검색 및 출력
	    
	      System.out.println("STUDENT START ------------------");
	      System.out.print("sNum:" + selectedstudent.getsNum() + "\t");
	      System.out.print("|sId:" + selectedstudent.getsId() + "\t");
	      System.out.print("|sPw:" + selectedstudent.getsPw() + "\t");
	      System.out.print("|sName:" + selectedstudent.getsName() + "\t");
	      System.out.print("|sAge:" + selectedstudent.getsAge() + "\t");
	      System.out.print("|sGender:" + selectedstudent.getsGender() + "\t");
	      System.out.println("|sMajor:" + selectedstudent.getsMajor());
	      System.out.println("END ----------------------------");
	      
	    //특정 학번에 해당하는 학생 한명만 검색하고 출력
		Student selectedIdstudent = studentSelectService.selectById("rabbit"); //검색 및 출력
		    if(selectedIdstudent != null) {
		      System.out.println("STUDENT START ------------------");
		      System.out.print("sNum:" + selectedIdstudent.getsNum() + "\t");
		      System.out.print("|sId:" + selectedIdstudent.getsId() + "\t");
		      System.out.print("|sPw:" + selectedIdstudent.getsPw() + "\t");
		      System.out.print("|sName:" + selectedIdstudent.getsName() + "\t");
		      System.out.print("|sAge:" + selectedIdstudent.getsAge() + "\t");
		      System.out.print("|sGender:" + selectedIdstudent.getsGender() + "\t");
		      System.out.println("|sMajor:" + selectedIdstudent.getsMajor());
		      System.out.println("END ----------------------------");
		    }
	    
	    //특정 학번에 해당하는 학생의 정보를 수정하고 출력
	    StudentModifyService modifyService = ctx.getBean("studentModifyService", StudentModifyService.class);
	    modifyService.modify(new Student("hbs006", "pig", "p0066", "melissa", 27, 'W', "Computer"));
	    
	    psi.printStudentInfo();
	    
	    //특정 학번에 해당하는 학생을 삭제하고 출력
	    StudentDeleteService deleteService = ctx.getBean("studentDeleteService", StudentDeleteService.class);
	    deleteService.delete("hbs005");
	    
	    psi.printStudentInfo();
	    
	    //EMS시스템 정보 출력
	    EMSInformationService obems = ctx.getBean("eMSInformationService", EMSInformationService.class);
	    obems.printEMSInformation();
	    
	    ctx.close(); //컨테이너 종료
	}
}
