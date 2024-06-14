package OhSeungMok202030321.contact.dao;

import java.util.HashMap;
import java.util.Map;

import OhSeungMok202030321.contact.ContactSet;

public class ContactDao {
	private Map<String, ContactSet> contactDB = new HashMap<String, ContactSet>();

	public void insert(ContactSet contactSet) {
		contactDB.put(contactSet.getId(), contactSet);
	}
	
	public void insertname(ContactSet contactSet) {
		contactDB.put(contactSet.getName(), contactSet);
	}

	//학번 검색
	public ContactSet selectByID(String Id) {
		return contactDB.get(Id);
	}
	
	//이름 검색
	public ContactSet seletByName(String Name) {
		return contactDB.get(Name);
	}
	
	public Map<String, ContactSet> getContactDB() {
		return contactDB;
    }
}
