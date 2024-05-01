package HLCTscreen;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import basetest.BaseTest;

public class DateErrormsgHLCT extends BaseTest {
	@Test

	public void errormsg()  {
		log.info("Errormsg verification for Hlct & Date wise screen is initiated");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("HLCT_XPATH");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("From_ID");
		clear("From_ID");
		click("To_ID");
		clear("To_ID");
		type("To_ID",config.getProperty("To"));
		type("From_ID",config.getProperty("Fromerror"));
		try {
		driver.switchTo().alert().accept();		
		excel1.setCellData("summary", "Automation Result", 3, "pass" );
		}
		catch (Exception e) {
			System.out.println("No alert displayed");
			excel1.setCellData("summary", "Automation Result", 3, "Fail" );
		}	
		log.info("Errormsg is successfully verified in Hlct & Date wise screen");
	}

}
