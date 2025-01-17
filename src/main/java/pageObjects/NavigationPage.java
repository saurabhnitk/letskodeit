package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage {
	
	public WebDriver driver;
	private final String URL = "https://learn.letskodeit.com/courses";
	private String ALL_COURSES_LINK = "//a[contains(text(),'All Courses')]";
	private String MY_COURSES_LINK = "//a[contains(text(),'My Courses')]";	

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

}
