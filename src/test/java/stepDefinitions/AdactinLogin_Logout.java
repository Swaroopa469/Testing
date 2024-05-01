package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AdactinLogin_Logout {
	static WebDriver driver;	
	
	@Before
	public static void setup() {
		 driver = new ChromeDriver();
	}
	
	@After
	public static void teardown() {
		driver.close();
	}
@Given("Go to the URL")
public void goToTheURL() {	
	driver.get("https://adactinhotelapp.com/");
	WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
	WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	username.sendKeys("ooga2456");
	password.sendKeys("4578@#");
  
}

@When("click on login button")
public void clickOnLoginButton() {
	WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
	login.click();
}

@Then("check for homepage")
public void checkForHomepage() throws InterruptedException {
	WebElement homepage = driver.findElement(By.xpath("(//td[@class='welcome_menu'])[1]"));
	 String text = homepage.getText();  
    System.out.println(text);
	 boolean isDisplayed = homepage.isDisplayed();
       System.out.println("Is Element Displayed? " + isDisplayed);
       Thread.sleep(5000);
}


//Scenario 2
@Given("Homepage verification")
public void homepageVerification() {
	driver.get("https://adactinhotelapp.com/");
	WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
	WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	username.sendKeys("ooga2456");
	password.sendKeys("4578@#");
	WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
	login.click();
	WebElement homepage = driver.findElement(By.xpath("(//td[@class='welcome_menu'])[1]"));
	 String text = homepage.getText();  
       boolean isDisplayed = homepage.isDisplayed();
       System.out.println("Is Element Displayed? " + isDisplayed);
       
}

@When("click on logout button")
public void clickOnLogoutButton() {
	WebElement logout = driver.findElement(By.linkText("Logout"));
	logout.click();
}

@Then("check for loginpage")
public void checkForLoginpage() {
	WebElement loginpage = driver.findElement(By.xpath("//td[@class ='reg_success']"));
	 String text = loginpage.getText();  
	 System.out.println(text);
       boolean isDisplayed = loginpage.isDisplayed();
       System.out.println("Is Element Displayed? " + isDisplayed);
}




}
