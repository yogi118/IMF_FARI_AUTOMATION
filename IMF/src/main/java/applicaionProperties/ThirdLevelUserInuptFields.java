package applicaionProperties;

public enum ThirdLevelUserInuptFields {

	INVESTMENT_UPLIFT("Investment Uplift"), VALUE("Value"), UPLIFT_LIMIT("Uplift Limit"), FROM_YEAR("From Year"),
	TO_YEAR("To Year"), TYPES_OF_ALGORITHM("Type of Algorithm");

	private String inputField;

	private ThirdLevelUserInuptFields(String inputField) {
		this.inputField = inputField;
	}

	public String inputFieldName() {
		return inputField;
	}
}
