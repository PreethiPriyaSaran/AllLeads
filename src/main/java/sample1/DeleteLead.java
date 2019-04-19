package sample1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("Demosalesmanager", Keys.TAB);
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByXPath(
				"//label[text()='Email Address:']/following::input[@class=' x-form-text x-form-field']")
				.sendKeys("preethisamy.95@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
	
		Thread.sleep(5000);
		WebElement text = driver.findElementByXPath("(//*[@class='linktext'])[4]");
		String Leadnumber = text.getText();
		System.out.println(Leadnumber);
		driver.findElementByXPath("(//*[@class='linktext'])[4]").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//a[text()='Delete']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys(Leadnumber);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		String text1 = driver.findElementByClassName("x-paging-info").getText();
		if (text1.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}

	}

}
