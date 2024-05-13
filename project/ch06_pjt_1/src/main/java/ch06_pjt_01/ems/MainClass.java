package ch06_pjt_01.ems;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.service.EMSInformationService;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

public class MainClass {

	public static void main(String[] args) {
		
		//applicationContext.xml 파일을 용도별로 나눈후 배열에 담았다.
		//String[] appCtxs = {"classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml"};
		
		//IOC 컨테이너를 생성
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtxImport.xml");

		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		String[] sNums = initSampleData.getsNums();
		String[] sIds = initSampleData.getsIds();
		String[] sPws = initSampleData.getsPws();
		String[] sNames = initSampleData.getsNames();
		int[] sAges = initSampleData.getsAges();
		char[] sGenders = initSampleData.getsGenders();
		String[] sMajors = initSampleData.getsMajors();

		//DB에 샘플 데이터 등록
		StudentRegisterService registerService =
				ctx.getBean("studentRegisterService", StudentRegisterService.class);

		for(int i = 0; i < sNums.length; i++) {
			registerService.register(new Student(sNums[i], sIds[i], sPws[i],
					sNames[i], sAges[i], sGenders[i], sMajors[i]));
		}

		//PrintStudentInformationService를 이용해 모든 학생 정보 출력
		PrintStudentInformationService printStudentInformationService =
				ctx.getBean("printStudentInformationService",
						PrintStudentInformationService.class); //학생 리스트

		//학생 등록
		registerService = ctx.getBean("studentRegisterService",
				StudentRegisterService.class);
		registerService.register(new Student(
				"hbs006", "deer", "p0006", "melissa", 26, 'w', "Music"));
		
		printStudentInformationService.printStudentsInfo(); //학생 리스트
		
		//학생 출력
		StudentSelectService selectService =
				ctx.getBean("studentSelectService", StudentSelectService.class);
		Student selectedstudent = selectService.select("hbs006");
		System.out.println("STUDENT START ----------------------");
		System.out.print("sNum : " + selectedstudent.getsNum() + "\t");
		System.out.print("|sId : " + selectedstudent.getsId() + "\t");
		System.out.print("|sPw : " + selectedstudent.getsPw() + "\t");
		System.out.print("|sName : " + selectedstudent.getsName() + "\t");
		System.out.print("|sAge : " + selectedstudent.getsAge() + "\t");
		System.out.print("|sGender : " + selectedstudent.getsGender() + "\t");
		System.out.print("|sMajor : " + selectedstudent.getsMajor() + "\t");
		System.out.println("END ----------------------");	
		
		//학생 수정
		StudentModifyService modifyService =
				ctx.getBean("studentModifyService", StudentModifyService.class);
		modifyService.modify(new Student("hbs006", "pig", "p0066", "melissa", 27, 'w', "Computer"));
		
		printStudentInformationService.printStudentsInfo();
		
		//학생 삭제
		StudentDeleteService deleteService =
				ctx.getBean("studentDeleteService", StudentDeleteService.class);
		deleteService.delete("hbs005");
		
		printStudentInformationService.printStudentsInfo();
		
		//시스템 정보
		EMSInformationService emsInformationService =
			ctx.getBean("eMSInformationService", EMSInformationService.class);
		emsInformationService.printEMSInformation();
		
		ctx.close();
	}
} 
