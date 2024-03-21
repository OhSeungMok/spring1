package ch04_pjt_01.ems.member.service;

//ctrl + shift + o 를 누르면 한방에 import를 해줌
import java.util.List;
import java.util.Map;
import ch04_pjt_01.ems.member.DBConnectionInfo;

public class EMSInformationService {
	private String info;
	private String copyRight;
	private String ver;
	private int sYear;
	private int sMonth;
	private int sDay;
    private int eYear;
	private int eMonth;
	private int eDay;
	private List<String> developers;
	private Map<String, String> administrators;
	private Map<String, DBConnectionInfo> dbInfos;
	
	public void printEMSInformation() {
	   System.out.println("EMS INFORMATION START ----------");
	   String devPeriod = sYear + "/" + sMonth + "/" + sDay + " ~ " + eYear + "/" + eMonth + "/" + eDay;
	   System.out.println(info + "(" + devPeriod + ")");
	   System.out.println(copyRight);
	   System.out.println(ver);
	   System.out.println("Developers: " + developers);
	   System.out.println("Administrator: " + administrators);
//	   printDBInfo(); //추후 풀기
	   System.out.println("END ----------------------------");
	   }
}
