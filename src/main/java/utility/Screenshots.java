package utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshots {
	
	public static void takeScreenshots(WebDriver driver,String name) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("E:\\Eclipse\\SwagLab\\src\\test\\resources\\Screenshots\\"+name+".png");
		FileHandler.copy(source, destination);		
	}

	//public static void main(String args[]) throws IOException
	//{
	//	Screenshots screenshots=new Screenshots();
	//	screenshots.takeScreenshots();
	//}
}
