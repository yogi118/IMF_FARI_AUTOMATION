package applicaionProperties;

public enum AllUserInuptFields {

	REGIMENAME("Regime Name"), PRODUCTIONBONUS("Production bonus (Start of Production)"), ROYALTYRATE("Royalty Rate"),
	ROYALTYBASE("Royalty Base"), DECOMISSIONINGPROVISION("Decommissioning Provision"),
	COMMENCEMENTOFDECOMISSIONINGPROVISION("Commencement of Decommissioning Provision"),
	COSTRECOVERYCEILING("Cost Recovery Ceiling"),
	DEPRECIATIONPERIOD("Development and replacement capital cost depreciation period"),
	INVESTMENTUPLIFT("Investment Uplift"), VALUE("Value"), UPLIFTLIMIT("Uplift Limit"), FROMYEAR("From Year"),
	TOYEAR("To Year"), TYPESOFALGORITHM("Type of Algorithm *"), SUBMIT("Submit"), RESET("Reset"), NET("Net"), GROSS("Gross");

	private String inputField;

	private AllUserInuptFields(String inputField) {
		this.inputField = inputField;
	}

	public String filterType() {
		return inputField;
	}
}
