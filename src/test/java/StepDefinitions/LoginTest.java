package StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	
	public WebDriver driver;
	
	
	@Given("^User should on login page$")
	public void user_should_on_login_page() throws Throwable {
	  System.setProperty("webdriver.chrome.driver", "E:/Selenium/Selenium_Software/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://localhost:100");
	  //LaunchApp();	
	}

	@When("^User enter valid user id \"([^\"]*)\" and valid password \"([^\"]*)\"$")
	public void user_enter_valid_user_id_and_valid_password(String arg1, String arg2) throws Throwable {
		driver.findElement(By.name("user_name")).sendKeys(arg1);
		driver.findElement(By.name("user_password")).sendKeys(arg2);
		driver.findElement(By.name("Login")).click();
	   
	}

	@Then("^User will be landed on home page$")
	public void user_will_be_landed_on_home_page() throws Throwable {
		System.out.println("User will be landed on home page");
	}

	@Then("^Logout link should be visible on home page$")
	public void logout_link_should_be_visible_on_home_page() throws Throwable {
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Then("^Run multiple time$")
	public void run_multiple_time(DataTable data) throws Throwable {
		List<List<String>> d = data.raw();
		System.out.println(d.get(0).get(0));
		System.out.println(d.get(0).get(1));
	}

}
