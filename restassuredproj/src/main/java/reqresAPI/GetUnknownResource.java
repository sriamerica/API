package reqresAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GetUnknownResource 
{
	@Test
	public void getapi() 

	{

		baseURI= "https://reqres.in/";
		given()
		.when()
		.get("/api/unknown/23")
		.then().assertThat().statusCode(404)
		.log().all();
	}
}
