package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pom.EnterTimeTrack;
import com.actitime.pom.LoginPage;

public class BaseClass {
	static 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public WebDriver driver;
	public FileLib f=new FileLib();
	//WebDriverCommonLib w=new WebDriverCommonLib();
	@BeforeClass
	public void openBrowser() throws Exception
	{
		String BrowserName = f.getPropertyData("browser")	;	
		if(BrowserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();	
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
	@BeforeMethod
	public void loginApp() throws Exception {

		String URL = f.getPropertyData("url");
		String USERNAME = f.getPropertyData("username");
		String PASSWORD =f.getPropertyData("password");
		driver.get(URL);
		LoginPage l=new LoginPage(driver);
		l.setUser(USERNAME, PASSWORD);
	}
	@AfterMethod
	public void logoutApp() throws Exception {
		EnterTimeTrack e=new EnterTimeTrack(driver);
		e.logoutClick();
	}
}
