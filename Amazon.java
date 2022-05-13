package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[]args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9pro",Keys.ENTER);
		String priceoftheproduct=driver.findElement(By.xpath("(//div[@class='a-section'])[1]//span[@class='a-price-whole']")).getText();
		System.out.println(priceoftheproduct);
		System.out.println(driver.findElement(By.xpath("//div//span[text()='RESULTS']//following::span[contains(text(),'stars')[1]")).getText());
		driver.findElement(By.xpath("//div//span[text()='RESULTS']//following::h2[1]//a")).click();
		List<String>windowHandleslist2=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandleslist2.get(1));
		File srcfile=driver.getScreenshotAs(OutputType.FILE);
		File snapsfile=new File("./snaps/Amazon.png");
		FileUtils.copyFile(srcfile, snapsfile);
		if(FileUtils.getFile(snapsfile).exists())
		{
			System.out.println("the screenshot is taken");
		}
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		String cartvalue=driver.findElement(By.xpath("//span//b[contains(text(),'Cart cubtotal')]//following::span//span")).getText();
		if(cartvalue.replaceAll("\\D", "").contains(priceoftheproduct.replaceAll("\\D", "")))
		{
			System.out.println("the cart price is matched");
		}
		driver.quit();
		}
		

}
