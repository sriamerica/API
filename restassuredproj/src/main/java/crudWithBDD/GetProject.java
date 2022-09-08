package crudWithBDD;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetProject 
{
	@Test
	public void getProject() 
	{
		get("http://localhost:8084/projects/")
		.then().log().all();

	}
}
