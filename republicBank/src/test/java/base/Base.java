package base;

import java.sql.Connection;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class Base {
	
	public static WebDriver browser;
	public static Connection con;
	public static Statement st;
	
	public static void navigateURL(String url) {
		browser.get(url);
	}
	
	public static boolean isDisplayed(By by) {
		return browser.findElement(by).isDisplayed();
	}
	
	public static String getText(By by) {
		return browser.findElement(by).getText();
	}
	
	public static boolean isSelect(By by) {
		return browser.findElement(by).isSelected();
	}
	
	public static boolean eleEnabled(By by) {
		return browser.findElement(by).isEnabled();
	}
	
	public static void click(By by) {
		browser.findElement(by).click();
	}
	
	public static void sendKeys(By by, String value) {
		browser.findElement(by).sendKeys(value);
	}
	
	public static void enter(By by) {
		browser.findElement(by).sendKeys(Keys.RETURN);
	}
	

}
