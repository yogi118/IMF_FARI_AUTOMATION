package applicaionProperties;

public enum FirstLevelUserInuptFields {

	REGIME_NAME("Regime Name"), PRODUCTION_BONUS("Production bonus (Start of Production)"), ROYALTY_RATE("Royalty Rate"),
	ROYALTY_BASE("Royalty Base");
	
	private String inputField;

	private FirstLevelUserInuptFields(String inputField) {
		this.inputField = inputField;
	}

	public String inputFieldName() {
		return inputField;
	}
}
