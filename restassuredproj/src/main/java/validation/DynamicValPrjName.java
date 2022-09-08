package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicValPrjName 
{
	@Test
	public void dynamicResponse()
	{
		//pre requistes
		String expData = "automation";
	
		baseURI = "http://localhost";
		port = 8084;
		
		//Action
		Response resp = when()
		                   .get("/projects");
		
		//Validation
		boolean flag = false;
		List<String> pName = resp.jsonPath().get("ProjectName");
		for(String project : pName)
		{
			if(project.equalsIgnoreCase(expData))
			{
				flag = true;
			}
		}
		
		Assert.assertTrue(flag);
		System.out.println("data verfied");
		System.out.println(expData);
		
		//resp.then().log().all();
	}
}
