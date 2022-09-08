package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2 
{
	@Test
	public void oauthAuthentication() 
	{
		//Create a request to generate access token 
				Response resp = given()
				 .formParam("client_id", "selenium")
				 .formParam("client_secret", "9b2cec99812cdf41828cf8abafc239be")
				 .formParam("grant_type", "client_credentials")
				 .formParam("redirect_uri", "http://example.com")
				 .formParam("code", "authorization_code")
				 
			    .when()
			     .post("http://coop.apps.symfonycasts.com/token");
				System.out.println(resp.asPrettyString());
			    //Capture the access token from the response of the above request
				String token = resp.jsonPath().get("access_token");
				System.out.println(token);
				
				
				//Create another request and use the token to access the APIs
				given()
				 .auth().oauth2(token)
				 .pathParam("USER_ID", 3760)
				 
				.when()
				 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
				 
				.then().log().all();
	}
}
