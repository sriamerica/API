package UsingPojoBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import pojoPorject.PojoClass1;

public class RestAssuredSeriliazation 
{
	public static void main(String[] args) 
	{
		PojoClass1 var = new PojoClass1("dinga","qspiders1","completed",7);	
		given()

		.body(var).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat().contentType(ContentType.JSON)
		.statusCode(201).log().all();

	}

}
