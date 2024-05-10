package ch05_pjt_01.contact.dao;

import java.util.HashMap;
import java.util.Map;

import ch05_pjt_01_contact.ContactSet;

//DB역할을 HashMap 객체가 하고 있으며, 해당 객체와 연결하여 데이터값을 끌어올 클래스
public class ContactDao {
	
	private Map<String, ContactSet> contactDB = new HashMap<String, ContactSet>();
	
	public void insert(ContactSet contactSet) {
		contactDB.put(contactSet.getName(), contactSet);
	}
	
	public ContactSet select(String name) {
		return contactDB.get(name);
	}
	
	public Map<String, ContactSet> getContactDB() {
		return contactDB;
	}
}
 