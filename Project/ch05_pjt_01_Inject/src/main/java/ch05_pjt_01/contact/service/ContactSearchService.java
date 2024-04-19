package ch05_pjt_01.contact.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactSearchService {
	@Inject //맴버변수에 자동 객체 주입
	@Named("contactDao3")
	private ContactDao contactDao;    
    
    public ContactSearchService() {
       System.out.println("ContactSearchService 의 default Constructor");    // 기본생성자     
    }

    //@Autowired
    //@Inject //생성자에 자동 객체 주입
    public ContactSearchService(ContactDao contactDao) {
    	System.out.println("ContactDao 파라미터 하나 가진 ContactSearchService 생성자");
    	System.out.println("ContactSearchService에서 contactDao: " + contactDao);    // contactDao 출력
    	this.contactDao = contactDao;
    }

    public ContactSet searchContact(String name) {
        if (verify(name)) {
            return contactDao.select(name);
        } else {
            System.out.println("Contact information is not available.");
        }
        return null;
    }

    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name);
        return contactSet != null ? true : false;
    }

    //@Autowired
    //@Inject //메서드에 자동 객체 주입
    public void setContactDao(ContactDao contactDao) {
       System.out.println("ContactSearchService의 setContactDao 메서드 호출됨.");
       this.contactDao = contactDao;
    }
}
