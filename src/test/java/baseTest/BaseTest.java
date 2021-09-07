package baseTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import io.restassured.RestAssured;
import utils.ExtentReportListener;
import utils.FileReader;

@Listeners(ExtentReportListener.class)
public class BaseTest extends ExtentReportListener {

	@BeforeTest
	public void beforeTest() {
		RestAssured.baseURI = FileReader.getConfigReader().get("ServerUrl");
	}
}
