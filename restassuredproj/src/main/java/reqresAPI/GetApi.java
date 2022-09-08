package reqresAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetApi 
{

	@Test
	public void getapi() 

	{

		baseURI= "https://reqres.in/";
		given()
		.when()
		.get("/api/users?page=2")
		.then().assertThat().statusCode(200)
		.log().all();
	}
}
