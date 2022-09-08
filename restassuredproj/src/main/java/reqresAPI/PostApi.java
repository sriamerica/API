package reqresAPI;

import static io.restassured.RestAssured.*;


import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class PostApi 
{
	@Test
	public void create() 
	{
		Random ran = new Random();
		int randomno = ran.nextInt(100);
		baseURI= "https://reqres.in/";

		JSONObject obj = new JSONObject();
		obj.put("name", "abcc");
		obj.put("job", "clerk");

		given()
		.body(obj).contentType(ContentType.JSON)
		.when()
		.post("/api/users")
		.then().assertThat().statusCode(201)
		.log().all();

	}
}
