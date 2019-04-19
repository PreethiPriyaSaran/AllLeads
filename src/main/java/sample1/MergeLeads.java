package sample1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeLeads {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("Demosalesmanager", Keys.TAB);
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Merge Leads']").click();
		driver.findElementByXPath("(//span[text()='From Lead'])/following::img[1]").click();
		// System.out.println(driver.getTitle());
		Set<String> allwindows = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<>();
		listOfWindows.addAll(allwindows);
		driver.switchTo().window(listOfWindows.get(1));
		System.out.println(driver.getTitle());
		driver.findElementByXPath("(//input[@type='text'])[1]").sendKeys("10016");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//a[@class='linktext'])[1]").click();
		Thread.sleep(5000);
		driver.switchTo().window(listOfWindows.get(0));
		driver.findElementByXPath("(//span[text()='To Lead'])/following::img[1]").click();
		Thread.sleep(5000);
		// System.out.println(driver.getTitle());
		Set<String> allwindows1 = driver.getWindowHandles();
		List<String> listOfWindows1 = new ArrayList<>();
		listOfWindows1.addAll(allwindows1);
		driver.switchTo().window(listOfWindows1.get(1));
		// System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.findElementByXPath("(//input[@type='text'])[1]").sendKeys("10018");
		Thread.sleep(5000);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//a[@class='linktext'])[1]").click();
		driver.switchTo().window(listOfWindows.get(0));
		// System.out.println(driver.getTitle());
		driver.findElementByXPath("//a[text()='Merge']").click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("(//input[@type='text'])[29]").sendKeys("10016");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		String message = driver.findElementByXPath("//div[text()='No records to display']").getText();
		Thread.sleep(5000);

		System.out.println(message.contains("No records to display"));

		driver.close();

	}
}
