package com.Jenkins.Report;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ActitimeTests extends ActitimeExecute{
	
	@Test
	public void create()
	{
		Reporter.log("Create",true);
		ExtentTest test=extent.createTest("This test is for login").assignAuthor("Ricku").assignCategory("Smoke Test").
assignDevice("HP");
		test.log(Status.PASS,"This test case execute properly");
		test.pass("This test case accept credential inputs");
		test.info("It is showing password alerts");
		test.warning("Displaying alerts");
	}
	@Test
	public void modify()
	{
		Reporter.log("Modify",true);
		ExtentTest test=extent.createTest("This test is for login").assignAuthor("Ricku").assignCategory("Smoke Test").
				assignDevice("HP");
						test.log(Status.PASS,"This test case execute properly");
						test.pass("This test case accept credential inputs");
						test.info("It is showing password alerts");
						test.warning("Displaying alerts");
	}

}
