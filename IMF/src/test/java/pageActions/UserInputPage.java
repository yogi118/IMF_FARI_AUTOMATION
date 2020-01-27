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

import commonUtils.CUtil;
import datatableDTOs.APIResponse;
import enums.FirstUserInuptFields;
import enums.SecondUserInuptFields;
import enums.ThirdUserInuptFields;
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
		FirstUserInuptFields[] firstPageLabels = FirstUserInuptFields.values();
		for (FirstUserInuptFields firstUserInuptField : firstPageLabels) {
			boolean isLabelDisplayed = isFirstPageInputFieldDisplayed(firstUserInuptField);
			if (!isLabelDisplayed) {
				notDisplayedLabels.add(firstUserInuptField.inputFieldName());
			}
		}
		return notDisplayedLabels;
	}

	private boolean isFirstPageInputFieldDisplayed(FirstUserInuptFields inputField) {
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
		SecondUserInuptFields[] secondUserInuptFields = SecondUserInuptFields.values();
		for (SecondUserInuptFields secondUserInuptField : secondUserInuptFields) {
			boolean isLabelDisplayed = isSecondPageInputFieldDisplayed(secondUserInuptField);
			if (!isLabelDisplayed) {
				notDisplayedLabels.add(secondUserInuptField.inputFieldName());
			}
		}
		return notDisplayedLabels;
	}

	private boolean isSecondPageInputFieldDisplayed(SecondUserInuptFields inputField) {
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
		ThirdUserInuptFields[] thirdUserInuptFields = ThirdUserInuptFields.values();
		for (ThirdUserInuptFields thirdUserInuptField : thirdUserInuptFields) {
			boolean isLabelDisplayed = isThirdPageInputFieldDisplayed(thirdUserInuptField);
			if (!isLabelDisplayed) {
				notDisplayedLabels.add(thirdUserInuptField.inputFieldName());
			}
		}
		return notDisplayedLabels;
	}

	private boolean isThirdPageInputFieldDisplayed(ThirdUserInuptFields inputField) {
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
