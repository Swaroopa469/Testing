package failDocsScreen;

import java.time.Duration;

import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import basetest.BaseTest;
import utilities.DataUtil;

public class DatacollectionFaildoc extends BaseTest {
	
	String totaldoc;
	String totpass;
	String totfail;
	String totPp;
	String totFp;
	String Fivexx;
	String twoxxpre;
	String twoxxpost;
	String ooqpost;
	String totdisplay;
	
	@Test(dataProviderClass = DataUtil.class,dataProvider = "dp1" )
	public void Reference(String TotalDocs,String Totalpass,String Totalfail,String Passpercent,String Failpercent,String Onecasefail) throws InterruptedException{
		log.info("Data collection in Faildocs Screen Initiated");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		click("FailedDoc_XPATH");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		click("From_ID");
		clear("From_ID");
		click("To_ID");
		clear("To_ID");
		type("To_ID", config.getProperty("To"));
		type("From_ID", config.getProperty("From"));
		click("Submitfaildoc_ID");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		totaldoc = gettext("TotaldocFD_XPATH");
		totpass = gettext("TotalpasspostFD_XPATH");
		totfail = gettext("TotalfailpostFD_XPATH");
		totPp = gettext("Totalpass%postFD_XPATH");
		totFp = gettext("Totalfail%postFD_XPATH");
		Fivexx = gettext("5XXpostFD_XPATH");
		twoxxpre = gettext("2XXpreFD_XPATH");
		twoxxpost = gettext("2XXpostFD_XPATH");
		ooqpost = gettext("OOQpostFd_XPATH");
		totdisplay = gettext("TotalfaildisplayedpostFD_XPATH");
		int Tf = Integer.parseInt(totfail);
		int Tp =Integer.parseInt(totpass);
		int Td=Integer.parseInt(totdisplay);
		int Tx=Integer.parseInt(twoxxpre);
		int Tfr =Integer.parseInt(Totalfail);
		int Tdr =Integer.parseInt(TotalDocs);
		int Tpr =Integer.parseInt(Totalpass);
		System.out.println("Total Docs : " + totaldoc);
		System.out.println("Total Pass Post Republish : " + totpass);
		System.out.println("Total Fail Post Republish : " + totfail);
		System.out.println("Total Pass % Post Republish : " + totPp);
		System.out.println("Total Fail % Post Republish : " + totFp);
		System.out.println("Total 5XX Failed Post Republish: " + Fivexx);
		System.out.println("Total 2XX Failed Post Republish: " + twoxxpost);
		System.out.println("Total 2XX Failed Pre Republish : " + twoxxpre);
		System.out.println("Total Out Of Queue Post Republish : " + ooqpost);
		System.out.println("Total Fail Post Republish(FailDoc error code Table) : " + totdisplay);
		
		System.out.println("Reference value Fail count : " + Tfr);
		int Assertion = Td+Tx ;
		if (Tf==Assertion && Tfr==Assertion) {
			System.out.println("Fail count of Success Vs Error Rate % and Fail Doc Error Code Matches with Reference value ");
		if (Tp==Tpr) {
			System.out.println("Pass count matches with Reference value");
		}
		
		}	
		
		log.info("Datas collected for Faildocs screen");
		
			
		
	}

}
