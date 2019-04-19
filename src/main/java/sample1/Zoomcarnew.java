package sample1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zoomcarnew {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.zoomcar.com/chennai/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//a[text()='Start your wonderful journey']").click();

		driver.findElementByXPath("(//div[@class='items'])[1]").click();
		driver.findElementByXPath("//button[text()='Next']").click();
		driver.findElementByXPath("(//div[@class='day low-price'])[1]").click();
		String text = driver.findElementByXPath("(//div[@class='day picked low-price'])[1]").getText();
		System.out.println(text);
		driver.findElementByXPath("//button[text()='Next']").click();
		Thread.sleep(5000);
		String text1 = driver.findElementByXPath("(//div[@class='day picked low-price'])[1]").getText();
		System.out.println(text1);
		if (text.equals(text1)) {
			System.out.println("Both are equal");
		}
		driver.findElementByXPath("//button[text()='Done']").click();
		List<WebElement> ls = driver.findElementsByClassName("car-listing");
//System.out.println(ls);
		System.out.println("number of cars" + ls.size());
		List<WebElement> price = driver.findElementsByClassName("price");
		List<String> pricels = new ArrayList<>();
		for (WebElement webElement : price) {
			pricels.add(webElement.getText().replace("\\D", ""));
		}
		Collections.sort(pricels);
		String max = pricels.get(pricels.size() - 1);
//System.out.println(driver.findElement(By.xpath("(//div[contains(text(), "' + max + '")])/preceding::h3[1]")).getText());
		Thread.sleep(5000);
		System.out.println(driver.findElementByXPath("(//div[contains(text(), '341')])/preceding::h3[1]").getText());
		driver.findElementByXPath("//button[text()='BOOK NOW']").click();
		Thread.sleep(5000);
		driver.close();

	}

}
