package com.OrangeHRM.genericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseClass {
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public DatabaseUtility dLib = new DatabaseUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite
	public void configBS() throws SQLException {
		dLib.connectToDB(IpathConstants.excelpath, IpathConstants.dbUsername, IpathConstants.dbPassword);
		System.out.println("connect to DB");
	}
	
	@BeforeClass
	public void configBC() throws IOException {
		String BROWSER = fLib.getPropertyKayAndValue("browser");
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		sdriver = driver;
		wLib.implictlyWait(driver, 10);
		wLib.maximizeTheBrowser(driver);
	}
	
	@BeforeMethod
	public void configBM() throws IOException {
		
		String USERNAME = fLib.getPropertyKayAndValue("username");
		String PASSWORD = fLib.getPropertyKayAndValue("password");
		//login
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//click on the PIM
		driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']/descendant::span[2]")).click();
	}
	
	@AfterMethod
	public void configAM() {
		//logout.click();
	}
	
	@AfterClass
	public void configAC() {
		driver.close();
	}
	
	@AfterSuite
	public void configAS() throws SQLException {
		dLib.disconnectDB();
	}
	
	
}
