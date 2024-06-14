package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMemberService {
	
	@Autowired
	AdminMemberDao adminMemberDao; //adminMemberDao 변수 선언, 객체 생성이 아님 but @Autowired 애너테이션으로 자동주입하면 됨
	
	final static public int ADMIN_ACCOUNT_ALREADY_EXIST = 0; //같은 회원가입 관리자일 경우
	final static public int ADMIN_ACCOUNT_CREATE_SUCCESS = 1; //회원가입이 될 경우
	final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1; //회원가입이 실패할 경우
	   
	public int createAccountConfirm(AdminMemberVo adminMemberVo) { //객체 AdminMemberVo타입의 adminMemberVo를 가져옴
		System.out.println("AdminMemeberService의 createAccountConfirm()메서드");
		/* 중복체크 */
		boolean isMember = adminMemberDao.isAdminMember(adminMemberVo.getA_m_id());
		if (!isMember) {
			int result = adminMemberDao.insertAdminAccount(adminMemberVo);
			return result > 0 ? ADMIN_ACCOUNT_CREATE_SUCCESS : ADMIN_ACCOUNT_CREATE_FAIL;
		} else { //isMember가 이미 존재할 경우
			return ADMIN_ACCOUNT_ALREADY_EXIST;
		}
	}
}
