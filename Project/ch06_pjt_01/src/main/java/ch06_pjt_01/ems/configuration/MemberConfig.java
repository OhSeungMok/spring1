package ch06_pjt_01.ems.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import ch06_pjt_01.ems.member.dao.StudentDao;
import ch06_pjt_01.ems.member.service.EMSInformationService;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentAllSelectService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

@Configuration
public class MemberConfig {	
	/* InitSampleData 값 가져오기! */
	@Bean
	public InitSampleData initSampleData() {
		InitSampleData initSampleData = new InitSampleData();
       
	     String[] sNums = {"hbs001", "hbs002", "hbs003", "hbs004", "hbs005"};
	     initSampleData.setsNums(sNums);
	       
	     String[] sIds = {"rabbit", "hippo", "raccoon", "elephant", "lion"};
	     initSampleData.setsIds(sIds);
	       
	     String[] sPws = {"p0001", "p0002", "p0003", "p0004", "p0005"};
	     initSampleData.setsPws(sPws);
	       
	     String[] sNames = {"agatha", "barbara", "chris", "doris", "elva"};
	     initSampleData.setsNames(sNames);
	       
	     int[] sAges = {19, 22, 20, 27, 19};
	     initSampleData.setsAges(sAges);
	       
	     char[] sGenders = {'M', 'W', 'W', 'M', 'M'};
	     initSampleData.setsGenders(sGenders);
	       
	     String[] sMajors = {"English", "Korean", "French", "Philosophy", "History"};
	     initSampleData.setsMajors(sMajors);
	       
	     return initSampleData;
 }

	/* StudentDao 빈 객체 생성 */
	@Bean
	public StudentDao studentDao() {
		return new StudentDao(); 
	}
	
	/* StudentRegisterService 빈 객체 생성 */
	@Bean
    public StudentRegisterService studentRegisterService() {
		return new StudentRegisterService(studentDao());
	}
	
	/* StudentModifyService 빈 객체 생성 */
    @Bean
    public StudentModifyService studentModifyService() {
    	return new StudentModifyService(studentDao());
    }
    
	/* StudentAllSelectService 빈 객체 생성 */
    @Bean
    public StudentAllSelectService studentAllSelectService() {
		return new StudentAllSelectService(studentDao());
	}
    
	/* StudentSelectService 빈 객체 생성 */
    @Bean
    public StudentSelectService studentSelectService() {
    	return new StudentSelectService(studentDao());
	}
    
	/* StudentDeleteService 빈 객체 생성 */
    @Bean
    public StudentDeleteService studentDeleteService() {
    	return new StudentDeleteService(studentDao());
	}
    
	/* PrintStudentInformationService 빈 객체 생성 */
    @Bean
    public PrintStudentInformationService printStudentInformationService() {
		return new PrintStudentInformationService(studentAllSelectService());
	}
    
	/* DBConnectionInfo dev_DBConnectionInfoDev 빈 객체 생성 */
    @Bean
    public DBConnectionInfo dev_DBConnectionInfoDev() {
    	DBConnectionInfo dbConnectionInfo =new DBConnectionInfo();
    	dbConnectionInfo.setUrl("000.000.000.000");
    	dbConnectionInfo.setUserId("admin");
    	dbConnectionInfo.setUserPw("0000");
    	
    	return dbConnectionInfo;
    }
    
	/* DBConnectionInfo real_DBConnectionInfoDev 빈 객체 생성 */
    @Bean
    public DBConnectionInfo real_DBConnectionInfoDev() {
    	DBConnectionInfo dbConnectionInfo =new DBConnectionInfo();
    	dbConnectionInfo.setUrl("111.111.111.111");
    	dbConnectionInfo.setUserId("master");
    	dbConnectionInfo.setUserPw("1111");
    	
    	return dbConnectionInfo;
    }
    
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
     	dbInfos.put("dev", dev_DBConnectionInfoDev());
     	dbInfos.put("real", real_DBConnectionInfoDev());
     	obems.setDbInfos(dbInfos);
     	
     	return obems;
    }

}

