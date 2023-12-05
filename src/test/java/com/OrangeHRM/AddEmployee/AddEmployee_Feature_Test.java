package com.OrangeHRM.AddEmployee;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OrangeHRM.genericUtils.IpathConstants;

public class AddEmployee_Feature_Test {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.propertyFilepath);
		Properties p = new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//click on the PIM
		driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']/descendant::span[2]")).click();
		
		
		//
		//driver.findElement(By.xpath("//label[text()='Employee Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/descendant::input")).sendKeys("Vidya");
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		driver.findElement(By.name("firstName")).sendKeys("Vidya");
		driver.findElement(By.name("middleName")).sendKeys("A");
		driver.findElement(By.name("lastName")).sendKeys("P");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("(//div[text()='-- Select --'])[1]")).sendKeys("Indian");
		driver.findElement(By.xpath("(//div[text()='-- Select --'])[2]")).sendKeys("s");
		driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys("1998-27-01");
//		driver.findElement(By.xpath("(//div[text()='-- Select --'])[2]")).sendKeys("s");
		
		driver.findElement(By.xpath("//p[text()=' * Required']/../button")).click();
		driver.findElement(By.xpath("(//button[text()=' Save '])[2]")).click();
		
	}
}
