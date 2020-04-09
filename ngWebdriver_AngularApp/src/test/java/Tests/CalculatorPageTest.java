package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CalculatorPage;

public class CalculatorPageTest {
	
	public CalculatorPage calc;
	@BeforeClass
	public void Setup() {
		
		calc = new CalculatorPage();
		
	}
	
	@Test(priority = 1)
	public void sumTest() {
		String result = calc.doSum("5", "10");
		Assert.assertEquals(result, "15");
	}
	
	@Test(priority = 2)
	public void subTest() {
		String result = calc.doSub("10", "4");
		Assert.assertEquals(result, "6");
	}
	

}
