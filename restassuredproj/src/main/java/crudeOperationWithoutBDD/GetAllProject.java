package crudeOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProject 
{
	@Test
	public void getAllProject() 
	{
		Response resp =RestAssured.get("http://localhost:8084/projects");
		System.out.println(resp.getContentType());
		System.out.println(resp.getHeader(""));
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody());
		System.out.println(resp.getTime());

		resp.then().log().all();
	}
}
