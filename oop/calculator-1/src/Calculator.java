import java.io.Serializable;

public class Calculator implements Serializable {
	
	private double operandOne;
	private double operandTwo;
	private double results;
	private String operator;
	
	
	public void performOperation() {
		if(operator == "+") {
			results = operandOne + operandTwo;
		}
		else if(operator == "-") {
			results = operandOne - operandTwo;
		}
	}
	
	
	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getResults() {
		return results;
	}

	public void setResults(double results) {
		this.results = results;
	}
	
	
}
