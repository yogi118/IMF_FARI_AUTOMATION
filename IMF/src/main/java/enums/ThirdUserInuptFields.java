package enums;

public enum ThirdUserInuptFields {

	INVESTMENTUPLIFT("Investment Uplift"), VALUE("Value"), UPLIFTLIMIT("Uplift Limit"), FROMYEAR("From Year"),
	TOYEAR("To Year"), TYPESOFALGORITHM("Type of Algorithm");

	private String inputField;

	private ThirdUserInuptFields(String inputField) {
		this.inputField = inputField;
	}

	public String inputFieldName() {
		return inputField;
	}
}
