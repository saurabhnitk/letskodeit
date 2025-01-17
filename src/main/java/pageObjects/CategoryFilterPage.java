package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryFilterPage {
	
	public CategoryFilterPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}
	
	public WebDriver driver;
	private JavascriptExecutor js;
	private String CATEGORY_DROPDOWN = "(//div[contains(@class,'course-filter')])[1]//button";
	private String CATEGORY_OPTION = "//a[@href='/courses/category/%s']";
	
	public void clickCategoryDropdown() {
		WebElement categoryDropdown = driver.findElement(By.xpath(CATEGORY_DROPDOWN));
		categoryDropdown.click();		
	}
	
	public WebElement findCategory(String category) {	
		clickCategoryDropdown();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement categoryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(CATEGORY_OPTION, category))));
		return categoryOption;
	}
	
	public ResultsPage select(String categoryName) {
		WebElement categoryOption = findCategory(categoryName);
		js.executeScript("arguments[0].click();", categoryOption); 
		return new ResultsPage(driver);
	}
	
	public int findCoursesCount(String categoryName) {
		WebElement categoryOption = findCategory(categoryName);
		//Get category text
		String categoryText = categoryOption.getText();
		//split on ( symbol
		String[] arrayTemp = categoryText.split("\\(");
		//split arrayTemp[1] on ) symbol
		String courseCountString = arrayTemp[1].split("\\)")[0];
		int courseCount = Integer.parseInt(courseCountString);
		//click dropdown again to close the menu
		clickCategoryDropdown();
		return courseCount;
	}
	
}
