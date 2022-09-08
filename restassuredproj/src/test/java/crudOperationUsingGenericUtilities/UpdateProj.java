package crudOperationUsingGenericUtilities;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import genericUtilities.EndPointsLibrary;
import genericUtilities.IConstants;
import genericUtilities.ProjectLibrary;
import io.restassured.http.ContentType;

public class UpdateProj 
{
	@Test
	public void update() 
	{
		ProjectLibrary poj = new ProjectLibrary("MOI", "Digital India", "created", 99);

		baseURI="http://localhost";
		port= 8084;


		given()
		
		.auth().basic(IConstants.appUserName, IConstants.appPassword)
		.body(poj)
		.contentType(ContentType.JSON)
		.pathParam("var", "TY_PROJ_1004")
		.when()
		.put(EndPointsLibrary.updateProject+"{var}")
		.then()
		.log().all();



	}
}
