package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void main(String[]args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://www.leafground.com/pages/DropDown.html/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement findElement1=driver.findElement(By.id("dropdown1"));
	Select DropDown1=new Select(findElement1);
	DropDown1.selectByVisibleText("selenium");
	WebElement findElement2=driver.findElement(By.name("dropdown2"));
	Select DropDown2=new Select(findElement2);
	DropDown2.selectByValue("2");
	WebElement findElement3=driver.findElement(By.id("dropdown3"));
	Select DropDown3=new Select(findElement3);
	DropDown3.selectByValue("3");
	WebElement findElement4=driver.findElement(By.xpath("//select[@class='dropdown']"));
	Select DropDown4=new Select(findElement4);
	List<WebElement>DropDown4options=DropDown4.getOptions();
	System.out.println("the number of options in the dropdown are :" +DropDown4options.size());
	for(WebElement dropdownoptionval:DropDown4options)
	{
		System.out.println(dropdownoptionval.getText());
	}
	System.out.println("-----------------------------------------------");
	driver.findElement(By.xpath("(//select)[5]")).sendKeys("Loadrunner");
	WebElement findElement5=driver.findElement(By.xpath("(//select)[6]"));
	Select Dropdown5=new Select(findElement5);
	Dropdown5.selectByIndex(2);
	Dropdown5.selectByIndex(3);
	List<WebElement>allSelectoptions=Dropdown5.getAllSelectedOptions();
	for(WebElement selectvalues:allSelectoptions)
	{
		System.out.println(selectvalues.getText());
	}
	driver.close();
	}
	
	
	

}
