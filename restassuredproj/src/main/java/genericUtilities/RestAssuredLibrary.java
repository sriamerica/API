package genericUtilities;

import io.restassured.response.Response;
/**
 * 
 * @author Srimanth
 *
 */

public class RestAssuredLibrary 
{
	public String getJsonData(Response resp,String path)
	{
		/**
		 * this method will get the json data through json path from response body
		 * @param resp
		 * @param path
		 */
		
		
		String jsonData=resp.jsonPath().get(path);
		resp.jsonPath().get();
		return jsonData;
		

	}

}
