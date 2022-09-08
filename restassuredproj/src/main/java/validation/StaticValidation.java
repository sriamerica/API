package validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticValidation 
{
	@Test
	public void staticResponseGet()
	{
		//prerequisites
		String expData = "TY_PROJ_015";
		
		baseURI = "http://localhost";
		port = 8084;
		
		//action
		Response resp = when()
				        .get("/projects");
		
	//validation
		String actData = resp.jsonPath().get("[1].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("data verfied ");
		System.out.println(actData);
		
		//resp.then().log().all(); 
	}
}
