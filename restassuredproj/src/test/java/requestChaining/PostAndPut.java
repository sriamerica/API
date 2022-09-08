package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndPut 
{
	@Test
	public void create() 
	{
		Random ran = new Random();
		int randomno = ran.nextInt(100);
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "testyantraemp");
		obj.put("projectName", "Lenoxpad"+randomno);
		obj.put("status", "dancing");
		obj.put("teamSize", 11);
		baseURI = "http://localhost";
		port = 8084;
		Response resp = given()
				.body(obj)
				.contentType(ContentType.JSON)
				.when()
				.post("/addProject");
		//capture the project id
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();

		//Create a get request and pass proID as path parameter
		given()
		.body(obj).contentType(ContentType.JSON)
		.pathParam("pid", proId)
		.when()
		.put("/projects/{pid}")
		.then()
		.assertThat().statusCode(200).log().all();
	}
}