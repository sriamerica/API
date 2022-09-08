package UsingPojoBDD;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingHashMap 
{
	@Test
	public void develop() 
	{
		Random ran = new Random();
		
		baseURI= "http://localhost";
		port=8084;
		int randomno = ran.nextInt(100);
		HashMap hsm = new HashMap();
		hsm.put("createdBy", "long");
		hsm.put("projectName", "swachbharat"+randomno);
		hsm.put("status", "ongoing");
		hsm.put("teamSize", 7);
		given()
		.body(hsm).contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then().assertThat().statusCode(201)
		.log().all();


	}
}
