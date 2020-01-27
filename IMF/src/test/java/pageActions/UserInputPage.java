package pageActions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import applicaionProperties.FirstLevelUserInuptFields;
import applicaionProperties.SecondLevelUserInuptFields;
import applicaionProperties.ThirdLevelUserInuptFields;
import commonUtils.CUtil;
import datatableDTOs.APIResponse;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import pageElements.UserInputPageElements;

public class UserInputPage {
	private UserInputPageElements userInputPageElements;
	public UserInputPage(WebDriver webDriver) {
		userInputPageElements = new UserInputPageElements();
	}

	public List<String> verifyFirstLevelInputPresent() {
		List<String> notDisplayedLabels = new LinkedList<String>();
		FirstLevelUserInuptFields[] firstPageLabels = FirstLevelUserInuptFields.values();
		for (FirstLevelUserInuptFields firstUserInuptField : firstPageLabels) {
			boolean isLabelDisplayed = isFirstPageInputFieldDisplayed(firstUserInuptField);
			if (!isLabelDisplayed) {
				notDisplayedLabels.add(firstUserInuptField.inputFieldName());
			}
		}
		return notDisplayedLabels;
	}

	private boolean isFirstPageInputFieldDisplayed(FirstLevelUserInuptFields inputField) {
		boolean isDisplayed = false;
		switch (inputField) {
		case REGIMENAME:
		case PRODUCTIONBONUS:
		case ROYALTYRATE:
			isDisplayed = CUtil
					.isDisplayed(By.xpath(String.format(userInputPageElements.userInput, inputField.inputFieldName())));
			break;
		case ROYALTYBASE:
			isDisplayed = CUtil.isDisplayed(
					By.xpath(String.format(userInputPageElements.userInputMat, inputField.inputFieldName())));
			break;
		}
		return isDisplayed;
	}

	public void navigateToInputPage(int pageNumber) {
		CUtil.click(By.xpath(String.format(userInputPageElements.userInputPageHeader, pageNumber)));
	}

	public List<String> verifySecondLevelInputPresent() {
		List<String> notDisplayedLabels = new LinkedList<String>();
		SecondLevelUserInuptFields[] secondUserInuptFields = SecondLevelUserInuptFields.values();
		for (SecondLevelUserInuptFields secondUserInuptField : secondUserInuptFields) {
			boolean isLabelDisplayed = isSecondPageInputFieldDisplayed(secondUserInuptField);
			if (!isLabelDisplayed) {
				notDisplayedLabels.add(secondUserInuptField.inputFieldName());
			}
		}
		return notDisplayedLabels;
	}

	private boolean isSecondPageInputFieldDisplayed(SecondLevelUserInuptFields inputField) {
		boolean isDisplayed = false;
		switch (inputField) {
		case COMMENCEMENTOFDECOMISSIONINGPROVISION:
		case COSTRECOVERYCEILING:
		case DEPRECIATIONPERIOD:
			isDisplayed = CUtil
					.isDisplayed(By.xpath(String.format(userInputPageElements.userInput, inputField.inputFieldName())));
			break;
		case DECOMISSIONINGPROVISION:
			isDisplayed = CUtil.isDisplayed(By.xpath(userInputPageElements.decommissioningProvison));
			break;
		}
		return isDisplayed;
	}

	public List<String> verifyThirdLevelInputPresent() {
		List<String> notDisplayedLabels = new LinkedList<String>();
		ThirdLevelUserInuptFields[] thirdUserInuptFields = ThirdLevelUserInuptFields.values();
		for (ThirdLevelUserInuptFields thirdUserInuptField : thirdUserInuptFields) {
			boolean isLabelDisplayed = isThirdPageInputFieldDisplayed(thirdUserInuptField);
			if (!isLabelDisplayed) {
				notDisplayedLabels.add(thirdUserInuptField.inputFieldName());
			}
		}
		return notDisplayedLabels;
	}

	private boolean isThirdPageInputFieldDisplayed(ThirdLevelUserInuptFields inputField) {
		boolean isDisplayed = false;
		switch (inputField) {
		case VALUE:
		case UPLIFTLIMIT:
		case FROMYEAR:
		case TOYEAR:
			isDisplayed = CUtil
					.isDisplayed(By.xpath(String.format(userInputPageElements.userInput, inputField.inputFieldName())));
			break;
		case TYPESOFALGORITHM:
			isDisplayed = CUtil.isDisplayed(By.xpath(userInputPageElements.typeOfAlgorithm));
		case INVESTMENTUPLIFT:
			isDisplayed = CUtil.isDisplayed(By.xpath(userInputPageElements.invstmentUplift));
			break;
		}
		return isDisplayed;
	}
}
