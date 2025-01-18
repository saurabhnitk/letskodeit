package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Util;

public class NavigationPage {
	
	public WebDriver driver;
	private final String URL = "https://learn.letskodeit.com/courses";
	private String ALL_COURSES_LINK = "//a[contains(text(),'All Courses')]";
	private String MY_COURSES_LINK = "//a[contains(text(),'My Courses')]";	
	private String ACCOUNT_ICON = "gravatar";
	private String LOGIN_LINK = "//a[@href='/sign_in']";
	private String LOGOUT_LINK = "//a[@href='/sign_out']";

	public NavigationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void allCourses() {
		driver.findElement(By.xpath(ALL_COURSES_LINK)).click();
	}
	
	/*public boolean isOpen() {
		return URL.equalsIgnoreCase(driver.getCurrentUrl());
	}*/
	
	public void myCourses() {
		driver.findElement(By.xpath(MY_COURSES_LINK)).click();
	}
	
	public boolean isUserLoggedIn() {
		try {
			WebElement accountImage = driver.findElement(By.className(ACCOUNT_ICON));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean verifyHeader() {
		WebElement link = driver.findElement(By.xpath(ALL_COURSES_LINK));
		String linkText = link.getText();
		return Util.verifyTextContains(linkText, "All Courses");
	}

}
