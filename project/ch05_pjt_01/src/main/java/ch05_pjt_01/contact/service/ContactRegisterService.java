package ch05_pjt_01.contact.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ch05_pjt_01.contact.dao.ContactDao;
import ch05_pjt_01_contact.ContactSet;

//연락처 등록 클래스
public class ContactRegisterService {

//	@Resource
	//@Autowired
//	@Qualifier("usedDao")
	
	@Inject
	@Named("contactDao1")
	private ContactDao contactDao;
	
	public ContactRegisterService() {
		//System.out.println("default constructor");
	}

	@Inject
	@Named("contactDao1")
	public ContactRegisterService(ContactDao contactDao) {
		System.out.println("contactDao : " + contactDao);
		
		this.contactDao = contactDao;
	}

	public void register(ContactSet contactSet) {
		String name = contactSet.getName();
		if(verify(name)) {
			contactDao.insert(contactSet);
		} else {
			System.out.println("The name has already registered");
		}
	}

	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null ? true : false;
	}

	@Inject
	@Named("contactDao1")
	//@Autowired
	public void setContact(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}