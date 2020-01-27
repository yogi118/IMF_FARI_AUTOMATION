package stepDefinitions;

import java.util.LinkedHashMap;
import java.util.Map;

import apiActions.FARIApi;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;

public class FARIApiSteps {
	
	private FARIApi fariApi;
	
	public FARIApiSteps() {
		fariApi = new FARIApi();
	}

	@Given("I have {string} and {string} for fari model")
	public void i_have_and_for_fari_model(String baseURL, String basePath) {
	    RestAssured.baseURI = baseURL;
	    RestAssured.basePath = basePath;
	    RestAssured.useRelaxedHTTPSValidation();
	}
	
	@When("I want to generate forecast value for {string} to {string} for {string} request")
	public void i_want_to_generate_forecast_value_for_to_for_request(String fromDate, String toDate, String transId) {
		Map<String, String> bodyParmeters = new LinkedHashMap<String, String>();
		bodyParmeters.put("trans_id", transId);
		bodyParmeters.put("from_date", fromDate);
		bodyParmeters.put("to_date", toDate);
		fariApi.doPost(bodyParmeters);
	}
	
	@Then("I should get valid response")
	public void i_should_get_valid_response() {
		fariApi.validResponse();
	}
	
	@Then("Response body should contain expected values")
	public void response_body_should_contain_expected_values(DataTable dataTable) {
		fariApi.verifyBodyContent(dataTable);
	}
}
