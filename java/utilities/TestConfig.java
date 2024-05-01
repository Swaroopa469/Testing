package utilities;

public class TestConfig {

	public static String server = "smtp.gmail.com";
	public static String from = "mohammed.aashif@lexisnexis.com";
	public static String password = "xxxxxxxx";
	public static String[] to = {"mohammed.aashif@lexisnexis.com",};
	public static String subject = "CSSM Automation Testing Report";
 
//	public static String messageBody ="TestMessage";
	public static String attachmentPath = ".//src//test//resources//excel//CSSM_Summary_Report.xlsx";
	public static String attachmentPath1 = ".//test-output//emailable-report.html";
	public static String attachmentPath2 = ".//test-output//index.html";
	public static String attachmentName = "CSSM_Summary_Report.xlsx";
	public static String attachmentName1 = "TestNG-Report.html";
	public static String attachmentName2 = "Report-NG.html";
	// SQL DATABASE DETAILS
	public static String driver = "net.sourceforge.jtds.jdbc.Driver";
	public static String dbConnectionUrl = "jdbc:jtds:sqlserver://192.168.0.113;DatabaseName=monitor_eval";
	public static String dbUserName = "xxx";
	public static String dbPassword = "xxx";

	// MYSQL DATABASE DETAILS
	public static String mysqldriver = "com.mysql.cj.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/mysql";

}
