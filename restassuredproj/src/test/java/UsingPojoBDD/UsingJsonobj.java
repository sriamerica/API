package UsingPojoBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingJsonobj 
{
	@Test
	public void create() 
	{
		Random ran = new Random();
		int randomno = ran.nextInt(100);
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "testyantraemp");
		obj.put("projectName", "tyss"+randomno);
		obj.put("status", "playing");
		obj.put("teamSize", 11);
		given()
		.body(obj).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat().statusCode(201)
		.log().all();

	}	
}



