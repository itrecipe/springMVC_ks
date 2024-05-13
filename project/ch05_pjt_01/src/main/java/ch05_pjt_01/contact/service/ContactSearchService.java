package ch05_pjt_01.contact.service;


import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ch05_pjt_01.contact.dao.ContactDao;
import ch05_pjt_01_contact.ContactSet;

//특정 연락처의 정보를 얻을 클래스
public class ContactSearchService {
	
	//필드로 주입할때는 기본생성자를 추가하고, 쓰고자 하는 생성자에 Autowired를 걸어준다.
	
//	@Inject
//	@Named("contactDao1")
//	@Autowired
//	@Qualifier("usedDao")
	private ContactDao contactDao;
	
	/*
	public ContactSearchService() {
		//System.out.println("default constructor");
	}
	*/
	
//	@Inject
//	@Named("contactDao1")
	@Autowired
	public ContactSearchService(ContactDao contactDao) {
		//System.out.println("contactDao : " + contactDao);
		this.contactDao = contactDao;
	}
	
	public ContactSet searchContact(String name) {
		if(verify(name)) {
			return contactDao.select(name);
		} else {
			System.out.println("Contact information is available.");
		}
		return null;
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet != null ? true : false;
	}
	
//	@Inject
//	@Named("contactDao1")
	//@Resource
	//@Autowired
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}