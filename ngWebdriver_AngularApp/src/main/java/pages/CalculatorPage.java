package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorPage {

	WebDriver driver;
	static NgWebDriver ngdriver;
	JavascriptExecutor jsDriver;
	
	ByAngularModel first = ByAngular.model("first");
	ByAngularModel operator = ByAngular.model("operator");
	ByAngularModel second = ByAngular.model("second");
	
	ByAngularButtonText go = ByAngular.buttonText("Go!");
	By result = By.className("ng-binding");
	
	
	public CalculatorPage() {

		
		// Automatically download  the chromedriver binary exe file
//		WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.chrome.driver", "E:\\sachinLearnings\\chromedriver_win32_80\\chromedriver.exe");
		
		driver= new ChromeDriver();
		jsDriver = (JavascriptExecutor)driver;
		ngdriver = new NgWebDriver(jsDriver);
		driver.manage().window().maximize();
		driver.get("http://juliemr.github.io/protractor-demo/");
		
//		ngdriver = new NgWebDriver((JavascriptExecutor)driver);
		
		// no need to write the wait(implicit and explicit wait)
		ngdriver.waitForAngularRequestsToFinish();
	
	}
	
	public String doSum(String val1, String val2) {
		
		driver.findElement(first).clear();
		driver.findElement(first).sendKeys(val1);
	
		driver.findElement(second).clear();
		driver.findElement(second).sendKeys(val2);
		
		driver.findElement(operator).sendKeys("+");
		driver.findElement(go).click();
		
		
		// ensure that the page you come to and the page you lead to are fully loaded.
		ngdriver.waitForAngularRequestsToFinish();
		System.out.println(driver.findElement(result).getText());
		
		return driver.findElement(result).getText();
	}
	
	public String doSub(String val1, String val2) {
		
		driver.findElement(first).clear();
		driver.findElement(first).sendKeys(val1);
	
		driver.findElement(second).clear();
		driver.findElement(second).sendKeys(val2);
		
		driver.findElement(operator).sendKeys("-");
		driver.findElement(go).click();
		
		
		// ensure that the page you come to and the page you lead to are fully loaded.
		ngdriver.waitForAngularRequestsToFinish();
		System.out.println(driver.findElement(result).getText());
		
		return driver.findElement(result).getText();
	}
	
	
}
