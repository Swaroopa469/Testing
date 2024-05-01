package detailsScreen;


import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import basetest.BaseTest;
import utilities.DataUtil;

public class DatacollectionDetails extends BaseTest {

	@Test(dataProviderClass = DataUtil.class,dataProvider = "dp1" )
	public void Reference(String TotalDocs,String Totalpass,String Totalfail,String Passpercent,String Failpercent,String Onecasefail) throws InterruptedException{

		log.info("Data collection in Details Screen Initiated");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		click("Details_XPATH");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		click("FromDetails_ID");
		clear("FromDetails_ID");
		click("ToDetails_ID");
		clear("ToDetails_ID");
		type("ToDetails_ID", config.getProperty("To"));
		type("FromDetails_ID", config.getProperty("From"));
		click("SubmitDetails_ID");
		waitforelementinvisible2("loadwait_ID");
		click("Last_XPATH");
		waitforelementinvisible("loadwait_ID");
		waitforClickabilityofelement("Waitfor_XPATH");
		String total =  gettext("Tablelast_XPATH");
		System.out.println("Total docs : " + total);
		System.out.println("Reference screen Total docs : " + TotalDocs);
		int Td=Integer.parseInt(total);
		int Tr =Integer.parseInt(TotalDocs);
		if (Td==Tr) {
			System.out.println("Values matched No files were removed");
		}
		else {
			System.out.println("Values not matched");
			int removed= Td-Tr;
			System.out.println("Total removed files : " + removed);
		}
		
		
		log.info("Datas collected for Details screen");
		
			
		
	}
}
