package createlead;

import org.testng.annotations.Test;

public class CreateLead extends ProjectMethods {

	@Test
	public void cLead1() {
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("Syntel");
		driver.findElementById("createLeadForm_firstName").sendKeys("Preethi");
		driver.findElementById("createLeadForm_lastName").sendKeys("Periyasamy");
		driver.findElementByName("submitButton").click();
	}

}
