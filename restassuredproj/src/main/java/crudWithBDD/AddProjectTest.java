package crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

import java.util.Random;

public class AddProjectTest
{
	@Test

	public void create()
	{
		
		//String projName="Practice";
		int a=2000;
		Random ran = new Random();
		int randomno = ran.nextInt(100);
		
		for (int i = 0; i < 1000; i++) {
			
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "fuller");
		obj.put("projectName", "boeing"+a);
		obj.put("status", "created");
		obj.put("teamSize", 5);
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat().contentType(ContentType.JSON)
		.statusCode(201).log().all();
		a++;
		}	
	}

}
