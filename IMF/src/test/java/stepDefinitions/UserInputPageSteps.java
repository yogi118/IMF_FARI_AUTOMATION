package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import pageActions.UserInputPage;
import runner.SharedDriver;

public class UserInputPageSteps {
	private UserInputPage userInputPage;

	public UserInputPageSteps(SharedDriver webDriver) {
		userInputPage = new UserInputPage(webDriver);
	}

	@Then("All the user input field should be displayed")
	public void all_the_user_input_field_should_be_displayed() {
		List<String> notDisplayedInputFieldsOnFirstPage = userInputPage.verifyFirstLevelInputPresent();
		assertEquals("List of Input fields not diplayed: " + notDisplayedInputFieldsOnFirstPage, 0,
				notDisplayedInputFieldsOnFirstPage.size());
		userInputPage.navigateToInputPage(2);
		List<String> notDisplayedInputFieldsOnSecpondPage = userInputPage.verifySecondLevelInputPresent();
		assertEquals("List of Input fields not diplayed: " + notDisplayedInputFieldsOnSecpondPage, 0,
				notDisplayedInputFieldsOnSecpondPage.size());
		userInputPage.navigateToInputPage(3);
		List<String> notDisplayedInputFieldsOnthirdPage = userInputPage.verifyThirdLevelInputPresent();
		assertEquals("List of Input fields not diplayed: " + notDisplayedInputFieldsOnthirdPage, 0,
				notDisplayedInputFieldsOnthirdPage.size());
	}

	@When("I resets the user input values provided")
	public void i_resets_the_user_input_values_provided() {
		userInputPage.clickResetButton();
	}

	@Then("Input values should set to intial state")
	public void input_values_should_set_to_intial_state() {
	}

	@When("I submit the user input values")
	public void i_submit_the_user_input_values() {
	}

	@Then("I should be navigated to the visualization screen")
	public void i_should_be_navigated_to_the_visualization_screen() {
	}

	@Then("Visualization report should be displayed as per user input")
	public void visualization_report_should_be_displayed_as_per_user_input() {
	}

	@Then("User input submitted should reflect in the database")
	public void user_input_submitted_should_reflect_in_the_database(DataTable dataTable) {
	}

	@Then("Model score generated should be displayed")
	public void model_score_generated_should_be_displayed() {

	}

	@Then("Model score generated should reflect in the database")
	public void model_score_generated_should_reflect_in_the_database() {
	}

	@When("I change date range to some other value by toggling the time duration")
	public void i_change_date_range_to_some_other_value_by_toggling_the_time_duration() {

	}

	@Then("Visualization graph should change accordingly")
	public void visualization_graph_should_change_accordingly() {
	}

	@When("I enter {string} in {string} field")
	public void i_enter_in_field(String string, String string2) {
	}

	@Then("I should be suggested with {string} message")
	public void i_should_be_suggested_with_message(String string) {
	}
	
	@When("I enter values in {string} input field")
	public void i_enter_values_in_first_input_field(String inputPage, DataTable dataTable) {
		userInputPage.enterUserInpuValues(inputPage, dataTable);
	}
}
