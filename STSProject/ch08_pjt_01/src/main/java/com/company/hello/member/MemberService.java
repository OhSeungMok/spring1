package com.company.hello.member;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*@Service 애너테이션을 명시하면 servlet-context.xml 파일에는 더 이상 빈객체 생성과 관련된 코드를 추가하지 않아도 됨 */
@Service
//@Component
//@Repository
public class MemberService {
	
	@Autowired //MemberDao의 객체가 자동 주입됨
	MemberDao memberDao; //MemberDao 타입의 memberDao 선언 객체생성X
	
	public int signUpConfirm(MemberVo memberVo) {
	    System.out.println("MemberService의 signUpConfirm메서드 호출됨");
	    System.out.println("inserted id=" + memberVo.getM_id());
	    System.out.println("inserted 암호=" + memberVo.getM_pw());
	    System.out.println("inserted 메일주소=" + memberVo.getM_mail());
	    System.out.println("inserted 전화번호=" + memberVo.getM_phone());
	    System.out.println("inserted 나이=" + memberVo.getM_age());

	    Date date = new Date();
	    Long datea = date.getTime();

	    Instant instant = Instant.ofEpochMilli(datea);
	    LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDate = dateTime.format(formatter);
	    
	    System.out.println("inserted 가입날짜=" + formattedDate);

	    memberDao.insertMember(memberVo); // memberVo를 매개변수로 전달

	    return 0;
	}


	
	public MemberVo signInConfirm(MemberVo memberVo) {
		System.out.println("MemberService의 signInConfirm()메서드 호출됨");
		System.out.println("전송된 ID = " + memberVo.getM_id());
		System.out.println("전송된 PW = " + memberVo.getM_pw());
		
		MemberVo loginedMember = memberDao.selectMember(memberVo); //memberVo를 매개변수로 전달
		
		return loginedMember;
	}
	
}
