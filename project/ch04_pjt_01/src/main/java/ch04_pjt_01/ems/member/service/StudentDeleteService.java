package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

//학생 정보를 삭제할 클래스(서비스)
public class StudentDeleteService {
	
	private StudentDao studentDao; //studentDao를 초기화 한다.
	
	public StudentDeleteService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void delete(String sNum) {
		if(verify(sNum)) {
			studentDao.delete(sNum);
		} else {
			System.out.println("Student information is available.");
		}
	}
	
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}
}