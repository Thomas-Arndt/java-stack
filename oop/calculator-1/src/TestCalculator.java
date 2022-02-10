
public class TestCalculator {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		calculator.setOperandOne(10.5);
		calculator.setOperator("+");
		calculator.setOperandTwo(5.2);
		calculator.performOperation();
		System.out.println(calculator.getResults());
	}

}
