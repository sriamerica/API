package petStoreSwagger;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class GetStorePet 
{
	@Test
	public void getPet()
	{
		baseURI="https://petstore.swagger.io/v2";
				
		
		given()
	      .pathParam("orderId", "777")
	      
		//Actions
	    .when()
	      .get("/store/order/{orderId}")
		
		//Validations
	     .then()
	      .log().all();
	}
}
