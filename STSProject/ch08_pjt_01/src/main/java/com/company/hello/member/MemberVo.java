package com.company.hello.member;

import java.util.Date;

public class MemberVo {
	private String m_id;
	private String m_pw;
	private String m_mail;
	private String m_phone;
	private String m_date;
	private int m_age;
	
	public String getM_date() {
		return m_date;
	}
	public int getM_age() {
		return m_age;
	}
	public void setM_age(int m_age) {
		this.m_age = m_age;
		System.out.println("setM_age메서드 호출됨");
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
		System.out.println("setM_id메서드 호출됨");
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
		System.out.println("setM_pw메서드 호출됨");
	}
	public String getM_mail() {
		return m_mail;
	}
	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
		System.out.println("setM_mail메서드 호출됨");
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
		System.out.println("setM_phone메서드 호출됨");
	}
	
}
