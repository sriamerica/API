package crudWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProject 

{
	@Test
	public void deleteProj() 
	{
				for (int i = 1606; i < 2640; i++) {
					String san="TY_PROJ_"+i;
					delete("http://localhost:8084/projects/"+san);
				}
		
		//.then().statusCode(204).log().all();
	}
}
