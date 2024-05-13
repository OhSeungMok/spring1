package ch05_pjt_01.contact;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch05_pjt_01.configuration.DataConfiguration;
import ch05_pjt_01.contact.service.ContactRegisterService;
import ch05_pjt_01.contact.service.ContactSearchService;
import ch05_pjt_01.contact.utils.InitSampleData;
import ch05_pjt_01.configuration.*;

public class MainClassConfig {

	public static void main(String[] args) {
		// appCtx 가져오기
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		//DataConfiguration라는 자바 파일에서 만든 자바 빈객체를 가져와 사용할 거임 
		AnnotationConfigApplicationContext ctx =new AnnotationConfigApplicationContext(DataConfiguration.class); 

		
		
		// 샘플 데이터
		InitSampleData initob = ctx.getBean("initSampleData", InitSampleData.class); 
		String[] names = initob.getNames(); //InitSampleData에 있는 return(name)을 받기 위해
		String[] numbers = initob.getPhoneNumbers(); //InitSampleData에 있는 return(number)을 받기 위해
		for(int i = 0; i<names.length; i++) {
			System.out.println(names[i] + numbers[i]);
		}
		
		//데이터 등록
		ContactRegisterService obregister = ctx.getBean("contactRegisterService", ContactRegisterService.class);
		for(int i = 0; i<names.length; i++) {
			ContactSet cs = new ContactSet(names[i], numbers[i]);
			obregister.register(cs);
		}
		
		//데이터 조회
		ContactSearchService obsearch = ctx.getBean("contactSearchService", ContactSearchService.class);
		ContactSet contactSet = obsearch.searchContact("손흥민");
		System.out.println("name: " + contactSet.getName());
        System.out.println("phone number: " + contactSet.getPhoneNumber());
        System.out.println("------------------------------");
		contactSet = obsearch.searchContact("류현진");
		System.out.println("name: " + contactSet.getName());
        System.out.println("phone number: " + contactSet.getPhoneNumber());
        System.out.println("------------------------------");
		contactSet = obsearch.searchContact("정연경");
		if(contactSet != null) {
			System.out.println("name: " + contactSet.getName());
	        System.out.println("phone number: " + contactSet.getPhoneNumber());
	        System.out.println("------------------------------");
		}
        ctx.close();
	}

}
	