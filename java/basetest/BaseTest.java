package basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.Status;
import extentlisteners.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DbManager;
import utilities.ExcelReader;
import utilities.MonitoringMail;
import utilities.SetExcel;
import utilities.TestConfig;

public class BaseTest {

	/*
	 * WebDriver - done TestNG - done Database - done Mail - done Extent Reports -
	 * done Log4j - done Excel - done Properties - done Screenshots - done Keywords
	 * - done
	 * 
	 */

	public static WebDriver driver;
	public static Properties or = new Properties();
	public static Properties config = new Properties();
	private static FileInputStream fis;
	public static Logger log = Logger.getLogger(BaseTest.class);
	public static ExcelReader excel = new ExcelReader(".//src//test//resources//excel//testdata.xlsx");
	public static ExcelReader excel1 = new ExcelReader(".//Summaryreport//Dashboard_summary_Report.xlsx");
	public static WebDriverWait wait;
	public static WebElement dropdown;

	/* Reusable Keywords */
	public static void click(String locatorKey) {
		try {
			if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(or.getProperty(locatorKey))).click();
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(or.getProperty(locatorKey))).click();
			} else if (locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(or.getProperty(locatorKey))).click();
			}

			log.info("Clicking on an Element : " + locatorKey);
			ExtentListeners.test.log(Status.INFO, "Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {

//			log.error("Error while Clicking on an Element : " + locatorKey + " error message : " + t.getMessage());
//			ExtentListeners.test.log(Status.FAIL,
//					"Error while Clicking on an Element : " + locatorKey + " error message : " + t.getMessage());
//			Assert.fail(t.getMessage());

		}

	}
	
	public static void clear(String id) {
		driver.findElement(By.id(or.getProperty(id))).clear();
		
	}
	
	public static void waitforClickabilityofelement(String xpath) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300)); 
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty(xpath))));
	}
	
	public static String gettext(String xpath) {
		return driver.findElement(By.xpath(or.getProperty(xpath))).getText();
		
	}
	
	public static void waitforClickabilityofelementId(String id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300)); 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(or.getProperty(id))));
		}
	
	
	public static void waitforelementinvisible2(String id) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
	
	}
	
	
	public static void waitforelementinvisible(String id) throws InterruptedException {
	WebElement x = driver.findElement(By.id(or.getProperty(id)));
	while(x.isDisplayed())
	    Thread.sleep(300);
}
	

	
	public static boolean isElementPresent(String locatorKey) {

		try {
			if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(or.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(or.getProperty(locatorKey)));
			}
		} catch (Throwable t) {

			log.info("Element not found : " + locatorKey);
			ExtentListeners.test.log(Status.INFO, "Element not found : " + locatorKey);
			return false;

		}

		log.info("Finding an Element : " + locatorKey);
		ExtentListeners.test.log(Status.INFO, "Finding an Element : " + locatorKey);
		return true;
	}

	public static void type(String locatorKey, String value) {
		try {
			if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(or.getProperty(locatorKey))).sendKeys(value);
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(or.getProperty(locatorKey))).sendKeys(value);
			} else if (locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(or.getProperty(locatorKey))).sendKeys(value);
			}
			log.info("typing in an Element : " + locatorKey + " entered the value as : " + value);
			ExtentListeners.test.log(Status.INFO,
					"typing in an Element : " + locatorKey + " entered the value as : " + value);
		} catch (Throwable t) {

			log.error("Error while typing in an Element : " + locatorKey + " error message : " + t.getMessage());
//			ExtentListeners.test.log(Status.FAIL,
//					"Error while typing in an Element : " + locatorKey + " error message : " + t.getMessage());
//			Assert.fail(t.getMessage());

		}

	}

	public static void select(String locatorKey, String value) {
		try {

			if (locatorKey.endsWith("_XPATH")) {
				dropdown = driver.findElement(By.xpath(or.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				dropdown = driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_ID")) {
				dropdown = driver.findElement(By.id(or.getProperty(locatorKey)));
			}

			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
			log.info("Selecting an Element : " + locatorKey + " selected the value as : " + value);

			ExtentListeners.test.log(Status.INFO,
					"Selecting an Element : " + locatorKey + " selected the value as : " + value);

		} catch (Throwable t) {

			log.error("Error while selecting an Element : " + locatorKey + " error message : " + t.getMessage());
//			ExtentListeners.test.log(Status.FAIL,
//					"Error while selecting an Element : " + locatorKey + " error message : " + t.getMessage());
//			Assert.fail(t.getMessage());

		}

	}

	/* Initialization */
	@BeforeSuite
	public void setUp() {
		// loading the log file
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

		// loading the OR and Config properties
		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.info("Config properties loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			or.load(fis);
			log.info("OR properties loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			String downloadFilepath=config.getProperty("Filedownloadpath");
			String downLoadLoc = System.getProperty("user.dir") +downloadFilepath;
			System.out.println(downLoadLoc);
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory",downLoadLoc);
			chromePrefs.put("safebrowsing.enabled", "true"); 
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--incognito");
			options.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(options);
			log.info("Launching Chrome !!!");
			
		} else if (config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Launching Firefox !!!");
		}
		driver.manage().deleteAllCookies();
		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
	
	}


	  @AfterSuite 	
	  public void tearDown() throws AddressException, MessagingException, IOException, InterruptedException {
	//	  System.out.println("Mail Recipients :" + Arrays.toString(TestConfig.to));
		  driver.quit(); 
//		  MonitoringMail.sendMail(TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.attachmentPath,TestConfig.attachmentPath1,TestConfig.attachmentPath2, TestConfig.attachmentName,TestConfig.attachmentName1,TestConfig.attachmentName2);
	  log.info("Test Execution completed !!!"); 
	  
	  }
	 

	public static void switchToWindow(String Title) {
		log.info("Switching between windows");
		Set<String> AllId = driver.getWindowHandles();
		for (String Id : AllId) {
			String title = driver.switchTo().window(Id).getTitle();
		}
		String ActualTitle = Title;
		for (String Id : AllId) {
			if (driver.switchTo().window(Id).getTitle().equals(ActualTitle)) {
				break;

			}

		}
	}

	public static void scroll(WebElement elements) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", elements);
	}
	
	public static void scrolldown() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public static void jsClick(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void dynamictable(String HeaderName, String VerifyCSName) {
		List<WebElement> TableData = driver.findElements(By.xpath("//table/tbody/tr/td"));
		for (int j = 0; j < TableData.size(); j++) {
			if (TableData.get(j).getText().equals(VerifyCSName) == true) {
				System.out.println("Content set creation is verified successfully:" + TableData.get(j).getText());

			}

		}
	}

	public static void waitforClickabilityofelement(WebElement elements) {
		try {
			log.info("Waiting for an element to be clickable");
			@SuppressWarnings("deprecation")
			WebDriverWait wb = new WebDriverWait(driver, 240);
			wb.until(ExpectedConditions.elementToBeClickable(elements));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void waitforelementvisible(String xpath) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement element = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	
	public static void waitforclickelement(WebElement elements) {
		try {
			log.info("Waiting for an element to be clickable");
			@SuppressWarnings("deprecation")
			WebDriverWait wb = new WebDriverWait(driver, 160);
			wb.until(ExpectedConditions.elementToBeClickable(elements));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void waitforelementvisibleId(String xpath) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement element = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.id(xpath)));
	}
	
	
	
	public void deleteAllFilesFromDirectory() {
		String directory = "Download"; 
		File file = new File(directory);
		String[] currentFiles;
		if (file.isDirectory()) {
			currentFiles = file.list();
			for (int i = 0; i < currentFiles.length; i++) {
				File myFile = new File(file, currentFiles[i]);
				myFile.delete();
			}
		}
		System.out.println("Files Deleted");
	}

	
	public void deleteAllFilesFromreports() {
		String directory = "reports"; 
		File file = new File(directory);
		String[] currentFiles;
		if (file.isDirectory()) {
			currentFiles = file.list();
			for (int i = 0; i < currentFiles.length; i++) {
				File myFile = new File(file, currentFiles[i]);
				myFile.delete();
			}
		}
		System.out.println("Files Deleted");
	}
	public String isFileDownloaded() {
		String flag = "True";
		String directory = "Download";
		File dir = new File(directory);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = "False";
			System.out.println("No files exists");
		} else {
			System.out.println("File exist and passed");
		}
		return flag;
	}

	public static void waitforclicktoelement(WebElement elements) {
		try {
		log.info("Waiting for an element to be clickable");
		@SuppressWarnings("deprecation")
		WebDriverWait wb = new WebDriverWait(driver, 160);
		wb.until(ExpectedConditions.elementToBeClickable(elements));
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	public static void ScrollDown(Object element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 250);");
	}
}
