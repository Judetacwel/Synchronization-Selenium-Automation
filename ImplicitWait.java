package GK;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\judet\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit wait
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Carrot" };
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim(); // format it to get actual vegetable name
			int a = 0;

			List itemsNeededList = Arrays.asList(itemsNeeded); // convert array into array list for easy search
			if (itemsNeededList.contains(formattedName)) {
				a++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (a == itemsNeeded.length) {
					break;
				}
			}

		}

	}

}