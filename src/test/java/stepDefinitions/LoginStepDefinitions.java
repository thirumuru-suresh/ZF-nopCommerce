package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.zfnopCommerce.commons.DriverManager;
import com.zfnopCommerce.commons.ReadConfig;
import com.zfnopCommerce.page.LoginPage;
import com.zfnopCommerce.utilities.TestLogger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitions {

	WebDriver driver;
	LoginPage loginPage;
	ReadConfig readConfig;
	
	@Given("^Open browser \"([^\"]*)\"$")
	public void open_browser(String browsername) throws Throwable {
		TestLogger.propertyConfiguration();
		TestLogger.testMessage("Browser is about to open");
		DriverManager.getDriver(browsername);
		TestLogger.testMessage("Browser is opened");

	}


	@When("user enters the URL")
	public void user_enters_the_url() {
		//String url = EnvironmentManager.getUrl();
		TestLogger.testMessage("Application URl has to open");
		//String url = "http://admin-demo.nopcommerce.com/";
		readConfig = new ReadConfig();
		String url = readConfig.getUrl();
		DriverManager.openURL(url);
		TestLogger.testMessage("Application URl has opened");

	}

	@When("^enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_username_and_password(String email, String password) throws Throwable {
		TestLogger.testMessage("email:" + email + "  password:" + password + "  will be passed");
		driver = DriverManager.getDriverReference();
		loginPage = new LoginPage(driver);
		loginPage.setEmail(email);
		loginPage.setPassword(password);
		TestLogger.testMessage("email:" + email + "  password:" + password + "  has passed");
		
	}

	@When("click on login button")
	public void click_on_login_button() {
		loginPage.clickLogin();
		TestLogger.testMessage("Loggedin Successfully");
	}
	
	@When("^verify title of the page$")
	public void verify_title_of_the_page() throws Throwable {
		driver = DriverManager.getDriverReference();
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Thread.sleep(5000);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		TestLogger.testMessage("HomePage title verified");
	}
	

	@Then("^home page should be shown and closed application$")
	public void home_page_should_be_shown_and_closed_application() throws Throwable {
		DriverManager.closeBrowser();
		TestLogger.testMessage("Browser closed");

	}

}
