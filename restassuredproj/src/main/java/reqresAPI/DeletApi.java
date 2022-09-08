package reqresAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class DeletApi

{
	@Test
	public void deletapi() 

	{

		baseURI= "https://reqres.in/";
		given()
		.when()
		.delete("/api/users/2")
		.then().assertThat().statusCode(204)
		.log().all();
	}
}
