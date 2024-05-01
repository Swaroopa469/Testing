package detailsScreen;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import basetest.BaseTest;

public class DateErrormsgDetails extends BaseTest {
	@Test
	public void errormsg() {
		log.info("Errormsg verification for Details screen is initiated");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("Details_XPATH");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("FromDetails_ID");
		clear("FromDetails_ID");
		click("ToDetails_ID");
		clear("ToDetails_ID");
		type("ToDetails_ID",config.getProperty("To"));
		type("FromDetails_ID",config.getProperty("Fromerror"));
		try {
			System.out.println("Alert displayed");
		driver.switchTo().alert().accept();		
		excel1.setCellData("summary", "Automation Result", 3, "pass" );
		}
		catch (Exception e) {
			System.out.println("No alert displayed");
			excel1.setCellData("summary", "Automation Result", 3, "Fail" );
		}
		
		log.info("Errormsg is successfully verified in Details screen");
	}
}
