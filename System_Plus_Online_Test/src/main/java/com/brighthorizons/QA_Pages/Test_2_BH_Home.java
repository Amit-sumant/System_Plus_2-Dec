package com.brighthorizons.QA_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.brighthorizons.QA_ParentTest.TestBase;
import com.brighthorizons.Utility.Test_Utility;

public class Test_2_BH_Home extends TestBase
{
	@FindBy (xpath="(//ul[@class='nav-list-wrap']//li[@class='nav-item displayed-desktop utility-nav-item']/a[@role='button'])[1]")
	WebElement searchIcon;
	
	@FindBy (xpath="(//input[@id='search-field'])[2]")
	WebElement searchText;
	
	@FindBy (xpath="(//button[@type='submit' and contains(text(),'Search')])[1]")
	WebElement btnSubmit;
	
	@FindBy (xpath="//h3[@class='title' and contains(text(),'Employee Education in 2018: Strategies to Watch')]")
	WebElement searchResult;
	
	Test_Utility test=new Test_Utility();

	public Test_2_BH_Home() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	public void HomePage2() throws IOException
	{
		/**
		 * Check Search Icon field is visible and then Click on the same.
		 */
		
		boolean sicon = searchIcon.isDisplayed();
		System.out.println(sicon);
		searchIcon.click();
		test.takesScreenshot(); //taking a screenshot
		
		searchText.sendKeys("Employee Education in 2018: Strategies to Watch");
		btnSubmit.click();
		
		String res = searchResult.getText();
		System.out.println(res);
		
		test.takesScreenshot(); //taking a screenshot
		
	}

}