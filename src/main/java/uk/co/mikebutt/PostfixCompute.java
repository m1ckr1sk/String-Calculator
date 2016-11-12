package uk.co.mikebutt;

import java.util.Stack;

public class PostfixCompute {
	
	private NumericChecker numericChecker;
	
	public PostfixCompute(NumericChecker numericChecker){
		this.numericChecker = numericChecker;
	}
	
	public String compute(String input) {
		String[] tokens = input.split(" ");
		Stack<String> operationStack = new Stack<String>();

		for(int tokenIndex = 0; tokenIndex < tokens.length; tokenIndex++) {
			String currentToken = tokens[tokenIndex];
			if (numericChecker.isNumber(currentToken)) {
				operationStack.push(currentToken);
			} else if (numericChecker.isOperator(currentToken)) {	
				unwindOperation(operationStack, currentToken);
			} else {
				return "Error";
			}
		}
		return operationStack.pop();
	}

	private void unwindOperation(Stack<String> operationStack, String currentToken) {
		int rightSideValue = Integer.parseInt(operationStack.pop());
		int leftSideValue = Integer.parseInt(operationStack.pop());
		
		int result = calculateResult(currentToken, rightSideValue, leftSideValue);
		
		operationStack.push(Integer.toString(result));
	}

	private int calculateResult(String currentToken, int rightSideValue, int leftSideValue) {
		int result = 0;
		if (currentToken.equals("*")) {
			result = leftSideValue * rightSideValue;
		} else if (currentToken.equals("-")) {
			result = leftSideValue - rightSideValue;
		} else if (currentToken.equals("/")) {
			result = leftSideValue / rightSideValue;
		} else if (currentToken.equals("+")) {
			 result = leftSideValue + rightSideValue;
		}
		return result;
	}
}
