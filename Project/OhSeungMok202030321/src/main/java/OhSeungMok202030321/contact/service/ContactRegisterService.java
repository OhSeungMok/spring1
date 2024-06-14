package OhSeungMok202030321.contact.service;

import org.springframework.beans.factory.annotation.Autowired;

import OhSeungMok202030321.contact.ContactSet;
import OhSeungMok202030321.contact.dao.ContactDao;

public class ContactRegisterService {
	@Autowired
//	Autowired는 적합한 타입이 일치한 데이터 타입을 이용해서 의존 객체를 자동으로 주입함.
//	데이터 타입을 이용한 의존 객체 자동 주입
//	필드, 생성자, 메서드에 사용 가능

	private ContactDao contactDao = null;
	/* private ContactDao contactDao=null; 과 같음 생성자에서 아무 값도 할당해주지 않으면 null  */
    
    public ContactRegisterService() {
       //System.out.println("ContactRegisterService의 default Constructor");    // 기본생성자     
    }
    
    //@Autowired
    // bean객체에서 ref="contactDao"를 하지 않으면 값이 오지 않음 그럼으로 contactDao는 null이여서 아래 contactDao.select는 실행되지 않음
    public ContactRegisterService(ContactDao contactDao) {
       System.out.println("ContactDao 파라미터 하나 가진 ContactRegisterService 생성자");
       System.out.println("ContactRegisterService에서 contactDao: " + contactDao);    // contactDao 출력
       this.contactDao = contactDao;
    }

    public void register(ContactSet contactSet) {
        String id = contactSet.getId();
        if (verify(id)) {
            contactDao.insert(contactSet);
        } else {
            System.out.println("The name has already registered.");
        }
    }

    public boolean verify(String id) {
        ContactSet contactSet = contactDao.selectByID(id);
        return contactSet == null ? true : false;
    }
    
    //@Autowired
    public void setContactDao(ContactDao contactDao) {
       //System.out.println("ContactRegisterService의 setContactDao 메서드 호출됨.");
       this.contactDao = contactDao;
    }
  
    //@Autowired
    public void setWordDao(ContactDao contactDao) {
       //System.out.println("ContactRegisterService의 setWordDao 메서드 호출됨.");
       this.contactDao = contactDao;
    }
}