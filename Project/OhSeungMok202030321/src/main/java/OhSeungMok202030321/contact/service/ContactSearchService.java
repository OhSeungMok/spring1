package OhSeungMok202030321.contact.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import OhSeungMok202030321.contact.ContactSet;
import OhSeungMok202030321.contact.dao.ContactDao;


public class ContactSearchService {
	@Resource
	private ContactDao contactDao;    
    
    public ContactSearchService() {
       //System.out.println("ContactSearchService 의 default Constructor");    // 기본생성자     
    }

    public ContactSearchService(ContactDao contactDao) {
    	System.out.println("ContactDao 파라미터 하나 가진 ContactSearchService 생성자");
    	System.out.println("ContactSearchService에서 contactDao: " + contactDao);    // contactDao 출력
    	this.contactDao = contactDao;
    }

    // 학번 검색
    public ContactSet searchByID(String id) {
        if (verify(id)) {
            return contactDao.selectByID(id);
        } else {
            System.out.println("Contact information is not available.");
        }

        return null;
    }

    public boolean verify(String id) {
        ContactSet contactSet = contactDao.selectByID(id);
        return contactSet != null ? true : false;
    }
    
    //이름 검색
//    public ContactSet searchByName(String name) {
//    	if (verifyname(name)) {
//			return contactDao.seletByName(name);
//		} else {
//			System.out.println("Contact information is not available.");
//		}
//		
//	}
//    
//    public boolean verifyname(String name) {
//        ContactSet contactSet = contactDao.seletByName(name);
//        return contactSet != null ? true : false;
//    }


    public void setContactDao(ContactDao contactDao) {
       System.out.println(
             "ContactSearchService의 setContactDao 메서드 호출됨.");
        this.contactDao = contactDao;
    }
}
