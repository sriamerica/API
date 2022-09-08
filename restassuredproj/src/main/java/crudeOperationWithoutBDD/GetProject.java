package crudeOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetProject 
{
	@Test
	public void getProject() 
	{
		//create JSON B0dy
		/*JSONObject obj = new JSONObject();
		obj.put("createdBy", "Srimanth");
		obj.put("projectName", "samsung");
		obj.put("status", "created");
		obj.put("teamSize", 5);*/

		//precondition(body and content type)
		//RequestSpecification reqSpec = RestAssured.given();
		//reqSpec.contentType(ContentType.JSON);
		/*reqSpec.body(obj);*/

		//action
		//Response response = reqSpec.post("http://localhost:8084/addProject");

		//validation
		//ValidatableResponse validate = response.then();
		//validate.assertThat().contentType(ContentType.JSON);
		//validate.assertThat().statusCode(200);
		//validate.log().all();
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_403");
		//resp.statusCode();
		
		resp.then().log().all();
		resp.prettyPrint();

	}
}
