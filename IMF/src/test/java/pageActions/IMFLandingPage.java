package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonUtils.CUtil;
import pageElements.IMFLandingPageElements;

public class IMFLandingPage {
	private static WebDriver webDriver;
	private IMFLandingPageElements imfLandingPageElements;
	
	public IMFLandingPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		imfLandingPageElements = new IMFLandingPageElements();
	}
	
	public void openLandingPage() {
		webDriver.get("http://devareaer1app.azurewebsites.net/fari/#/fari");
		CUtil.waitForPageLoad();
	}
	
	public void clickFariLink() {
		CUtil.click(By.xpath(imfLandingPageElements.fariLink));
		CUtil.waitForPageLoad();
	}
}
