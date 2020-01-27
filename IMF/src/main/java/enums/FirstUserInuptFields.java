package enums;

public enum FirstUserInuptFields {

	REGIMENAME("Regime Name"), PRODUCTIONBONUS("Production bonus (Start of Production)"), ROYALTYRATE("Royalty Rate"),
	ROYALTYBASE("Royalty Base");
	
	private String inputField;

	private FirstUserInuptFields(String inputField) {
		this.inputField = inputField;
	}

	public String inputFieldName() {
		return inputField;
	}
}
