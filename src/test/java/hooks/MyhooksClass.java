package hooks;


import java.util.Properties;
import org.openqa.selenium.WebDriver;
import driverFactory.Factory1;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class MyhooksClass {

	WebDriver driver;

	@Before
	public void setUp() {

		Properties prop = ConfigReader.initiallizeProperties();
		driver=Factory1.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

		
	}

	@After
	public void tearDown() {

		driver.quit();
	}

}
