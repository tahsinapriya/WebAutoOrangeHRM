package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.basedrivers.PageDriver;
import com.it.bd.utilities.GetScreenShot;

public class DashBoardPage {
	ExtentTest test;

	public DashBoardPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]")
	WebElement admin;
	
	public void failCase(String message, String scName) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
	}
	
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	public void admin() throws IOException {
		try {
			test.info("Click on admin");
			if(admin.isDisplayed()) {
				admin.click();
				Thread.sleep(10000);
				passCaseWithSC("Clicked", "adminpass");
			}
		} catch (Exception e) {
			failCase("Admin was not locateable.", "adminfail");
		}
	}
	

}
