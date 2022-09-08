package petStoreSwagger;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class DeletePet 
{
	@Test
	public void Dlete()
	{
		baseURI="https://petstore.swagger.io/v2";

		given()
		.pathParam("{orderId}", 777);


		given()
		.when().delete("/store/order/{orderId}")
		.then().log().all();
	}
}
