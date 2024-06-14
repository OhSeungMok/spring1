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

	    
	    PrintStudentInformationService psi = ctx.getBean("printStudentInformationService", PrintStudentInformationService.class);
	    psi.printStudentInfo(); //학생리스트를 전부 출력
	    

	    
	    ctx.close(); //컨테이너 종료
	}
}
