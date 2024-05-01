package republishScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class ExcelDownloadRepublish extends BaseTest {
	
	@Test
public void excel() throws InterruptedException{
		
		log.info("Verifying Excel Download in Republish screen is Initiated");
		click("Republish_XPATH");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("RepublishFrom_ID");
		clear("RepublishFrom_ID");
		click("RepublishTo_ID");
		clear("RepublishTo_ID");
		type("RepublishTo_ID", config.getProperty("To"));
		type("RepublishFrom_ID", config.getProperty("From"));
		click("Submitrepublish_ID");
		waitforelementinvisible("loadwait_ID");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		deleteAllFilesFromDirectory();
		click("Excelrepublish_ID");
		waitforelementinvisible("Excelwait_ID");
		Thread.sleep(5000);
		String fileId= isFileDownloaded();
		if(fileId.equalsIgnoreCase("True")){
			System.out.println("User successfully verified Excel Download Test");
			}		
		log.info("Excel download is successfully verified in Republish screen");
				}

}
