package com.office.library.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin") //이게 없으면 경로를 못찾음
public class AdminHomeController {
	@RequestMapping(value= {"", "/"}, method=RequestMethod.GET) //  admin 다음에 아무것도 없거나 /만 있어도 home메서드가 호출된다.
	public String home() {
		System.out.println("AdminHomeController의 home함수");
		String nextPage = "admin/home"; //admin파일에 있는 home.jsp로 가라
		return nextPage;
	}
}
