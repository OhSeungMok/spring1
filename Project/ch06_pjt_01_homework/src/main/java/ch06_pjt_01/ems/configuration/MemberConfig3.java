package ch06_pjt_01.ems.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import ch06_pjt_01.ems.member.service.EMSInformationService;

@Configuration
public class MemberConfig3 {
	/* @Autowired를 사용해 Config2에 있는 값 가져오기 */
	@Autowired
	DBConnectionInfo dev_DBConnectionInfoDev;
	
	@Autowired
	DBConnectionInfo real_DBConnectionInfoDev;
	
	/* EMSInformationService eMSInformationService 빈 객체 생성 */
    @Bean
    public EMSInformationService eMSInformationService() {
    	EMSInformationService obems = new EMSInformationService();
    	obems.setInfo("Education Management System program was developed in 2022.");
    	obems.setCopyRight("COPYRIGHT(C) 2022 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
    	obems.setVer("The version is 1.0");
    	obems.setsYear(2022);
    	obems.setsMonth(3);
    	obems.setsDay(1);
    	obems.seteYear(2022);
    	obems.seteMonth(4);
    	obems.seteDay(30);
    	
		/* setDeveloers(List<String> developers)라고 EMS클래스에 set이 지정되어있음 */
		/* List<String> developerStrings = new ArrayList<>(); 앞에 <String>을 써서 생략 가능*/
		/* developers라는 List 타입의 객체를 만듬 */
    	List<String> developers = new ArrayList<String>();
    	developers.add("Cheney.");
    	developers.add("Eloy.");
    	developers.add("Jasper.");
    	developers.add("Dillon.");
    	developers.add("Kian.");
    	obems.setDevelopers(developers);
    	
     	  
     	/*setAdministrators(Map<String, String> administrators)라고 EMS클래스에 set이 지정되어있음*/
     	/*adminstratorsMap이라는 HashMap 타입의 객체를 만듬*/
     	Map<String, String> adminstratorsMap = new HashMap<String, String>();
     	adminstratorsMap.put("Cheney", "cheneyob@springPjt.org");
     	adminstratorsMap.put("Jasper", "jasper@springPjt.org");
     	obems.setAdministrators(adminstratorsMap);
    	
     	
		/* setDbInfos(Map<String, DBConnectionInfo> dbInfos)라고 EMS클래스에 set이 지정되어있음 */
     	/* Map<String, DBConnectionInfo> Map의 Key와 Value는 String타입과 객체인 DBConnectionInfo임 */  
     	Map<String, DBConnectionInfo> dbInfos = new HashMap<String, DBConnectionInfo>();
     	dbInfos.put("dev", dev_DBConnectionInfoDev);
     	dbInfos.put("real", real_DBConnectionInfoDev);
     	obems.setDbInfos(dbInfos);
     	
     	return obems;
    }
}
