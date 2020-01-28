package pageActions;


import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import applicaionProperties.FirstLevelUserInuptFields;
import applicaionProperties.SecondLevelUserInuptFields;
import applicaionProperties.ThirdLevelUserInuptFields;
import commonUtils.CUtil;
import commonUtils.WaitTimes;
import io.cucumber.datatable.DataTable;
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
		case REGIME_NAME:
		case PRODUCTION_BONUS:
		case ROYALTY_RATE:
			isDisplayed = CUtil
					.isDisplayed(By.xpath(String.format(userInputPageElements.userInput, inputField.inputFieldName())));
			break;
		case ROYALTY_BASE:
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
		case COMMENCEMENT_OF_DECOMISSIONING_PROVISION:
		case COST_RECOVERY_CEILING:
		case DEPRECIATION_PERIOD:
			isDisplayed = CUtil
					.isDisplayed(By.xpath(String.format(userInputPageElements.userInput, inputField.inputFieldName())));
			break;
		case DECOMISSIONING_PROVISION:
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
		case UPLIFT_LIMIT:
		case FROM_YEAR:
		case TO_YEAR:
			isDisplayed = CUtil
					.isDisplayed(By.xpath(String.format(userInputPageElements.userInput, inputField.inputFieldName())));
			break;
		case TYPES_OF_ALGORITHM:
			isDisplayed = CUtil.isDisplayed(By.xpath(userInputPageElements.typeOfAlgorithm));
		case INVESTMENT_UPLIFT:
			isDisplayed = CUtil.isDisplayed(By.xpath(userInputPageElements.invstmentUplift));
			break;
		}
		return isDisplayed;
	}
	
	public void selectRegimeName(String value) {
		CUtil.click(By.xpath(userInputPageElements.regimeNameDropDown));
		CUtil.pause(WaitTimes.MEDIUM_WAIT_TIME);
		CUtil.click(By.xpath(String.format(userInputPageElements.regimeNameOption, value)));
	}
	
	public void enterValueInInputBox(String inputField, String value) {
		CUtil.type(By.xpath(String.format(userInputPageElements.userInputBox, inputField)), value);
	}
	
	public void selectRoyaltyBase(String value) {
		CUtil.click(By.xpath(String.format(userInputPageElements.royaltyBaseRadio, value)));
	}
	
	public void enterUserInpuValues(String inputPage, DataTable dataTable) {
		List<List<String>> list = dataTable.asLists();
		for (List<String> value : list) {
			String inputField = value.get(0);
			String inputValue = value.get(1);
			enterValueInInputField(inputField, inputValue);
			CUtil.pause(WaitTimes.SMALL_WAIT_TIME);
		}
		if(inputPage.equals("first")) {
			clickNextButton(1);
			CUtil.pause(WaitTimes.SMALL_WAIT_TIME);
		}else if(inputPage.equals("second")) {
			clickNextButton(2);
			CUtil.pause(WaitTimes.SMALL_WAIT_TIME);
		}else {
			
		}
	}
	
	public void enterValueInInputField(String inputField, String value) {
		switch (inputField) {
		case "Regime Name":
			selectRegimeName(value);
			break;
		case "Production bonus (Start of Production)":
		case "Royalty Rate":
		case "Commencement of Decommissioning Provision":
		case "Cost Recovery Ceiling":
		case "Development and replacement capital cost depreciation period":
		case "Value":
		case "Uplift Limit":
		case "From Year":
		case "To Year":
			enterValueInInputBox(inputField, value);
			break;
		case "Royalty Base":
		case "Type of Algorithm":
			selectRoyaltyBase( value);
			break;
		case "Decommissioning Provision":
			chooseDecomProvisoning(value);
			break;
		case "Investment Uplift":
			chooseInvestmentUplift(value);
		default:
			break;
		}
	}
	
	public void clickNextButton(int pageIndex) {
		CUtil.click(By.xpath(String.format(userInputPageElements.nextButton, pageIndex)));
		CUtil.waitForPageLoad();
		CUtil.pause(WaitTimes.SMALL_WAIT_TIME);
	}
	
	public void chooseDecomProvisoning(String value) {
		String className = CUtil.getAttribute(By.id(userInputPageElements.decomProvisionButton), "class");
		if(value.equals("Yes") && !className.contains("checked")) {
			CUtil.click(By.cssSelector(userInputPageElements.decomProvisionToggleButton));
			CUtil.pause(WaitTimes.SMALL_WAIT_TIME);
		}
	}
	
	public void chooseInvestmentUplift(String value) {
		String className = CUtil.getAttribute(By.id(userInputPageElements.investmentUpliftButton), "class");
		if(value.equals("Yes") && !className.contains("checked")) {
			CUtil.click(By.cssSelector(userInputPageElements.investmentUpliftToggleButton));
			CUtil.pause(WaitTimes.SMALL_WAIT_TIME);
		}
	}
	
	public void clickResetButton() {
		CUtil.click(By.xpath(userInputPageElements.resetButton));
		CUtil.pause(WaitTimes.LARGE_WAIT_TIME);
	}
}
