package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ResultsPage {
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver driver;
	private String URL = "query=";
	private String COURSES_LIST = "//div[@class='course-listing']";
	
	public boolean isOpen() {
		return driver.getCurrentUrl().contains(URL);
	}
	
	public int coursesCount() {
		List<WebElement> coursesList = driver.findElements(By.xpath(COURSES_LIST));
		return coursesList.size();
	}
	
	public boolean verifySearchResult() {
		boolean result = true;
		if(coursesCount() > 0) {
			result = true;
		}
		result = isOpen() && result;
		return result;
	}
	
	public boolean verifyFilterCourseCount(int expectedCount) {
		return coursesCount() == expectedCount;
	}

}
