package crudWithBDD;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProject 
{
	@Test

	public void create()
	{
		Random ran = new Random();
		int randomno = ran.nextInt(100);
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "MBS");
		obj.put("projectName", "dubai"+randomno);
		obj.put("status", "created");
		obj.put("teamSize", 5);
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_0010")
		.then().assertThat().contentType(ContentType.JSON)
		.statusCode(200).log().all();
		
	}

}
