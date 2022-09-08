package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility  wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	
	
	/**
	 * connecting to database
	 */
	@BeforeSuite
	public void dbConfig()
	{
		dLib.connectToDB(null);
	}
	
	//@Parameters("BROWSER")
		@BeforeClass
		public void launchTheBrowser()
		{  
			String BROWSER = null;
			try {
				BROWSER = fLib.getPropertyKeyValue("browser");
			} catch (Throwable e) {
				e.printStackTrace();
			}
			System.out.println(BROWSER);
			String URL = null;
			try {
				URL = fLib.getPropertyKeyValue("url");
			} catch (Throwable e) {
				e.printStackTrace();
			}

			if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}else if(BROWSER.equalsIgnoreCase("chrome"))
			{
				//	ChromeOptions chromeOptions=new ChromeOptions();
				//	chromeOptions.setBinary("C:\\Users\\SanjayBabu\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
				//	driver=new ChromeDriver(chromeOptions);
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else {
				driver=new ChromeDriver();
			}

			System.out.println("Browser successfully launched");
			//implicitly wait
			sdriver=driver;
			wLib.waitTillPageLoad(driver);
			//enter the URL of the Application
			sdriver.get(URL);
			//maximize the screen
			driver.manage().window().maximize();
		}
		/**
		 * login to application
		 */
		
		/**
		 * logout from application
		 */
		
		/**
		 * close the browser
		 */
		@AfterClass
		public void closeTheBrowser()
		{
			driver.quit();
			System.out.println("Browser successfully closed");
		}
		/**
		 * close database configuration
		 */
		@AfterSuite
		public void closeDBconfig()
		{
			dLib.closeDB();
		}
	
}
