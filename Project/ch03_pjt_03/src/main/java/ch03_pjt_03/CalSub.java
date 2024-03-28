package ch03_pjt_03;

public class CalSub implements ICalculator {
	public CalSub() {
		System.out.println("CalSub 기본생성자 호출됨");
	}
	@Override //인터페이스 구현
	public int doOperation(int firstNum, int secondNum) {
		// TODO Auto-generated method stub
		int res = firstNum - secondNum;
		return res;
	}

}
