package com.it.bd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.basedrivers.BaseDriver;
import com.it.bd.pages.DashBoardPage;
import com.it.bd.utilities.ExtentFactory;

public class DashBoardTest extends BaseDriver {
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {
		//PageDriver.getCurrentDriver().get(url);
		//Thread.sleep(5000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>ORANGE HRM Admin</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}

	@Test
	public void adminTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>ADMIN</b></p>");
		DashBoardPage boardPage = new DashBoardPage(childTest);
		boardPage.admin();
		
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}

}
