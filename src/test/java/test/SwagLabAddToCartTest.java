package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;
import utility.Parametrization;
import utility.Screenshots;

public class SwagLabAddToCartTest  {

	WebDriver driver;
	@BeforeMethod
	public void beforeClassMethod()
    {
	   driver=Browser.launchBrowser("https://www.saucedemo.com/");	
	}
	
	@Test()
     public void addToCartOfStandardUser() throws EncryptedDocumentException, IOException  
	{

		SwagLabLoginPage swagLabLoginTestPage = new SwagLabLoginPage(driver);
		swagLabLoginTestPage.enterUserName(Parametrization.getData(2, 0));
		swagLabLoginTestPage.enterPassword(Parametrization.getData(2, 1));
		Screenshots.takeScreenshots(driver,Parametrization.getData(2, 0));
		swagLabLoginTestPage.clickOnLoginButton();
		
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		swagLabHomePage.clickOnAddToCartOfSLB();
		String showRemove=swagLabHomePage.isDisplayedremove();
		Assert.assertEquals("Remove", showRemove);
		System.out.println("Hello"); //if test fail Hard Assert will not allow to excute next line of code
		
		
	}
	
	
}
