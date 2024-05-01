package HLCTscreen;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import basetest.BaseTest;

public class DatacollectionHLCT extends BaseTest {
	public static String Td;
	public static String Tp;
	public static String Tf;
	public static String Pp;
	public static String Fp;
	public static String Oc;

	@Test
	public void hlctdatas() throws InterruptedException, IOException {
		log.info("Collection of Hlct & Date wise screen Datas initiated");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		click("From_ID");
		clear("From_ID");
		click("To_ID");
		clear("To_ID");
		type("To_ID", config.getProperty("To"));
		type("From_ID", config.getProperty("From"));
		click("Submit_ID");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Td = gettext("TDocs_XPATH");
		Tp = gettext("Tpass_XPATH");
		Tf = gettext("Tfail_XPATH");
		Pp = gettext("Passpercent_XPATH");
		Fp = gettext("Failpercent_XPATH");
		Oc = gettext("Onecase_XPATH");
		String Passper[] = Pp.split("%");
		String Failper[] = Fp.split("%");
		excel.setCellData("registerUser", "TotalDocs", 2, Td);
		excel.setCellData("registerUser", "Totalpass", 2, Tp);
		excel.setCellData("registerUser", "Totalfail", 2, Tf);
		excel.setCellData("registerUser", "Passpercent", 2, Passper[0]);
		excel.setCellData("registerUser", "Failpercent", 2, Failper[0]);
		excel.setCellData("registerUser", "Onecasefail", 2, Oc);
		System.out.println("Total Docs : " + Td);
		System.out.println("Total passed : " + Tp);
		System.out.println("Total Failed : " + Tf);
		System.out.println("Pass % : " + Pp);
		System.out.println("Fail %: " + Fp);
		System.out.println("One case Failed : " + Oc);
		log.info("Datas collected for HLCT screen");
	}

}
