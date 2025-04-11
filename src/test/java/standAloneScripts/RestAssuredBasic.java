package standAloneScripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBasic {
	
	@Test
	public void getResponse() {
		
		RestAssured.baseURI = "https://via.placeholder.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/600/92c952");
		
		System.out.println("Status => " + response.getStatusCode());
		System.out.println("Response => " + response.peek());
	}

}
