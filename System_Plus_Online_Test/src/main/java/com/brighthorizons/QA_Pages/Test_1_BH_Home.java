package com.brighthorizons.QA_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.brighthorizons.QA_ParentTest.TestBase;
import com.brighthorizons.Utility.Test_Utility;

public class Test_1_BH_Home extends TestBase
{
	//Page Factory
	@FindBy (xpath="(//ul[@class='nav-list-wrap']//li[@class='nav-item displayed-desktop']/a[contains(text(),'Find a Center')])[1]")
	WebElement btnFindCenter;
	
	@FindBy (xpath = "//div[@class='centerDetails results']//span[@class='resultsNumber']")
	WebElement resNumber;
	
	@FindBy (xpath = "//h3[@class='centerResult__name' and contains(text(),'Bright Horizons at 20 Pine')]")
	WebElement resNumber1;
	
	/*@FindBy (xpath="//div[@class='description-wrapper']//div/h3[@class='centerResult__name' and contains(text(),'Bright Horizons at TriBeCa')]")
	WebElement firstCenterList;*/
	
	@FindBy (xpath="//div[@class='description-wrapper']//div/h3[@class='centerResult__name' and contains(text(),'Bright Horizons at TriBeCa')]//parent::div//following-sibling::span[2]")
	WebElement firstCenterList;
	
	@FindBy (xpath="//div[@id='1489']/span[@class='mapTooltip__headline' and contains(text(),'Bright Horizons at TriBeCa')]//parent::div//parent::div//following-sibling::div/div[@class='mapTooltip__address' and contains(text(),'129 Hudson Street ')]")
	WebElement firstCenterEle;
	
	Test_Utility test=new Test_Utility();
	

	public Test_1_BH_Home() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}
	
	public void homePage() throws IOException // Home Page functionality
	{
		btnFindCenter.click(); // to click on Find Center button
		
		/**
		 * Below Code for
		 * below code is to verify newly open page contains child care locator as its part of URL.
		 */
		String curURL = driver.getCurrentUrl();
		System.out.println(curURL);
		test.takesScreenshot(); // Takes Screenshot
		
		/**
		 * Below Code for
		 * Below Code to Enter City name and select
		 */
		WebElement locSearch = driver.findElement(By.xpath("//input[@id='addressInput']"));
		locSearch.sendKeys("New York");
		
		String text = "";
		
		do
		{
			locSearch.sendKeys(Keys.ARROW_DOWN); // with this it go to first element
			text = locSearch.getDomAttribute("value");
			
			if(text.equals("New York, NY, USA"))
			{
				locSearch.sendKeys(Keys.ENTER);
				break;
			}
		}
		while(!text.isEmpty());
		
		test.takesScreenshot(); // Takes Screenshot
		
		/**
		 * Below Code for
		 * Verify Number of Found Center is same
		 */
		
		String res = resNumber.getText();
		System.out.println(res);
		
		String str = resNumber1.getText();
		System.out.println(str);
		
		str.indexOf("at ");
		str.indexOf(" Pine");
		
		String labelName = str.substring(str.indexOf("at ")+1,str.indexOf(" Pine")-1);
		
		if(res.equals(labelName))
		{
			System.out.println("Number of Found Center and Number of Center dispplayed is the same");
		}
		else
		{
			System.out.println("Number of Found Center and Number of Center dispplayed is Different");
		}
		
		test.takesScreenshot(); // Takes Screenshot
		
		/**
		 * Below Code for
		 * Click on the first center of the list 
		 * And Verify Center name and address are the same
		 */
		
		firstCenterList.click();
		
		String firstEle = firstCenterEle.getText();
		String secondEle = firstCenterList.getText();
		
		if(firstEle.equals(secondEle))
		{
			System.out.println(firstEle + " -Center Name and Address are same- " + secondEle);
		}
		else
		{
			System.out.println(firstEle + " -Center Name and Address both are not same- " + secondEle);
		}
		test.takesScreenshot(); // Takes Screenshot
		
	}

}
