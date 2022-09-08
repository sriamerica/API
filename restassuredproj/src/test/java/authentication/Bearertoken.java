package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Bearertoken 
{
	@Test
	public void token()
	{
		baseURI="https://api.github.com";
		JSONObject jObj = new JSONObject();
		jObj.put("name", "mahabarath");


		given()
		.auth().oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)
		.when()
		.post("/user/repos")

		.then().log().all();
	}
}
