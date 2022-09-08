package crudOperationUsingGenericUtilities;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import genericUtilities.EndPointsLibrary;

public class GetUsingGU 
{
	

		@Test
		public void getproj() 
		{
			baseURI="http://localhost";
			port= 8084;	
			given()
			
			.get(EndPointsLibrary.getAllProjects)
			.then().log().all();
			
			
		}
}
