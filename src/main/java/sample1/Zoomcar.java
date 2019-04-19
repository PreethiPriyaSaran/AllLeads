package sample1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zoomcar {

	public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Newfolder1/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zoomcar.com/chennai/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Start your wonderful journey']")).click();
		driver.findElement(By.xpath("(//div[@class='items'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		driver.findElement(By.xpath("(//div[@class='day low-price'])[1]")).click();
		String text = driver.findElement(By.xpath("(//div[@class='day picked low-price'])[1]")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		Thread.sleep(5000);
		String text1 = driver.findElement(By.xpath("(//div[@class='day picked low-price'])[1]")).getText();
		System.out.println(text1);
		if (text.equals(text1)) {
			System.out.println("Both are equal");
		}
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		List<WebElement> ls = driver.findElements(By.className("car-listing"));
//System.out.println(ls);
		System.out.println("number of cars" + ls.size());
		List<WebElement> price = driver.findElements(By.className("price"));
		List<String> pricels = new ArrayList<>();
		for (WebElement webElement : price) {
			pricels.add(webElement.getText().replace("\\D", ""));
		}
		Collections.sort(pricels);
		String max = pricels.get(pricels.size() - 1);
//System.out.println(driver.findElement(By.xpath("(//div[contains(text(), "' + max + '")])/preceding::h3[1]")).getText());
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("(//div[contains(text(), '322')])/preceding::h3[1]")).getText());
		driver.findElement(By.xpath("//button[text()='BOOK NOW']")).click();
		Thread.sleep(5000);
		driver.close();

	}

}
