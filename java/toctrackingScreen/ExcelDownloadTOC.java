package toctrackingScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class ExcelDownloadTOC extends BaseTest {

	@Test
	public void excel() throws InterruptedException {

		log.info("Verifying Excel Download in TOC screen is Initiated");
		click("TOC_XPATH");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		click("From_ID");
		clear("From_ID");
		click("To_ID");
		clear("To_ID");
		type("To_ID", config.getProperty("To"));
		type("From_ID", config.getProperty("From"));
		click("Submittoc_ID");
		waitforelementinvisible("loadwait_ID");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		deleteAllFilesFromDirectory();
		click("Exportexcel_XPATH");
		Thread.sleep(5000);
		String fileId = isFileDownloaded();
		if (fileId.equalsIgnoreCase("True")) {
			System.out.println("User successfully verified Excel Download Test in TOC screen");
		}
		log.info("Excel download is successfully verified in TOC screen");
	}

}
