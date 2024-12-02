package com.brighthorizons.QA_ParentTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.brighthorizons.Utility.Test_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException
	{
		/**
		 * FileInputStream class to read data from File
		 * Call browser details
		 */
		prop=new Properties();
		
		try {
			FileInputStream fis=new FileInputStream("./src/main/java/com/brighthorizons/configuration/config.properties");
			prop.load(fis);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void initialization()
	{
		// This code for select the and open browser
		String browserName = prop.getProperty("browser");
		
			if(browserName.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--remote-allow-origins=*");
				opt.addArguments("--disable-notifications");
				driver=new ChromeDriver(opt);
			}
			else
				if(browserName.equals("edge"))
				{
					WebDriverManager.chromedriver().setup();
					EdgeOptions opt=new EdgeOptions();
					opt.addArguments("--remote-allow-origins=*");
					opt.addArguments("--disable-notifications");
					driver=new EdgeDriver(opt);
				}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Test_Utility.Implicit_wait));
			
			driver.get(prop.getProperty("url")); //URL mentioned in the Config file
			
		}
}