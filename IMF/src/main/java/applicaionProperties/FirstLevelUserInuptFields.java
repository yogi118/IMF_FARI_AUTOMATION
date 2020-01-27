package applicaionProperties;

public enum FirstLevelUserInuptFields {

	REGIMENAME("Regime Name"), PRODUCTIONBONUS("Production bonus (Start of Production)"), ROYALTYRATE("Royalty Rate"),
	ROYALTYBASE("Royalty Base");
	
	private String inputField;

	private FirstLevelUserInuptFields(String inputField) {
		this.inputField = inputField;
	}

	public String inputFieldName() {
		return inputField;
	}
}
