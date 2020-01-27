package commonUtils;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class APIUtil {

	public static ValidatableResponse response;

	public static void post(Map<String, String> map) {
		response = given().contentType(ContentType.JSON).body(map).when().post().then().log().all();
	}

	public static ValidatableResponse validResponse() {
		return response.statusCode(200);
	}
}
