package com.company.hello.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	Map<String, MemberVo> memberDB = new HashMap<>();
	
	public void insertMember(MemberVo memberVo) { //서비스에서 전달된 memberVo를 memberDB에 추가하는 메서드
		System.out.println("MemberDao의 insertMember()메서드 호출됨");
		System.out.println("전달된 ID = " + memberVo.getM_id());
		System.out.println("전달된 PW = " + memberVo.getM_pw());
		System.out.println("전달된 EMAIL = " + memberVo.getM_mail());
		System.out.println("전달된 PHONE = " + memberVo.getM_phone());
		System.out.println("전달된 AGE = " + memberVo.getM_age());
		
		memberDB.put(memberVo.getM_id(), memberVo); //새로운 회원 정보 추가
		printAllMember(); //모든 회원 정보 출력
	}
	
	public void printAllMember() {
		System.out.println("[MemberDao]의 printAllMember()");
	      
	    Set<String> keys = memberDB.keySet(); //key 값인 id를 keys에 넣음
	    Iterator<String> iterator = keys.iterator(); //반복자 객체 생성
	                
	    while (iterator.hasNext()) { //다음 원소가 있는지 확인  
	    	String key = iterator.next(); //첫번째 key를 가져옴  
	        MemberVo memberVo = memberDB.get(key);
	             
	        System.out.println("m_id: " + memberVo.getM_id());
	        System.out.println("m_pw: " + memberVo.getM_pw());
	        System.out.println("m_mail: " + memberVo.getM_mail());
	        System.out.println("m_phone: " + memberVo.getM_phone());     
	        System.out.println("m_age: " + memberVo.getM_age());
	    }
	}
	
	public MemberVo selectMember(MemberVo memberVo) { //일치하는 회원 객체를 return해야 함으로 void가 아니라 MemberVo
		System.out.println("MemberDao의 selectMember()메서드 호출");
		System.out.println("전송된 ID = " + memberVo.getM_id());
		System.out.println("전송된 PW = " + memberVo.getM_pw());
		
		MemberVo signedMember = memberDB.get(memberVo.getM_id());
		
		if(signedMember != null && memberVo.getM_pw().equals(signedMember.getM_pw())) {
			return signedMember;
		} else return null;
	}
}