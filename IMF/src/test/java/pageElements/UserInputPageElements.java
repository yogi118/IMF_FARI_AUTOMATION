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
}
