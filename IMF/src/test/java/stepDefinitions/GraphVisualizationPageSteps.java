package stepDefinitions;

import org.openqa.selenium.WebDriver;

import pageActions.GraphVisualizationPage;
import runner.SharedDriver;

public class GraphVisualizationPageSteps {
	private WebDriver webDriver;
	private GraphVisualizationPage graphVisualizationPage;
	
	public GraphVisualizationPageSteps(SharedDriver weDriver) {
		this.webDriver = webDriver;
		graphVisualizationPage = new GraphVisualizationPage(weDriver);
	}
}
