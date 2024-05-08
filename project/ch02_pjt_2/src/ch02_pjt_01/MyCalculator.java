package ch02_pjt_01;

public class MyCalculator {
	
	public void calAdd(int fNum, int sNum, CalAdd calAdd) {
		int value = calAdd.doOperation(fNum, sNum);
		System.out.println("result : " + value);
	}
	
	public void calSub(int fNum, int sNum, CalSub calSub) {
		int value = calSub.doOperation(fNum, sNum);
		System.out.println("result : " + value);
	}
	
	public void calMul(int fNum, int sNum, CalMul calMul) {
		int value = calMul.doOperation(fNum, sNum);
		System.out.println("result : " + value);
	}
	
	public void calDiv(int fNum, int sNum, CalDiv calDiv) {
		int value = calDiv.doOperation(fNum, sNum);
		System.out.println("result : " + value);
	}
	
	public void calculate(int fNum, int sNum, ICalculator calculator) {
		
		int value = calculator.doOperation(fNum, sNum);
		System.out.println("result : " + value);
	}
}
