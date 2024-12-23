package computer;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.baseClass;
import genericutility.listenerUtility;
import objectrepository.HomePage;

@Listeners(listenerUtility.class)
public class TC_DWS_006_Test extends baseClass {
	@Test
	public void clickOnComputers() {
		test = extReport.createTest("clickOnComputers()");
		hp = new HomePage(driver);
		hp.getComputersLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Computers", "Computers page is not displayed");
		test.log(Status.PASS, "Computers page is displayed");

	}

}
