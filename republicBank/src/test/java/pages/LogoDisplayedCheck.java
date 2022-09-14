package pages;

import org.openqa.selenium.By;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LogoDisplayedCheck extends Base{
	
	@Given("Landing Page")
	public void landing_Page() {
		navigateURL("https://www.myrepublicbank.com/");
	}

	@Then("check the Logo display")
	public void check_the_Logo_display() {
		boolean display = isDisplayed(By.xpath("//img[@class='logo']"));
		System.out.println("Element displayed is : " + display);
	}

}
