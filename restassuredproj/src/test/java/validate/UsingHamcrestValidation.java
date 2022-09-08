package validate;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.hamcrest.text.MatchesPattern;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class UsingHamcrestValidation 
{
	@Test
	public void dynamicResponse()
	{
		//pre requistes
		String expData = "TY_PROJ_016";

		baseURI = "http://localhost";
		port = 8084;

		//Action
		when()
		.get("/projects")

		.then()
		.assertThat().time(Matchers.lessThan(1000L),TimeUnit.MILLISECONDS)
		.log().all();




	}
}
