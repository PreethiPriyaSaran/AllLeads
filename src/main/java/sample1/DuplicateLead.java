package sample1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

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
		
		
		driver.findElementByXPath("(//*[@class='linktext'])[4]").click();
		Thread.sleep(5000);
		
		WebElement text = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']");
		
		String LeadName = text.getText();
		System.out.println(LeadName);
		driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
		Thread.sleep(5000);
		String Duplicatename = driver.getTitle();
		System.out.println(Duplicatename);
		driver.findElementByXPath("//input[@class='smallSubmit']").click();
		WebElement name = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']");
		String Dupname = name.getText();
		System.out.println(Dupname);
	if(LeadName.equals(Dupname)) {
		System.out.println("Both names are matching");
	}
	driver.close();

	}

}
