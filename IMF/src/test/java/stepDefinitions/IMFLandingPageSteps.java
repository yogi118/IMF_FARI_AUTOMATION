package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import pageActions.IMFLandingPage;
import runner.SharedDriver;

public class IMFLandingPageSteps {
	private WebDriver webDriver;
	private IMFLandingPage imfLandingPage;
	
	public IMFLandingPageSteps(SharedDriver webDriver) {
		this.webDriver = webDriver;
		imfLandingPage = new IMFLandingPage(webDriver);
	}
	
	@Given("I am on IMF landing page")
	public void i_am_on_IMF_landing_page() {
	    imfLandingPage.openLandingPage();
	}
	
	@When("I navigate to FARI user input screen")
	public void i_navigate_to_FARI_user_input_screen() {
		imfLandingPage.clickFariLink();
	}
}
