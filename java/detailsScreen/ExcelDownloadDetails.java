package detailsScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class ExcelDownloadDetails extends BaseTest{
	
	@Test
	public void excel() throws InterruptedException{
		
			log.info("Verifying Excel Download in Details screen is Initiated");
			click("Details_XPATH");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			click("FromDetails_ID");
			clear("FromDetails_ID");
			click("ToDetails_ID");
			clear("ToDetails_ID");
			type("ToDetails_ID", config.getProperty("To"));
			type("FromDetails_ID", config.getProperty("From"));
			select("HLCT_ID", "UK News");
			click("SubmitDetails_ID");
			waitforelementinvisible("loadwait_ID");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			deleteAllFilesFromDirectory();
			waitforClickabilityofelementId("ExcelDetails_ID");
			click("ExcelDetails_ID");
			waitforelementinvisible("Excelwait_ID");
			Thread.sleep(5000);
			String fileId= isFileDownloaded();
			if(fileId.equalsIgnoreCase("True")){
				System.out.println("User successfully verified Excel Download Test");
				}		
			log.info("Excel download is successfully verified in Details screen");
					}

}
