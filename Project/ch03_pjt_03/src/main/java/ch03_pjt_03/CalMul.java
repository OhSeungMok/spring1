package ch03_pjt_03;

public class CalMul implements ICalculator {
	public CalMul() {
		System.out.println("CalMul 기본생성자 호출됨");
	}
	@Override //인터페이스 구현
	public int doOperation(int firstNum, int secondNum) {
		return firstNum * secondNum;
	}

}
