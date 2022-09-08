package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.When;

import io.restassured.response.Response;

public class GetAndDelete 
{
	@Test
	public void gac() 
	{

		baseURI = "http://localhost";
		port = 8084;

		Response resp = when().get("/projects/TY_PROJ_3015");
		//capture project ID
		String proID = resp.jsonPath().get("projectId");
		System.out.println(proID);

		//create a get request and pass proID as path parameter
		given()
		.pathParam("pid", proID)
		.when()
		.delete("/projects/{pid}")
		.then().assertThat().statusCode(204).log().all();

	}
}