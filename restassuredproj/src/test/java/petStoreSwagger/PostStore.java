package petStoreSwagger;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostStore 
{
	@Test
	public void create()
	{
		JSONObject obj = new JSONObject();
		obj.put("id", 777);
		obj.put("petId",999);
		obj.put("quantity", 10);
		obj.put("shipDate", "2022-09-06T11:22:37.857Z");
		obj.put("status", "placed");
		obj.put("complete", true);

		baseURI="https://petstore.swagger.io/v2";

		given()
		
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/store/order")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}
