package UsingPojoBDD;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Random;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingJsonFile 
{
	@Test

	public void devop() 
	{


		File file = new File("./src/test/resources/resetassred.json");
		baseURI= "http://localhost";
		port=8084;
		given()
		.body(file).contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then().assertThat().statusCode(201)
		.log().all();

	}
}
