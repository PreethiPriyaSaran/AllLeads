package sample1;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLeads {

	public static void main(String[] args) {
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
		driver.findElementByXPath("//a[text()='Create Lead']").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("Syntel");
		driver.findElementById("createLeadForm_firstName").sendKeys("Preethi");
		driver.findElementById("createLeadForm_lastName").sendKeys("Periyasamy");
		
		 

		 driver.findElementById("createLeadForm_primaryEmail").sendKeys("preethisamy.95@gmail.com");
		driver.findElementByXPath("//input[@class='smallSubmit']").click();
		driver.close();

	}

}
