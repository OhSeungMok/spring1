package ch03_pjt_03;

public class CalAdd implements ICalculator {
	public CalAdd() {
		System.out.println("CalAdd 기본생성자 호출됨");
	} //default
	@Override //인터페이스 구현
	public int doOperation(int firstNum, int secondNum) {
		//int 타입의 반환값을 줘야함
		int sum = firstNum + secondNum;
		return sum;
	}
	
}
