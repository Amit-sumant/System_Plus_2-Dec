package com.brighthorizons.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.brighthorizons.QA_ParentTest.TestBase;

public class Test_Utility extends TestBase
{

	public Test_Utility() throws IOException
	{
		super(); // TODO Auto-generated constructor stub
	}
	
	public static long Page_Load_Timeout = 10;
	public static long Implicit_wait = 10;
	
	public void takesScreenshot() throws IOException
	{
		File srcTarget = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trgFile=new File(".\\Screenshots\\\"+fileName +\".png\"");
		
		FileUtils.copyDirectory(srcTarget, trgFile);
	}
	
}
