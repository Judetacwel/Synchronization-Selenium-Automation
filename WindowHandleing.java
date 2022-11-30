package GK;

import java.util.Set;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleing {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\judet\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		
		
		System.out.println(driver.findElements(By.tagName("a")).size());	//gets number of links in entire page
		WebElement footdriver=driver.findElement(By.id("gf-BIG"));
		System.out.println(footdriver.findElements(By.tagName("a")).size()); 	//gets number of links in the footer 
		
		// Limiting Webdriver Scope and getting number of links in specific area
		WebElement coloumndriver=footdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());
		
		
		// click on each link in the coloumn and check if the pages are opening-
				for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
				{
					
					String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
					
					coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
					Thread.sleep(5000L);
					
				}// opens all the tabs
				Set<String> abc=driver.getWindowHandles();//4
				Iterator<String> it=abc.iterator();
				
				while(it.hasNext())
				{
					
				   driver.switchTo().window(it.next());
				   System.out.println(driver.getTitle());
				
				}
						
			}

		}