package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow {
	public static void main(String[]args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("Home")).click();
		String windowHandle=driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println("------------------------------------");
		Set<String>windowHandles=driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String>windowHandlesList=new ArrayList<String>(windowHandles);
		String newWindowHandle=windowHandlesList.get(1);
		System.out.println("----------------------------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("------------------------------------------------------");
		driver.switchTo().window(newWindowHandle);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("--------------------------------------------------");
		driver.switchTo().window(windowHandlesList.get(0));
		System.out.println(driver.getCurrentUrl());
		
	}

}
