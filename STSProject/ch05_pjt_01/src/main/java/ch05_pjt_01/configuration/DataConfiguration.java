package ch05_pjt_01.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch05_pjt_01.contact.dao.ContactDao;
import ch05_pjt_01.contact.service.ContactRegisterService;
import ch05_pjt_01.contact.service.ContactSearchService;
import ch05_pjt_01.contact.utils.InitSampleData;

@Configuration
public class DataConfiguration {
	/* InitSampleData 값 가져오기! */
	@Bean
	public InitSampleData initSampleData() {
		InitSampleData initSampleData = new InitSampleData();
		
//	    <bean id="initSampleData" class="ch05_pjt_01.contact.utils.InitSampleData">
//	      <property name="names">
//	         <array>
//	            <value>류현진</value>
//	            <value>손흥민</value>
//	            <value>김연경</value>
//	         </array>
//	      </property>
//	      <property name="phoneNumbers">
//	         <array>
//	            <value>010-0000-1111</value>
//	            <value>010-0000-2222</value>
//	            <value>010-0000-3333</value>
//	         </array>
//	      </property>
//	   </bean>
		String[] names = {"류현진", "손흥민", "김연경"};
		initSampleData.setNames(names);
		String[] phoneNumber = {"010-0000-1111", "010-0000-2222", "010-0000-3333"};
		initSampleData.setPhoneNumbers(phoneNumber);
		
		return initSampleData;
	}
	/* ContactDao 빈 객체 생성 */
	@Bean
	public ContactDao contactDao() {
		return new ContactDao();
	}
	
	@Bean
	public ContactRegisterService contactRegisterService() {
		return new ContactRegisterService(contactDao());
	}
	
	@Bean
	public ContactSearchService contactSearchService() {
		return new ContactSearchService(contactDao());
	}
}
