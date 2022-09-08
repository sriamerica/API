package crudOperationUsingGenericUtilities;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import genericUtilities.EndPointsLibrary;

public class DeleteProj 
{
	@Test
	public void delete()
	{
		baseURI="http://localhost";
		port= 8084;	
		given()
		.pathParam("pid", "TY_PROJ_1003")
		.delete(EndPointsLibrary.deleteProject+"{pid}")
		.then().log().all();
	}
}
