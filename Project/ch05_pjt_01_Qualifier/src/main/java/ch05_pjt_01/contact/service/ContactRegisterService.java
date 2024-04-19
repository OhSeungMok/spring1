package ch05_pjt_01.contact.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactRegisterService {
	//@Autowired
	@Resource
	@Qualifier("qualifierDao") //qualifier은 예선 통과자 라고 함. 즉 contactDao2라는 의존 객체에 qualifier를 줘서 의존 대상 객체로 지정
	//만약 xml파일에 bean객체에 이름이 같은 contactDao가 있으면 qualifier을 주지 않아도 됌
	private ContactDao contactDao = null;
	/* private ContactDao contactDao=null; 과 같음 생성자에서 아무 값도 할당해주지 않으면 null  */
    
    public ContactRegisterService() {
       System.out.println("ContactRegisterService의 default Constructor");    // 기본생성자     
    }
    
    //@Autowired
    // bean객체에서 ref="contactDao"를 하지 않으면 값이 오지 않음 그럼으로 contactDao는 null이여서 아래 contactDao.select는 실행되지 않음
    public ContactRegisterService(ContactDao contactDao) {
       System.out.println("ContactDao 파라미터 하나 가진 ContactRegisterService 생성자");
       System.out.println("ContactRegisterService에서 contactDao: " + contactDao);    // contactDao 출력
       this.contactDao = contactDao;
    }

    public void register(ContactSet contactSet) {
        String name = contactSet.getName();
        if (verify(name)) {
            contactDao.insert(contactSet);
        } else {
            System.out.println("The name has already registered.");
        }
    }

    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name);
        return contactSet == null ? true : false;
    }
    
    //@Autowired
    //@Resource
    //@Qualifier("qualifierDao")
    public void setContactDao(ContactDao contactDao) {
       System.out.println("ContactRegisterService의 setContactDao 메서드 호출됨.");
       this.contactDao = contactDao;
    }
  
    //@Autowired
    public void setWordDao(ContactDao contactDao) {
       System.out.println("ContactRegisterService의 setWordDao 메서드 호출됨.");
       this.contactDao = contactDao;
    }
}
