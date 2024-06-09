package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;
import utility.Parametrization;
import utility.Screenshots;
public class SwagLabLoginTest extends Parametrization{
	 WebDriver driver;
	@BeforeMethod
	public void beforeClassMethod()
    {
	   driver=Browser.launchBrowser("https://www.saucedemo.com/");	
	}
	
	@Test(enabled=false)
	public void googleSuggestions()
	{
		//WebDriver driver=Browser.LaunchBrowser("https://www.google.com/");
		WebElement searchinput=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		searchinput.sendKeys("test");
		WebElement search=driver.findElement(By.xpath("(//input[@value='Google Search'])[1]"));
        search.click();	
        //WebElement test=driver.findElement(By.xpath("(//div[@jsname='DFrD7b'])[1]"));
		//test.click();
		List <WebElement> suggestions=driver.findElements(By.xpath("//div//h3"));
		
		for(int i=0;i<suggestions.size();i++)
		{
			String suggestion=suggestions.get(i).getText();
			System.out.println(suggestion);
		}
	}
	
	@Test(priority=0)
     public void loginWithStandardUser() throws EncryptedDocumentException, IOException 
	{
		SwagLabLoginPage swagLabLoginTestPage = new SwagLabLoginPage(driver);
		swagLabLoginTestPage.enterUserName(Parametrization.getData(2, 0));
		swagLabLoginTestPage.enterPassword(Parametrization.getData(2, 1));
		Screenshots.takeScreenshots(driver,Parametrization.getData(2, 0));
		swagLabLoginTestPage.clickOnLoginButton();
		String actual=driver.getCurrentUrl();
		//System.out.println(actual);
		String expected="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(expected,actual); //this is validation that our test is pass call Assertion
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		swagLabHomePage.clickOnAddToCartOfSLB();
		String showRemove=swagLabHomePage.isDisplayedremove();
		Assert.assertEquals("Remove", showRemove);
		System.out.println("Hello"); //if test fail Hard Assert will not allow to excute next line of code
		
	}
	
	@Test(priority=1)
	public void loginWithLockedOutUser() throws EncryptedDocumentException, IOException
	{
		SwagLabLoginPage swagLabLoginTestPage=new SwagLabLoginPage(driver);
		swagLabLoginTestPage.enterUserName(Parametrization.getData(3, 0));
		swagLabLoginTestPage.enterPassword(Parametrization.getData(2, 1));
		Screenshots.takeScreenshots(driver,Parametrization.getData(3, 0));
		swagLabLoginTestPage.clickOnLoginButton();
		String actualTitle=driver.getTitle();
		String expectedTitle="Swag Labs";
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertNotEquals(actualTitle,expectedTitle);
		System.out.println("Soft Assertion After fail the test excute till end of test and notify the test fails at end");
		softAssert.assertAll();  //assertAll() method should called at the end of test then if test fail then also other code get excute
	}
	
	@Test(priority=2)
	public void loginWithProblemUser() throws EncryptedDocumentException, IOException
	{
		SwagLabLoginPage swagLabLoginTestPage=new SwagLabLoginPage(driver);
		swagLabLoginTestPage.enterUserName(Parametrization.getData(4, 0));
		swagLabLoginTestPage.enterPassword(Parametrization.getData(2, 1));
		Screenshots.takeScreenshots(driver,Parametrization.getData(4, 0));
		swagLabLoginTestPage.clickOnLoginButton();
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		boolean visibaleNameProduct=swagLabHomePage.isDisplayedHomePage();
		Assert.assertTrue(visibaleNameProduct);
		
	}
	
	@Test(priority=3)
	public void loginWithPerformanceGlitchUser() throws EncryptedDocumentException, IOException
	{
		SwagLabLoginPage swagLabLoginTestPage=new SwagLabLoginPage(driver);
		swagLabLoginTestPage.enterUserName(Parametrization.getData(5, 0));
		swagLabLoginTestPage.enterPassword(Parametrization.getData(2, 1));
		Screenshots.takeScreenshots(driver,Parametrization.getData(5, 0));
		swagLabLoginTestPage.clickOnLoginButton();
		boolean title=driver.getTitle().equalsIgnoreCase("swag labs2");
		Assert.assertFalse(title);
	}
	
	@Test(priority=4,enabled=false)
	public void loginWithErrorUser() throws EncryptedDocumentException, IOException
	{
		SwagLabLoginPage swagLabLoginTestPage=new SwagLabLoginPage(driver);
		swagLabLoginTestPage.enterUserName(Parametrization.getData(6, 0));
		swagLabLoginTestPage.enterPassword(Parametrization.getData(2, 1));
		Screenshots.takeScreenshots(driver,Parametrization.getData(6, 0));
		swagLabLoginTestPage.clickOnLoginButton();
	}
	
	@Test(priority=5,enabled=false)
	public void loginWithVisualUser() throws EncryptedDocumentException, IOException
	{
		SwagLabLoginPage swagLabLoginTestPage=new SwagLabLoginPage(driver);
		swagLabLoginTestPage.enterUserName(Parametrization.getData(7, 0));
		swagLabLoginTestPage.enterPassword(Parametrization.getData(2, 1));
		Screenshots.takeScreenshots(driver,Parametrization.getData(7, 0));
		swagLabLoginTestPage.clickOnLoginButton();
	}

	@AfterMethod
	public void closeBrowser() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}
