package onecaseDetailsScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class DateErrormsgOnecase extends BaseTest {
	@Test
	public void errormsg() {
		log.info("Errormsg verification for Onecase details screen is initiated");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("Onecase_XPATH");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("FromOnecase_ID");
		clear("FromOnecase_ID");
		click("ToOnecase_ID");
		clear("ToOnecase_ID");
		type("ToOnecase_ID",config.getProperty("To"));
		type("FromOnecase_ID",config.getProperty("Fromerror"));
		try {
		driver.switchTo().alert().accept();	
		System.out.println("Alert displayed");
		excel1.setCellData("summary", "Automation Result", 5, "pass" );
		}
		catch (Exception e) {
			System.out.println("No alert displayed");
			excel1.setCellData("summary", "Automation Result", 5, "Fail" );
		}	
		log.info("Errormsg is successfully verified in Onecase Details screen");
	}

	}


