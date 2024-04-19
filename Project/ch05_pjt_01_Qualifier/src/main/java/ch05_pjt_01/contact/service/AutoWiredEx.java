package ch05_pjt_01.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutoWiredEx {
	//FirstBean 타입의 fBean 매개변수와, SecondBean 타입의 sBean 매개변수에 자동 의존 객체를 받아야 함
	//SecondBean은 bean 객체가 하나이므로 자동 주입
	@Autowired
	public AutoWiredEx(@Qualifier("qualifierBean") FirstBean fBean, SecondBean sBean) {
	    System.out.println("firstBean: " + fBean);
	    System.out.println("secondBean: " + sBean);
	}
	    
	//thirdBean은 bean객체가 하나이므로 자동 주입
	@Autowired
	public void autowiredMethod(ThirdBean tBean,@Qualifier("qualifierBean") FourthBean fBean) {
	    System.out.println("thirdBean: " + tBean);
	    System.out.println("fourthBean: " + fBean);
	}
}
