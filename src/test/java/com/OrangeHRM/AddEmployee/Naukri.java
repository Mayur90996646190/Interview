package com.OrangeHRM.AddEmployee;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naukri {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Got it']")).click();
		driver.findElement(By.xpath("//img[@src=\"https://static.naukimg.com/s/0/0/i/new-homepage/android-app_v1.png\"]")).click();
		driver.findElement(By.xpath("//img[@src=\"https://static.naukimg.com/s/0/0/i/new-homepage/ios-app_v1.png\"]")).click();
		String curr = driver.getWindowHandle();
		driver.close();
		Set<String> allwh = driver.getWindowHandles();
		for(String wh:allwh) {
			if(!curr.equals(wh)) {
			}else
			{
				driver.switchTo().window(wh);
			}
		}
		
	}
}

