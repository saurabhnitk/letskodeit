package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomDriver {
	
	public WebDriver driver;
	private JavascriptExecutor js;
	
	public CustomDriver(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}
	
	public void refresh() {
		driver.navigate().refresh();
		System.out.println("current browser location refreshed");
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		System.out.println("Title: " +title);
		return title;
	}
	
	public By getByType(String locator) {
		By by = null;
		String locatorType = locator.split("=>")[0];
		locator = locator.split("=>")[1];
		try {
			if(locatorType.contains("id")) {
				by = By.id(locator);
			}else if(locatorType.contains("xpath")) {
				by = By.xpath(locator);
			}else if(locatorType.contains("name")) {
				by = By.name(locator);
			}else if(locatorType.contains("css")) {
				by = By.cssSelector(locator);
			}else if(locatorType.contains("class")) {
				by = By.className(locator);
			}else if(locatorType.contains("tag")) {
				by = By.tagName(locator);
			}else if(locatorType.contains("link")) {
				by = By.linkText(locator);
			}else if(locatorType.contains("partiallink")) {
				by = By.partialLinkText(locator);
			}else {
				System.out.println("Locator type not supported");
			}
		}catch(Exception e) {
			System.out.println(locatorType);
		}
		return by;
	}
	
	public WebElement getElement(String locator, String info) {
		WebElement element = null;
		By byType = getByType(locator);
		try {
			element = driver.findElement(byType);
			System.out.println("Element found with: " +locator);
		}catch(Exception e) {
			System.out.println("Element not found with: " +locator);
			e.printStackTrace();
		}
		return element;
	}
	
	

}
