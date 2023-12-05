package practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calculator {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		String ele = driver.findElement(By.cssSelector("g:hover")).getText();
		System.out.println(ele+"from cursor");
		List<WebElement> allElement = driver.findElements(By.xpath("//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']/descendant::*[name()='tspan']"));
		for (WebElement w : allElement) {
			String text = w.getText();
			System.out.println(text);
		}
		driver.close();
	}
}
