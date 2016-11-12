package uk.co.mikebutt;

class StringCalculator {
	
	private InfixToPostfixConverter infixToPostfixConverter;
	private PostfixCompute postfixCompute;
	
	public StringCalculator( InfixToPostfixConverter infixToPostfixConverter,
			PostfixCompute postfixComputer){
		this.infixToPostfixConverter = infixToPostfixConverter;
		this.postfixCompute = postfixComputer;
	}
	
	public int calculate(String totalCalculation) {
		System.out.println("- Here I go with " + totalCalculation);
		String postfix = infixToPostfixConverter.infixToPostfix(totalCalculation);
		System.out.println("- Converted to postfix: " + postfix);
		String result = postfixCompute.compute(postfix);
		System.out.println("- Hey, I'm all done, result is " + result);
		return Integer.valueOf(result);
	}

}