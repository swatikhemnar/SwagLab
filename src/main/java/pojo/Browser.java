package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static WebDriver launchBrowser(String url)
	{
		
		System.setProperty("window.chrome.driver", "D:\\Downloads\\Software for Arise\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        return driver;
	 
	}

}
