package petStoreSwagger;

import static io.restassured.RestAssured.*;

public class GetAllStore 
{
	public void store()
	{
		baseURI="https://petstore.swagger.io/v2";
		given()
		.when().get("/store/inventory")
		.then().log().all();

	}
}
