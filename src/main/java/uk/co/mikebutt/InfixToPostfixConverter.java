package uk.co.mikebutt;

import java.util.Stack;

public class InfixToPostfixConverter {

	private NumericChecker numericChecker;
	
	public InfixToPostfixConverter(NumericChecker numericChecker){
		this.numericChecker = numericChecker;
	}
	
	public String infixToPostfix(String infixString) {
		String[] tokens = infixString.split(" ");
		String postfix = "";
		Stack<String> postfixStack = new Stack<String>();
		for (int tokenIndex = 0; tokenIndex < tokens.length; tokenIndex++) {
			String currentToken = tokens[tokenIndex];
			if (numericChecker.isNumber(currentToken)) {
				System.out.println("--- Adding value " + currentToken);
				postfix += currentToken + " ";
			} else {
				boolean pushed = false;
				while(!pushed){
					if (postfixStack.isEmpty()) {
						System.out.println("--- Pushing operand " + currentToken);
						postfixStack.push(currentToken);
						pushed = true;
					} else {
						// Check the precedence
						String stackTop = postfixStack.peek();
						if(isPushStack(currentToken, stackTop)){
							System.out.println("--- Pushing operand " + currentToken);
							postfixStack.push(currentToken);
							pushed = true;
						}else{
							// pop everything of higher precedence until we can push this operand
							System.out.println("--- Adding operand " + postfixStack.peek());
							postfix += postfixStack.pop() + " ";
						}
					}
				}
			}
		}
		while(!postfixStack.isEmpty()){
			System.out.println("--- Adding final operand " + postfixStack.peek());
			postfix += postfixStack.pop() + " ";
		}
		return postfix;
	}
	
	private boolean isPushStack(String operator, String stacktop){
		System.out.println("---- Checking : " + operator + " and stacktop: " + stacktop);
		return precedenceLevel(operator.charAt(0)) >  precedenceLevel(stacktop.charAt(0));
	}
	
	private int precedenceLevel(char op) {
	    switch (op) {
	        case '+':
	        case '-':
	            return 0;
	        case '*':
	        case '/':
	            return 1;
	        case '^':
	            return 2;
	        default:
	            throw new IllegalArgumentException("Operator unknown: " + op);
	    }
	}
	
}
