package toctrackingScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class DateErrormsgTOC extends BaseTest{
	@Test

	public void errormsg() {
		log.info("Errormsg verification for TOC Tracking screen is initiated");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("TOC_XPATH");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("From_ID");
		clear("From_ID");
		click("To_ID");
		clear("To_ID");
		type("To_ID",config.getProperty("To"));
		type("From_ID",config.getProperty("Fromerror"));
		try {
		driver.switchTo().alert().accept();	
		System.out.println("Alert displayed");
		excel1.setCellData("summary", "Automation Result", 5, "pass" );
		}
		catch (Exception e) {
			System.out.println("No alert displayed");
			excel1.setCellData("summary", "Automation Result", 5, "Fail" );
		}	
		log.info("Errormsg is successfully verified in TOC Tracking screen");
	}
}
