package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage {
	@FindBy(xpath="//span[@class='title']") private WebElement nameProduct;
    @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement addToCartSauceLabsBackpack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement displayedremove;
    
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDisplayedHomePage()
	{
		return nameProduct.isDisplayed();
	}
	
	public void clickOnAddToCartOfSLB()
	{
		addToCartSauceLabsBackpack.click();
	}
	
	public String isDisplayedremove()
	{
		
		return displayedremove.getText();
		
	}
	
}
