package uk.co.mikebutt;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class StepDefinitions {
	String totalCalculation;
	int runnintTotal;
	
	@Given("^I have a calculation \"([^\"]*)\"$")
	public void i_have_a_calculation(String calculation) throws Throwable {
		totalCalculation = calculation;
	}

	@When("^I calculate the result$")
	public void i_calculate_the_result() throws Throwable {
		NumericChecker numericChecker = new NumericChecker();
		InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter(numericChecker);
		PostfixCompute postFixComputer = new PostfixCompute(numericChecker);
		
		runnintTotal = new StringCalculator(infixToPostfixConverter, postFixComputer).calculate(totalCalculation); 
	}

	@Then("^the result must be (-?\\d+)$")
	public void the_result_must_be(int expectedResult) throws Throwable {
	    assertEquals(expectedResult, runnintTotal);
	}

}