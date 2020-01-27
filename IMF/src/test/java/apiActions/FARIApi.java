package apiActions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import commonUtils.APIUtil;
import datatableDTOs.APIResponse;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class FARIApi {

	public void doPost(Map<String, String> map) {
		APIUtil.post(map);
	}

	public void verifyResponse() {
		APIUtil.validResponse();
	}

	public void verifyBodyContent(DataTable dataTable) {
		List<APIResponse> expectedAPIResponse = new ArrayList<APIResponse>();
		expectedAPIResponse = dataTable.asList(APIResponse.class);
		String algorithm = "";
		String forecast = "";
		String trans_id = "";
		for (APIResponse apiResponse : expectedAPIResponse) {
			algorithm = apiResponse.getAlgorithm();
			forecast = apiResponse.getForecast();
			trans_id = apiResponse.getTrans_id();
		}
		assertEquals("Algorithm is not as expected", APIUtil.response.extract().path("algorithm").toString(), algorithm);
		assertEquals("forecast value is not as expected", APIUtil.response.extract().path("forecast").toString(), forecast);
		assertEquals("trans id is not as expected", APIUtil.response.extract().path("trans_id").toString(), trans_id);
	}
}
