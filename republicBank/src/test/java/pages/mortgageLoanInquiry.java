package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice.Enter;

public class mortgageLoanInquiry extends Base {
	
	@Given("Landing page {string}")
	public void landing_page(String url) {
		navigateURL(url);
	}

	@When("I click on Get Started Now Btn")
	public void i_click_on_Get_Started_Now_Btn() {
		click(By.xpath("//div[@class='bottom-content']/p/a"));
	}

	@Then("I verify text on top")
	public void i_verify_text_on_top() throws InterruptedException {
		String actual= getText(By.xpath("//div[@class='small-12 columns']/h1"));
		Assert.assertEquals("MORTGAGE LOAN INQUIRY", actual);
		Thread.sleep(5000);
	}

	@And("I click on Next Btn")
	public void i_click_on_Next_Btn() throws InterruptedException {
		browser.switchTo().frame(browser.findElement(By.xpath("//iframe")));
		
		WebElement nxt = browser.findElement(By.xpath("//div[4]/span/button"));
		nxt.click();

	}

	@Then("I select currently working with a load officer yes or no")
	public void i_select_currently_working_with_a_load_officer_yes_no() {
		click(By.xpath("//div[2]/div[2]/label"));
	}

	@And("select the loan purpose")
	public void select_the_load_purpose() throws InterruptedException {
		click(By.xpath("//div[@id='ee4c630d-1dbd-4945-9fee-07e20f008b87']"));
		
		List<WebElement> abc = browser.findElements(By.xpath("//div[@id='ee4c630d-1dbd-4945-9fee-07e20f008b87']"));

//		String txt = "Purchase a Home";		
//		for(int i=0; i<abc.size();i++) {
//			String x = abc.get(i).getText();
//			if(x.equalsIgnoreCase(txt)) {
//			abc.get(i).click();
//			}
//			else {
//				System.out.println(txt + "not found");
//			}
//		}
		
		for(WebElement option: abc)
		{
			if(option.getText().contains("Purchase a Home")) {
				option.click();
			}
			else {
				System.out.println("not clickable");
			}
		}

	}

	@And("I put estimated purchase price {string}")
	public void i_put_estimated_purchase_price(String string) {
		sendKeys(By.id("13b6ca0a-b982-4967-82fb-2f621ef50559"),"150000");
	}

	@And("I select Down payment percentage")
	public void i_select_Down_payment_percentage() {
		click(By.xpath("//div[@class='Select-placeholder']"));
		
		List<WebElement> xyz = browser.findElements(By.xpath("//div[@id='CX.DP.PERCENT']/div"));
		for(WebElement option: xyz)
		{
			if(option.getText().contains("3.5")) {
				option.click();
			}
			else {
				System.out.println("not clickable");
			}
		}
		
	}

	@And("click Next Btn")
	public void click_Next_Btn() {
		click(By.xpath("//div[4]/span/button[@class=\"button next\"]"));
	}

}
