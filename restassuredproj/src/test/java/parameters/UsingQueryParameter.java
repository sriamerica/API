package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UsingQueryParameter 
{
	@Test
	public void queryParameter()
	{

		baseURI = "https://reqres.in";

		given()
		.queryParam("page", 5)

		.when()
		.get("/api/users")

		.then()
		.log().all();
	}
}