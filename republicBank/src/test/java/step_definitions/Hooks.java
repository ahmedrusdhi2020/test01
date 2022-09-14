package step_definitions;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Base {
	
	@Before
	public void setup() throws SQLException {
		ChromeOptions option = new ChromeOptions(); 
		option.setHeadless(false);
		WebDriverManager.chromedriver().setup();
		browser = new ChromeDriver(option);
		browser.manage().window().maximize();
		System.out.println(browser);
		
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmicrotech", "root", "root");
		st = con.createStatement();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		 try {
				String screenshotName= scenario.getName().replace("", "");
				if(scenario.isFailed()) {
					scenario.log("this is my failure message");
					TakesScreenshot ts = (TakesScreenshot)browser;
					byte[]screenshot = ts.getScreenshotAs(OutputType.BYTES);
					scenario.attach(screenshot, "image/png", screenshotName);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		//browser.close();
	}

}
