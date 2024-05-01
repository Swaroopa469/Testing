package failDocsScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class ExcelDownloadFaildoc extends BaseTest {

	@Test
	public void excel() throws InterruptedException{
		
		log.info("Verifying Excel Download in Faileddoc screen is Initiated");
		click("FailedDoc_XPATH");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("From_ID");
		clear("From_ID");
		click("To_ID");
		clear("To_ID");
		type("To_ID", config.getProperty("To"));
		type("From_ID", config.getProperty("From"));
		click("Submitfaildoc_ID");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		deleteAllFilesFromDirectory();
		waitforClickabilityofelementId("Excelfaildoc_ID");
		click("Excelfaildoc_ID");
		waitforelementinvisible("Excelwait_ID");
		Thread.sleep(5000);
		String fileId= isFileDownloaded();
		if(fileId.equalsIgnoreCase("True")){
			System.out.println("User successfully verified Excel Download Test");
			}		
		log.info("Excel download is successfully verified in Faileddoc screen");
				}

}
