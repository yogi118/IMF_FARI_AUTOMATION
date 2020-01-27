package pageActions;

import org.openqa.selenium.WebDriver;

import pageElements.GraphVisualizationPageElements;

public class GraphVisualizationPage {
	private static WebDriver webDriver;
	private GraphVisualizationPageElements graphVisualizationPageElements;
	
	public GraphVisualizationPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		graphVisualizationPageElements = new GraphVisualizationPageElements();
	}
}
