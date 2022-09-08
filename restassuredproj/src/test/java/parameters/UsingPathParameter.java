package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UsingPathParameter 
{
	@Test
	public void getSingleProjectparam()
	{

		//Prerequisites
		
				baseURI ="http://localhost";
				port = 8084;
						
				
				given()
			      .pathParam("pid", "TY_PROJ_016")
			      
				//Actions
			    .when()
			      .get("/projects/{pid}")
				
				//Validations
			     .then()
			      .log().all();
	}
}
