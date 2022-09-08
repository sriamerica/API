package UsingPojoBDD;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;

import genericUtilities.ExcelUtility;
import io.restassured.http.ContentType;
import pojoPorject.PojoDD;

public class UsingDataProv extends ExcelUtility
{
	ExcelUtility elib = new ExcelUtility();

	@Test(dataProvider = "rmgproject")

	public void automate(String createdBy, String projectName, String status,String teamSize)
	{
		
		PojoDD var = new PojoDD( createdBy, projectName, status, teamSize);
		given()

		.body(var).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat().contentType(ContentType.JSON)
		.statusCode(201).log().all();

	}



	@DataProvider(name="rmgproject")
	public Object [][] rmgproject() throws Throwable
	{
		Random ran = new Random();
		int randomno = ran.nextInt(100);
		Object[][] objArr=new Object[4][4];
		objArr[0][0]=elib.getDataFromExcel("Sheet1", 0, 0);
		objArr[0][1]=elib.getDataFromExcel("Sheet1", 0, 1)+randomno;
		objArr[0][2]=elib.getDataFromExcel("Sheet1", 0, 2);
		objArr[0][3]=(elib.getDataFromExcel("Sheet1", 0, 3));
		
		objArr[1][0]=elib.getDataFromExcel("Sheet1", 1, 0);
		objArr[1][1]=elib.getDataFromExcel("Sheet1", 1, 1)+randomno;
		objArr[1][2]=elib.getDataFromExcel("Sheet1", 1, 2);
		objArr[1][3]=(elib.getDataFromExcel("Sheet1", 1, 3));
		
		
		objArr[2][0]=elib.getDataFromExcel("Sheet1", 2, 0);
		objArr[2][1]=elib.getDataFromExcel("Sheet1", 2, 1)+randomno;
		objArr[2][2]=elib.getDataFromExcel("Sheet1", 2, 2);
		objArr[2][3]=(elib.getDataFromExcel("Sheet1", 2, 3));
		
		objArr[3][0]=elib.getDataFromExcel("Sheet1", 3, 0);
		objArr[3][1]=elib.getDataFromExcel("Sheet1", 3, 1)+randomno;
		objArr[3][2]=elib.getDataFromExcel("Sheet1", 3, 2);
		objArr[3][3]=(elib.getDataFromExcel("Sheet1", 3, 3));
		return objArr;

	}
}
