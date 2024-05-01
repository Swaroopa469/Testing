package forcefulRepublishScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class ExcelDownloadForceful extends BaseTest {

	@Test
public void excel() throws Throwable{
		
		log.info("Verifying Excel Download in Forceful Republish screen is Initiated");
		click("Forceful_XPATH");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("Fromforceful_ID");
		clear("Fromforceful_ID");
		click("Toforceful_ID");
		clear("Toforceful_ID");
		type("Toforceful_ID",config.getProperty("To"));
		type("Fromforceful_ID",config.getProperty("From"));
		click("Submitforceful_ID");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		deleteAllFilesFromDirectory();
		waitforClickabilityofelementId("Excelforceful_ID");
		click("Excelforceful_ID");
		waitforelementinvisible("Excelwait_ID");
		Thread.sleep(6000);
		String fileId= isFileDownloaded();
		if(fileId.equalsIgnoreCase("True")){
			System.out.println("User successfully verified Excel Download Test");
			}		
		log.info("Excel download is successfully verified in Forceful Republish screen");
				}
}
