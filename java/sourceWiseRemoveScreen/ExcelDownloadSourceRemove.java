package sourceWiseRemoveScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class ExcelDownloadSourceRemove extends BaseTest{
	@Test
public void excel() throws InterruptedException{
		
		log.info("Verifying Excel Download in SourcewiseRemove screen is Initiated");
		click("SourceRemove_XPATH");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		click("Fromsourceld_ID");
		clear("Fromsourceld_ID");
		click("Tosourceld_ID");
		clear("Tosourceld_ID");
		type("Tosourceld_ID", config.getProperty("To"));
		type("Fromsourceld_ID", config.getProperty("From"));
		click("SubmitSL_ID");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		deleteAllFilesFromDirectory();
		click("ExcelSL_XPATH");
		Thread.sleep(5000);
		String fileId= isFileDownloaded();
		if(fileId.equalsIgnoreCase("True")){
			System.out.println("User successfully verified Excel Download Test");
			}		
		log.info("Excel download is successfully verified in SourcewiseRemove screen");
				}
}
