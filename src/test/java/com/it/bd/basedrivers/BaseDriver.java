package com.it.bd.basedrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	protected static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    
	WebDriver driver;
	
	@BeforeSuite
	public void startBrowser() {
		String browserName = System.getProperty("browser", "firefox");
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
					
		}
		PageDriver.getInstance().setDriver(driver);
	}
	@AfterSuite
	public void close() {
		driver.close();
	}

}
