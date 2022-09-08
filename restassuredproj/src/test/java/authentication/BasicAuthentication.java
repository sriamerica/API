package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthentication 
{
	@Test
	public void basicAuth()
	{
		//prequesties
		baseURI = "http://localhost";
		port = 8084;


		given()
		.auth().basic("rmgyantra", "rmgy@9999")

		//perform action
		.when()
		.get("/login")
		//validation
		.then()
		.assertThat().statusCode(202).log().all();
	}
}
