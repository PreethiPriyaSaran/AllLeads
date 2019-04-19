package sample1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("email").sendKeys("preethisamy.95@gmail.com");
		Thread.sleep(1000);
		driver.findElementById("pass").sendKeys("preethisamy");
		Thread.sleep(1000);
		driver.findElementByXPath("//input[@type='submit']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@class=\"_1frb\"]").clear();
		driver.findElementByXPath("//*[@class=\"_1frb\"]").sendKeys("TestLeaf");
		System.out.println("Entered text in search box");
		// (.//input[@type='text'])[1]
		driver.findElementByXPath("(//button[@type='submit'])[1]").click();
		Thread.sleep(1000);
		System.out.println("clicked on search icon");
		driver.findElementByXPath("(//*[@class=\"_4jq5\"])[7]").click();
		Thread.sleep(1000);
		System.out.println("clicked on place");
		String bodyText = driver.findElement(By.xpath("//a[text()='TestLeaf']")).getText();
		System.out.println("Getting text");
		if (bodyText.contains("TestLeaf")) {

			System.out.println("TestLeaf is present");

		} else {

			System.out.println("TestLeaf is not present");
		}
		Thread.sleep(5000);
		String click = driver.findElementByXPath("(//button[@type='submit'])[3]").getText();
		if (click.equals("Liked")) {
			System.out.println("Already selected");
		} else if (click.equals("Like")) {
			driver.findElementByXPath("(//button[@type='submit'])[3]").click();
			System.out.println("Like is clicked");

		} else {
			System.out.println("nothing clicked");
		}

		driver.findElement(By.xpath("//a[text()='TestLeaf']")).click();
		String title = driver.getTitle();
		System.out.println("title" + title);
		if (title.contains("TestLeaf")) {
			System.out.println("TestLeaf is Present");
		}
		
		Thread.sleep(3000);
		driver.close();

	}

}
