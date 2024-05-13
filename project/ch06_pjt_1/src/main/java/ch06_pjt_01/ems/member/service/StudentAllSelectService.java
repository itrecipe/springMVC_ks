package ch06_pjt_01.ems.member.service;

import java.util.Map;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

//전체 학생 정보를 반환하는 클래스
public class StudentAllSelectService {
	
	private StudentDao studentDao; //초기화
	
	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
}