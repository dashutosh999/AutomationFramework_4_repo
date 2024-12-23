package books;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.baseClass;
import objectrepository.HomePage;

public class TC_DWS_005_Test extends baseClass {
	@Test
	public void clickOnBooks() {
		test = extReport.createTest("clickOnBooks");
		hp = new HomePage(driver);
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books", "Books page is not displayed");
		test.log(Status.PASS, "Books page is displayed");

	}

}
