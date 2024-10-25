package qeagleWeek3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assessment_cartify {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.cartify.pk/");
		driver.findElement(By.xpath("//span[text()='Shop By Categories']")).click();
		driver.findElement(By.xpath("//div[contains(text(), 'Cloth Rack')]")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement floorClick = driver.findElement(By.xpath("//span[text()='Floor-Standing Cloth Rack With Wheels']"));
		js.executeScript("arguments[0].click();", floorClick);
		driver.findElement(By.xpath("//span[contains(text(), 'Add to cart')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='cart-popup__cta-link btn btn--secondary-accent']")).click();
		String priceValue = driver.findElement(By.xpath("//span[text()='Rs.10,500.00 PKR']")).getText();
		System.out.println("The subtotal price: "+priceValue);

		driver.quit();

	}

}
