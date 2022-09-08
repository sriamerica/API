package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class PreemptiveMethod 
{
	@Test
	public void preempAuth()
	{
		//prequesties
		baseURI = "http://localhost";
		port = 8084;


		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")     

		//perform action
		.when()
		.get("/login")
		//validation
		.then()
		.assertThat().statusCode(202).log().all();
	}
}
