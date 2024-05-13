package ch06_pjt_01.ems.member.service;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

//학생 만명의 정보를 받을 서비스 생성
public class StudentSelectService {

	private StudentDao studentDao; //studentDao 필드를 통해 정보를 가져온다 

	public StudentSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public Student select(String sNum) {
		if(verify(sNum)) {
			return studentDao.select(sNum);
		} else {
			System.out.println("Student information is available");
		}

		return null;
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;

	}
}
