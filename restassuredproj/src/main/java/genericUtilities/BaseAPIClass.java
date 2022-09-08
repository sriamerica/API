package genericUtilities;
/**
 * contains database connection program
 * 
 */
import org.openqa.selenium.WebDriver;


import static io.restassured.RestAssured.*;

public class BaseAPIClass 
{

	public static WebDriver sdriver;
	public WebDriver driver;
	DataBaseUtility dLib=new DataBaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility  wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();

	public void dbConfig()
	{
		dLib.connectToDB(null);
         baseURI="http://localhost";
		port= 8084;

	}

	public void closeDBconfig()
	{
		dLib.closeDB();
	}

}
