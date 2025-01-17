package testClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.NavigationPage;
import pageObjects.CategoryFilterPage;
import pageObjects.LoginPage;
import pageObjects.ResultsPage;
import pageObjects.SearchBarPage;

public class AllCoursesTest {
	
	WebDriver driver;
	String baseUrl;
	LoginPage login;
	NavigationPage nav;
	SearchBarPage search;
	ResultsPage result;
	CategoryFilterPage category;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		baseUrl = "https://learn.letskodeit.com/";
		driver.get(baseUrl);
		login = new LoginPage(driver);
		login.open();
		nav = login.signInWith("test@email.com","abcabc");
	}
	
	@Test
	public void verifySearchCourse() {
		nav.allCourses();
		nav.myCourses();
		search = new SearchBarPage(driver);
		result = search.course("rest api");
		boolean searchResult = result.verifySearchResult();
		Assert.assertTrue(searchResult);
	}
	
	@Test(dependsOnMethods="verifySearchCourse")
	public void filterByCategory() {
		nav = new NavigationPage(driver);
		nav.allCourses();
		category = new CategoryFilterPage(driver);
		ResultsPage result = category.select("Software IT");
		int count = category.findCoursesCount("Software IT");
		boolean filterResult = result.verifyFilterCourseCount(count);
		Assert.assertTrue(filterResult);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
