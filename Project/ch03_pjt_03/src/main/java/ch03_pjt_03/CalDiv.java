package ch03_pjt_03;

public class CalDiv implements ICalculator {
	public CalDiv() {
		System.out.println("CalDiv 기본생성자 호출됨");
	}
	@Override //인터페이스 구현
	public int doOperation(int firstNum, int secondNum) {
		return secondNum != 0 ? (firstNum/secondNum) : 0; 
	}

}
