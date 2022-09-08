package crudOperationUsingGenericUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import genericUtilities.EndPointsLibrary;
import genericUtilities.IConstants;
import genericUtilities.JavaUtility;
import genericUtilities.ProjectLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
public class EndToEndTesting 
{
	@Test
	public void eee() throws Throwable
	{
		JavaUtility jjlib = new JavaUtility();
		ProjectLibrary poj = new ProjectLibrary("MOF", "Indian Budget"+jjlib.getRandomNumber(), "created", 7);

		baseURI="http://localhost";
		port= 8084;
	
		given()
		.auth().basic(IConstants.appUserName, IConstants.appPassword)
		.body(poj)
		.contentType(ContentType.JSON)
		.when()
		.post(EndPointsLibrary.createProject);
		
		//Verify in the DataBase
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
				java.sql.Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("select * from project");
				boolean flag=false;
				while (result.next()) {
					System.out.println(result.getString(1));
					if ((result.getString(1)).contains("TY_PROJ_3203")) {

						flag=true;
						break;
					}
				}
				if (flag==true) {
					System.out.println("Project is not Deleted From Database!");
				}else {
					System.out.println("Project is Deleted From Database !");
				}
				connection.close();
		
		
		
		given()
		.pathParam("pid", "TY_PROJ_3203")

		.get(EndPointsLibrary.getSingleProject+"{pid}")
		.then().log().all();
		
		// launch rmg yantra browser using selenium scripts
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> projectIds = driver.findElements(By.xpath("//tr//td[1]"));
		boolean flag2=false;
		for (WebElement id : projectIds) 
		{

			String proId = id.getText();
			
			if (proId.equalsIgnoreCase("TY_PROJ_3203")) 
			{
				flag2=true;
			}
		}
		if (flag2==true) 
		{
			System.out.println("Project is not Deleted From Database!");
		}
		else {
			System.out.println("Project is Deleted From Database!");

		}
		
		
		
		given()
		.pathParam("pid", "TY_PROJ_3203")
		.delete(EndPointsLibrary.deleteProject+"{pid}")
		.then().log().all();
	}
}
