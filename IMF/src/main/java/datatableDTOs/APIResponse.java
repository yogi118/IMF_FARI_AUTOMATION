package datatableDTOs;

public class  APIResponse{
	private  String algorithm;
	private String transid;
	private String forecast;
	
	public String getAlgorithm() {
		return algorithm;
	}
	public String getTrans_id() {
		return transid;
	}
	public String getForecast() {
		return forecast;
	}
	
	public APIResponse(String algoRithm, String transId, String foreCast) {
		algorithm = algoRithm;
		transid = transId;
		forecast = foreCast;
	}
}
