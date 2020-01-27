package enums;

public enum SecondUserInuptFields {

	DECOMISSIONINGPROVISION("Decommissioning Provision"),
	COMMENCEMENTOFDECOMISSIONINGPROVISION("Commencement of Decommissioning Provision"),
	COSTRECOVERYCEILING("Cost Recovery Ceiling"),
	DEPRECIATIONPERIOD("Development and replacement capital cost depreciation period");

	private String inputField;

	private SecondUserInuptFields(String inputField) {
		this.inputField = inputField;
	}

	public String inputFieldName() {
		return inputField;
	}
}
