package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Eaxmplesdemo {

	static WebDriver driver;
	public static void setup() {
		
		driver =new ChromeDriver();
	}
	
@Given("User is in adactin page")
public void userIsInAdactinPage() {
	setup();
	driver.get("https://adactinhotelapp.com/");
}

@When("User enter {string} and {string} and click login button")
public void userEnterAndAndClickLoginButton(String Username, String Password) {
	driver.findElement(By.id("username")).sendKeys(Username);
	driver.findElement(By.id("password")).sendKeys(Password);
	driver.findElement(By.id("login")).click();
}
@Then("Message displayed Login Successfully")
public void messageDisplayedLoginSuccessfully() {
	driver.quit();
}



}
