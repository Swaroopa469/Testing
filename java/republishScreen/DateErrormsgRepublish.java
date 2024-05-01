package republishScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class DateErrormsgRepublish extends BaseTest{
	@Test
	public void errormsg() {
		log.info("Errormsg verification for Republish screen is initiated");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("Republish_XPATH");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("RepublishFrom_ID");
		clear("RepublishFrom_ID");
		click("RepublishTo_ID");
		clear("RepublishTo_ID");
		type("RepublishTo_ID",config.getProperty("To"));
		type("RepublishFrom_ID",config.getProperty("Fromerror"));
		try {
		driver.switchTo().alert().accept();		
		System.out.println("Alert displayed");
		excel1.setCellData("summary", "Automation Result", 3, "pass" );
		}
		catch (Exception e) {
			System.out.println("No alert displayed");
			excel1.setCellData("summary", "Automation Result", 3, "Fail" );
		}	
		log.info("Errormsg is successfully verified in Republish screen");
	}

}
