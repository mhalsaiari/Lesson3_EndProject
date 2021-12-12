package Test;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class validateResponse {

	Logger log = LogManager.getLogger(validateResponse.class);
	// GET request 
	@Test
	public void validate_Response(){
		log.info("To check GET response code");
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200);
		
		//log.error("GET request validation failed");
		   
	}
	// POST request
	@Test
	void Create_user() {
		log.info("To send POST request and validate response code");
		JSONObject request = new JSONObject();
	
		request.put("name", "Mohammed");
		request.put("job", "Automation engineer");
		
		given().
			body(request.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);
		//log.error("POST request validation failed");
	}
	
	// PUT request
	@Test
	void update_user() {
		log.info("To send PUT request and validate response code");
		JSONObject request = new JSONObject();
	
		request.put("name", "Mohammed");
		request.put("job", "Automation engineer");
		
		given().
			body(request.toJSONString())
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
			.statusCode(200);
		//log.error("PUT request validation failed");
	}
	//DELETE request
	@Test
	void delete_user() {
		log.info("To send DELETE request and validate response code");
		JSONObject request = new JSONObject();
	
		request.put("name", "Mohammed");
		request.put("job", "Automation engineer");
		
		given().
			body(request.toJSONString())
		.when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204);
		//log.error("DELETE request validation failed");
	}
	
}






