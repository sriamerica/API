package crudOperationUsingGenericUtilities;

import org.testng.annotations.Test;

import genericUtilities.EndPointsLibrary;
import genericUtilities.IConstants;
import genericUtilities.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostUsingGU 
{
	@Test
	public void create() 
	{
		ProjectLibrary poj = new ProjectLibrary("MOI", "Digital India", "created", 99);

		baseURI="http://localhost";
		port= 8084;


		given()
		.auth().basic(IConstants.appUserName, IConstants.appPassword)
		.body(poj)
		.contentType(ContentType.JSON)
		.when()
		.post(EndPointsLibrary.createProject)
		.then()
		.log().all();



	}
}
