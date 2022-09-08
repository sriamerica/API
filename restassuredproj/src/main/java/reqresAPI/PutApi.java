package reqresAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutApi 
{
	@Test
	public void create() 
	{
		
		baseURI= "https://reqres.in/";

		JSONObject obj = new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job", "zion resident");
		
		given()
		.body(obj).contentType(ContentType.JSON)
		.when()
		.put("/api/users/58")
		.then().assertThat().statusCode(200)
		.log().all();
	}
}