package OhSeungMok202030321.contact;

import org.springframework.context.support.GenericXmlApplicationContext;

import OhSeungMok202030321.contact.service.ContactRegisterService;
import OhSeungMok202030321.contact.service.ContactSearchService;
import OhSeungMok202030321.contact.utils.InitSampleData;

public class MainClass {

	public static void main(String[] args) {
		// appCtx 가져오기
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
//		// 샘플 데이터
		InitSampleData initob = ctx.getBean("initSampleData", InitSampleData.class);
		String[] ids = initob.getIds();
		String[] names = initob.getNames();
		String[] majors = initob.getMajors();
		
		//데이터 등록
		ContactRegisterService obregister = ctx.getBean("registerService", ContactRegisterService.class);
		for(int i = 0; i<ids.length; i++) {
			ContactSet cs = new ContactSet(ids[i], names[i] ,majors[i]);
			obregister.register(cs);
		}
		
		//데이터 학번 조회
		ContactSearchService obsearch = ctx.getBean("searchService", ContactSearchService.class);
		ContactSet contactSet = obsearch.searchByID("0494013");
		System.out.println(contactSet.getName() + " | " + contactSet.getId() + " | " + contactSet.getMajor());

		contactSet = obsearch.searchByID("1091011");
		System.out.println(contactSet.getName() + " | " + contactSet.getId() + " | " + contactSet.getMajor());

		contactSet = obsearch.searchByID("202030321");
		System.out.println(contactSet.getName() + " | " + contactSet.getId() + " | " + contactSet.getMajor());
		
		//데이터 이름 조회
		obsearch = ctx.getBean("searchService", ContactSearchService.class);
		
	}

}
