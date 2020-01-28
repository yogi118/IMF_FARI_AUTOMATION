package applicaionProperties;

public enum SecondLevelUserInuptFields {

	DECOMISSIONING_PROVISION("Decommissioning Provision"),
	COMMENCEMENT_OF_DECOMISSIONING_PROVISION("Commencement of Decommissioning Provision"),
	COST_RECOVERY_CEILING("Cost Recovery Ceiling"),
	DEPRECIATION_PERIOD("Development and replacement capital cost depreciation period");

	private String inputField;

	private SecondLevelUserInuptFields(String inputField) {
		this.inputField = inputField;
	}

	public String inputFieldName() {
		return inputField;
	}
}
