package uk.co.mikebutt;

public class NumericChecker {

	public NumericChecker(){
		
	}

	public boolean isNumber(String stringTester) {
		return stringTester.matches("[-+]?\\d*\\.?\\d+");
	}
	
	public boolean isOperator(String stringTester) {
		return stringTester.matches("[*-/+]");
	}
}
