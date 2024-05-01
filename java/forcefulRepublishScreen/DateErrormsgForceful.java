package forcefulRepublishScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class DateErrormsgForceful extends BaseTest {
@Test
	public void errormsg()  {
		log.info("Errormsg verification for Forceful republish screen is initiated");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("Forceful_XPATH");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("Fromforceful_ID");
		clear("Fromforceful_ID");
		click("Toforceful_ID");
		clear("Toforceful_ID");
		type("Toforceful_ID",config.getProperty("To"));
		type("Fromforceful_ID",config.getProperty("Fromerror"));
		try {
		driver.switchTo().alert().accept();	
		System.out.println("Alert displayed");
		excel1.setCellData("summary", "Automation Result", 5, "pass" );
		}
		catch (Exception e) {
			System.out.println("No alert displayed");
			excel1.setCellData("summary", "Automation Result", 5, "Fail" );
		}	
		log.info("Errormsg is successfully verified in Forceful republish screen");
	}
}
