package com.Jenkins.Report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeExecute {
	ExtentReports extent=new ExtentReports();
	ExtentSparkReporter spark=new ExtentSparkReporter("MyExtentReport.html");
	File conf=new File("Extent_config.xml");
	WebDriver driver;
	@BeforeClass
	public void open()
	{
		Reporter.log("Open",true);
		extent.attachReporter(spark);
		if(System.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(System.getProperty("browser").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();	
			driver=new EdgeDriver();
		}
	}
	@BeforeMethod
	public void login()
	{
		Reporter.log("Login",true);
		driver.get(System.getProperty("url"));
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("Logout",true);
	}
	@AfterClass
	public void close() throws IOException
	{
		Reporter.log("Close",true);
		extent.flush();
		Desktop.getDesktop().browse(new File("MyextentReport.html").toURI());
	}
}
