package ch05_pjt_01.contact.service;

import javax.annotation.Resource;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactRegisterService {
	//@Autowired
	//@Resource
//	Resource는 빈의 이름을 이용해서 의존 객체를 자동으로 주입함
//	빈 객체의 이름을 이용한 의존 객체 자동 주입
//	필드, 메서드에 사용 가능(생성자 사용 불가능)

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
    @Resource
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
