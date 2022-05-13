package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main(String[]args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.switchTo().frame("frame1");
		System.out.println("frame 1 is:" +driver.findElement(By.id("topic")).getText());
		System.out.println("-----------------------------------------------------------");
		driver.findElement(By.xpath("//input")).sendKeys("Frame");
		driver.switchTo().frame("frames3");
		System.out.println("frames3 is:" +driver.findElement(By.xpath("//b")).getText());
		driver.findElement(By.id("a")).click();
		if(driver.findElement(By.id("a")).isSelected())
		{
			System.out.println("the check frames3 is selected");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		System.out.println("---------------------------");
		System.out.println("frame2 is:" +driver.findElement(By.xpath("//b")).getText());
		System.out.println(driver.findElement(By.xpath("//select")).getText());
		driver.findElement(By.xpath("//select")).sendKeys("cat");
		driver.close();
		}
		
		
	}


