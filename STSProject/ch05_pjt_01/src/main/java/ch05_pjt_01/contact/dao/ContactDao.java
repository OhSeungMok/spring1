package ch05_pjt_01.contact.dao;

import java.util.HashMap;
import java.util.Map;

import ch05_pjt_01.contact.ContactSet;

public class ContactDao {
	private Map<String, ContactSet> contactDB = new HashMap<String, ContactSet>();

	public void insert(ContactSet contactSet) {
		contactDB.put(contactSet.getName(), contactSet);
	}
//	HashMap의 키값을 정하는 것은 contactSet.getName()이 부분이다 내가 만약 Number로 키값을 정하고 싶다면 contactSet.getNumber()로 하면 됨

	public ContactSet select(String name) {
		return contactDB.get(name);
	}
	public Map<String, ContactSet> getContactDB() {
		return contactDB;
    }
}
