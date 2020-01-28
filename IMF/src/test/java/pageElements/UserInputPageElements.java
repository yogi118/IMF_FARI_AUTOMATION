package pageElements;

public class UserInputPageElements {

	public String userInput = ".//div[contains(text(),'" +"%s"+"')]/parent::div[@class='mat-form-field-infix']";
	public String userInputLabel = ".//div[contains(text(),'" +"%s"+"')]";
	public String userInputPageHeader = "(.//mat-step-header)["+ "%d" +"]";
	public String userInputMatLabels = ".//mat-label[contains(text(),'" +"%s"+"')]";
	public String userInputMat = ".//mat-label[contains(text(),'" +"%s"+"')]/parent::div";
	public String firstLevelNextButton = "(.//span[contains(text(),'Next')]/parent::button)["+ "%d" +"]";
	public String decommissioningProvison = ".//div[contains(text(),'Decommissioning Provision')]/parent::div[@class='col-md-6 fari_grid mt-3']";
	public String invstmentUplift = ".//div[contains(text(),'Investment Uplift')]/parent::div[@class='col']";
	public String typeOfAlgorithm = ".//div[contains(text(),'Type of Algorithm')]/parent::div[@class='col-md-6 text-center mt-2']";
	public String regimeNameDropDown = ".//div[contains(text(),'Regime Name')]/parent::div[@class='mat-form-field-infix']/descendant::mat-select";
	public String regimeNameOption = ".//span[@class='mat-option-text' and contains(text(),'" + "%s" +"')]";
	public String userInputBox = ".//div[contains(text(),'" +"%s"+"')]/parent::div[@class='mat-form-field-infix']/descendant::input";
	public String royaltyBaseRadio = ".//div[@class='mat-radio-label-content' and contains(text(),'" + "%s" + "')]/preceding-sibling::div[@class='mat-radio-container']";
	public String nextButton = "(.//span[@class='mat-button-wrapper' and contains(text(),'Next')])[" + "%d" +"]/parent::button";
	public String decomProvisionButton = "mat-slide-toggle-1";
	public String decomProvisionToggleButton = "#mat-slide-toggle-1 .mat-slide-toggle-bar";
	public String investmentUpliftButton =  "mat-slide-toggle-2";
	public String investmentUpliftToggleButton =  "#mat-slide-toggle-2 .mat-slide-toggle-bar";
	public String resetButton = ".//span[@class='mat-button-wrapper' and contains(text(),'Reset')]/parent::button";
}
