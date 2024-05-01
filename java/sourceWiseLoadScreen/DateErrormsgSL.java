package sourceWiseLoadScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class DateErrormsgSL extends BaseTest {
	@Test
	public void errormsg() {
		log.info("Errormsg verification for Sourcewise Load screen is initiated");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		click("SourceLoad_XPATH");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		click("Fromsourceld_ID");
		clear("Fromsourceld_ID");
		click("Tosourceld_ID");
		clear("Tosourceld_ID");
		type("Tosourceld_ID",config.getProperty("To"));
		type("Fromsourceld_ID",config.getProperty("Fromerror"));
		try {
		driver.switchTo().alert().accept();		
		System.out.println("Alert displayed");
		excel1.setCellData("summary", "Automation Result", 3, "pass" );
		}
		catch (Exception e) {
			System.out.println("No alert displayed");
			excel1.setCellData("summary", "Automation Result", 3, "Fail" );
		}	
		log.info("Errormsg is successfully verified in Sourcewise Load screen");
	}
		
	}


