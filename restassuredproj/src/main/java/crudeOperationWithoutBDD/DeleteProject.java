package crudeOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject 
{
	@Test
	public void deleteProject() 
	{
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_404");	
		response.then().log().all();

	}
}
