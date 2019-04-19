package sample1;

import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("Demosalesmanager",Keys.TAB);
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByXPath("//label[text()='Email Address:']/following::input[@class=' x-form-text x-form-field']").sendKeys("preethisamy.95@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//*[@class='linktext'])[4]").click();
		Thread.sleep(5000);
        String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(3000);
		driver.findElementByXPath("//a[text()='Edit']").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("TCS");
		Thread.sleep(5000);
		driver.findElementByXPath("//input[@class='smallSubmit']").click();
		
		Thread.sleep(5000);
		WebElement element = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']");
		if (element.isDisplayed()) {
			System.out.println("Is displayed");
			}
			else {
			System.out.println("not displayed");
			}
		Thread.sleep(5000);
	     driver.close();
		


	}

}
