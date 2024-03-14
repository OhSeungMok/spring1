package ch02_pjt_01;

public class MyCalculator {
	public MyCalculator() { }
	
	public void calAdd(int fNum, int sNum) {
		// CalAdd cal = new CalAdd(); ICalculator은 부모 CalAdd는 자식임으로 둘 중 아무거나 해도 상관없음
		ICalculator cal = new CalAdd();
		int value = cal.doOperation(fNum, sNum);
		//doOperation을 호출할 때 ICalculator로 선언했기 때문에 ICalculator에 doOperation을 먼저 확인한다. 하지만 ICalculator는 추상메서드이기 때문에 자식인 CalAdd로 넘어간다.
		System.out.println("result : " + value);
	}
	
	public void calSub(int fNum, int sNum) {
		ICalculator cal = new CalSub();
		int value = cal.doOperation(fNum, sNum);
		//doOperation을 호출할 때 ICalculator로 선언했기 때문에 ICalculator에 doOperation을 먼저 확인한다. 하지만 ICalculator는 추상메서드이기 때문에 자식인 CalAdd로 넘어간다.
		System.out.println("result : " + value);
	}
	
	public void calMul(int fNum, int sNum) {
        ICalculator calculator = new CalMul();          // CalMul 객체 생성
        int value = calculator.doOperation(fNum, sNum); // 곱셈 실행
        System.out.println("result : " + value);
    }
    
    public void calDiv(int fNum, int sNum) {
        ICalculator calculator = new CalDiv();          // CalDiv 객체 생성
        int value = calculator.doOperation(fNum, sNum); // 나눗셈 실행
        System.out.println("result : " + value);
	}
}
