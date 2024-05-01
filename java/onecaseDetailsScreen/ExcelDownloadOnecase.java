package onecaseDetailsScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class ExcelDownloadOnecase extends BaseTest{

	@Test
public void excel() throws InterruptedException{
		
		log.info("Verifying Excel Download in Onecase screen is Initiated");
		click("Onecase_XPATH");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("FromOnecase_ID");
		clear("FromOnecase_ID");
		click("ToOnecase_ID");
		clear("ToOnecase_ID");
		type("ToOnecase_ID", config.getProperty("Toonecase"));
		type("FromOnecase_ID", config.getProperty("Fromonecase"));
		click("Submitonecase_ID");
		waitforelementinvisible("loadwait_ID");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		deleteAllFilesFromDirectory();
		waitforClickabilityofelementId("Excelonecase_ID");
		click("Excelonecase_ID");
		waitforelementinvisible("Excelwait_ID");
		Thread.sleep(5000);
		String fileId= isFileDownloaded();
		if(fileId.equalsIgnoreCase("True")){
			System.out.println("User successfully verified Excel Download Test");
			}		
		log.info("Excel download is successfully verified in Onecase screen");
				}
}
