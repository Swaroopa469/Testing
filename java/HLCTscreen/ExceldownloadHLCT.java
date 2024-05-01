package HLCTscreen;

import java.time.Duration;

import org.testng.annotations.Test;
import basetest.BaseTest;

public class ExceldownloadHLCT extends BaseTest {

	@Test
	public void excel() throws InterruptedException {
		log.info("Verifying Excel Download in HLCT screen Initiated");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("From_ID");
		clear("From_ID");
		click("To_ID");
		clear("To_ID");
		type("To_ID", config.getProperty("To"));
		type("From_ID", config.getProperty("From"));
		click("Submit_ID");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		deleteAllFilesFromDirectory();
		waitforClickabilityofelement("Exportexcel_XPATH");
		click("Exportexcel_XPATH");
		Thread.sleep(5000);
		String fileId = isFileDownloaded();
		if (fileId.equalsIgnoreCase("True")) {
			System.out.println("User successfully verified Excel Download Test");
		}
		log.info("Excel download is successfully verified in HLCT screen");
	}
}



































/*
 * String = Pass("exceldld", "Totalpass"); String y = Fail("exceldld",
 * "Totalfail"); String z = Passpercent("exceldld", "Passpercent"); String a =
 * Failpercent("exceldld", "Failpercent"); String b = Onecase("exceldld",
 * "Onecasefailed"); System.out.println(x); System.out.println(y);
 * System.out.println(z); System.out.println(a); System.out.println(b);
 */
//@Test(dataProviderClass = DataUtil.class ,dataProvider = "dp1")
//public void excel(String Totalpass,String Totalfail, String Passpercent, String Failpercent, String Onecasefailed) throws Exception  {
//System.out.println(Totalpass);
//System.out.println(Totalfail);
//System.out.println(Passpercent);
//System.out.println(Failpercent);
//System.out.println(Onecasefailed);
//int t= 8384;
//String x= Integer.toString(t);
//String tp = Totalpass;
//if (tp.equals(x)) {
//	System.out.println("TotalPass is equal");
//}
//else {
//	System.out.println("Failed total pass");
//}
