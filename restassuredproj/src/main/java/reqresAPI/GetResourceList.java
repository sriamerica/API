package reqresAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GetResourceList 
{
	@Test
	public void getapi() 

	{

		baseURI= "https://reqres.in/";
		given()
		.when()
		.get("/api/unknown")
		.then().assertThat().statusCode(200)
		.log().all();
	}
}
