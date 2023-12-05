package com.OrangeHRM.genericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import net.bytebuddy.asm.Advice.AllArguments;
import net.bytebuddy.asm.Advice.Argument;

public class WebDriverUtility {

	WebDriver sdriver ;
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implictlyWait(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	public void waitTillElementToBeDisplayed(WebDriver driver, WebElement element, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.presenceOfElementLocated(null));
	}
	public void waitTillElementIsClickable(WebDriver driver,int duration,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void ignoreNoSuchElementexception(WebDriver driver,int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public void movetoelement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}
	
	public void contextClick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}
	
	public void dragAnddrop(WebDriver driver,WebElement src, WebElement target) {
		Actions a  =new Actions(driver);
		a.dragAndDrop(src, target).perform();
	}
	
	public void switchToFrameBasedOnIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameBasedOnId(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}
	
	public void switchToFrameBasedOnElement(WebDriver driver, WebElement elment) {
		driver.switchTo().frame(elment);
	}
	
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void selectDropdown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void selectDropdown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void selectDropdown( String visibleText, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	public void acceptAlert(WebDriver driver, String exp) {
		Alert a = driver.switchTo().alert();
		String act = a.getText();
		if(act.equalsIgnoreCase(exp)) {
			System.out.println("alert is verified");
		}
		else 
			System.out.println("Alert is not verified");
		
		a.accept();
	}
	
	public void dismissAlert(WebDriver driver, String exp) {
		Alert a = driver.switchTo().alert();
		String act = a.getText();
		if(act.equalsIgnoreCase(exp)) {
			System.out.println("alert is verified");
		}
		else 
			System.out.println("Alert is not verified");
		
		a.dismiss();
	}
	
	public void clickOnEnter(WebDriver driver) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	public void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Arguments[0].scrollIntoview",element);
	}
	
	public void scrollToElement(WebElement element,WebDriver driver) {
		Actions a = new Actions(driver);
		a.scrollToElement(element).perform();
	}
	
	public void scrollToElement(WebDriver driver) {
		Actions a = new Actions(driver);
		a.scrollByAmount(300, 300).perform();
	}
	
	public void clickOnEnter1(WebDriver driver) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public static String takeScreenShot(WebDriver driver, String screenshotname) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 String path = ".\\screenshot\\"+screenshotname+".png";
		 File dest = new File(path);
		 try {
		 Files.copy(src, dest);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return path;
	}
	
	
}
